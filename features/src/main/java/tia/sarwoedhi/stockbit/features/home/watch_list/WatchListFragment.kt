/**
 * created by Tia Sarwoedhi on 10/9/2021
 **/

package tia.sarwoedhi.stockbit.features.home.watch_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.sarwoedhi.features.R
import com.sarwoedhi.features.databinding.FragmentWatchListBinding
import org.koin.android.viewmodel.ext.android.viewModel
import tia.sarwoedhi.stockbit.common.extension.setVisibility
import tia.sarwoedhi.stockbit.common.extension.showSnackbar
import tia.sarwoedhi.stockbit.features.home.watch_list.adapter.WatchListAdapter
import tia.sarwoedhi.stockbit.repository.coin.CryptoEntity
import tia.sarwoedhi.stockbit.repository.utils.Resource

class WatchListFragment : Fragment() {

    private val viewModel: WatchListViewModel by viewModel()
    private var cryptoList = mutableListOf<CryptoEntity>()
    private lateinit var watchListAdapter: WatchListAdapter
    private lateinit var binding: FragmentWatchListBinding
    private var isLoading = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWatchListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toolbarWatchList.ivAction.setImageResource(R.drawable.ic_login)
        binding.toolbarWatchList.tvTitle.text = getString(R.string.watch_list)
        initCryptoLayout()
        loadCrypto()
        initAction()
        initListener()
    }

    private fun initAction() {
        binding.toolbarWatchList.ivAction.setOnClickListener {
            logout()
        }
        binding.pullRefresh.setOnRefreshListener {
            cryptoList.clear()
            binding.progessBarWatchList.setVisibility(true)
            viewModel.refreshCoins()
            binding.pullRefresh.isRefreshing = false
        }
    }

    private fun initCryptoLayout() {
        watchListAdapter = WatchListAdapter(cryptoList)
        binding.rvCryptoData.apply {
            adapter = watchListAdapter
            layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
            isNestedScrollingEnabled = false
        }
    }

    private fun logout() {
        viewModel.doLogout().observe(viewLifecycleOwner, {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    findNavController().navigate(R.id.loginFragment)
                }
                Resource.Status.LOADING -> { }
                Resource.Status.ERROR -> { }
            }
        }
        )
    }

    private fun loadCrypto() {
        val coinListViewModel = viewModel.cryptoResult
        coinListViewModel.observe(viewLifecycleOwner, {
            binding.progessBarWatchList.visibility = View.GONE
            binding.tvInformation.visibility = View.GONE
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    isLoading = false
                    cryptoList.addAll(it.data ?: mutableListOf())
                    viewModel.updatePageNumber()
                    binding.rvCryptoData.setVisibility(true)
                }
                Resource.Status.LOADING -> {
                    isLoading = true
                    binding.progessBarWatchList.setVisibility(true)
                }
                Resource.Status.ERROR -> {
                    isLoading = false
                    binding.tvInformation.text = it.error?:""
                    binding.tvInformation.visibility = View.VISIBLE
                    showSnackbar(it.error ?: "Unknown Error", Snackbar.LENGTH_SHORT)
                    binding.rvCryptoData.setVisibility(false)
                }
            }
            watchListAdapter.notifyDataSetChanged()
        })
    }


    private fun initListener() {
        binding.rvCryptoData.setOnScrollChangeListener { _, _, _, _, _ ->
            val linearLayoutManager =  binding.rvCryptoData.layoutManager as LinearLayoutManager
            val countItem = linearLayoutManager.itemCount
            val lastVisiblePosition = linearLayoutManager.findLastCompletelyVisibleItemPosition()
            val isLastPosition = countItem.minus(1) == lastVisiblePosition
            if (!isLoading && isLastPosition) {
                viewModel.fetchPage()
            }
        }
    }

}


