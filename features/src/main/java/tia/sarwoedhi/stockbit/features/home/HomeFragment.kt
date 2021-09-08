package tia.sarwoedhi.stockbit.features.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sarwoedhi.features.R
import com.sarwoedhi.features.databinding.FragmentHomeBinding
import tia.sarwoedhi.stockbit.features.home.chat.ChatFragment
import tia.sarwoedhi.stockbit.features.home.portfolio.PortfolioFragment
import tia.sarwoedhi.stockbit.features.home.search.SearchFragment
import tia.sarwoedhi.stockbit.features.home.stream.StreamFragment
import tia.sarwoedhi.stockbit.features.home.watch_list.WatchListFragment

class HomeFragment : Fragment() {
    private lateinit var binding : FragmentHomeBinding
    private fun loadFragment(fragment: Fragment): Boolean {
        childFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment_home, fragment)
            .commit()
        return true
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        selectedBottomNav()
        binding.bottomNav.selectedItemId = R.id.watchlistImg
    }

    private fun selectedBottomNav(){
        binding.bottomNav.setOnNavigationItemSelectedListener { p0 ->
            var fragment: Fragment? = null
            when (p0.itemId) {
                R.id.watchlistImg -> fragment = WatchListFragment()
                R.id.streamImg -> fragment = StreamFragment()
                R.id.searchImg -> fragment = SearchFragment()
                R.id.chatImg -> fragment = ChatFragment()
                R.id.portofolioImg -> fragment = PortfolioFragment()
            }
            loadFragment(fragment!!)
        }
    }

}

