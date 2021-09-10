/**
 * created by Tia Sarwoedhi on 10/9/2021
 **/

package tia.sarwoedhi.stockbit.features.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.sarwoedhi.features.R
import com.sarwoedhi.features.databinding.FragmentLoginBinding
import org.koin.android.viewmodel.ext.android.viewModel
import tia.sarwoedhi.stockbit.common.extension.setVisibility
import tia.sarwoedhi.stockbit.common.extension.showSnackbar
import tia.sarwoedhi.stockbit.repository.utils.Resource


class LoginFragment : Fragment() {

    private val loginViewModel: LoginViewModel by viewModel()

    private lateinit var binding : FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initAction()
        loginViewModel.run { isLogin().observe(
                viewLifecycleOwner, {
                    when (it.status) {
                        Resource.Status.SUCCESS -> {
                            if (findNavController().currentDestination?.id == R.id.loginFragment) {
                                findNavController().navigate(R.id.action_loginFragment_to_watchListFragment)
                            }
                        }
                        Resource.Status.LOADING -> {
                        }
                        Resource.Status.ERROR -> {
                        }
                    }
                }
            )
        }
    }

    private fun initView(){
        binding.toolbarLogin.ivNav.setVisibility(false)
        binding.toolbarLogin.ivAction.setVisibility(false)
        binding.toolbarLogin.tvTitle.text = getString(R.string.masuk_login)
    }

    private fun initAction(){
        binding.btnLogin.setOnClickListener {
            validation()
        }
    }

    private fun validation(){
        if (binding.etUserName.text.toString().isNotBlank() && binding.etUserName.text.toString().isNotEmpty() &&
            binding.etPassword.text.toString().isNotBlank() && binding.etPassword.text.toString().isNotEmpty()) {
            loginViewModel.doLogin().observe(
                viewLifecycleOwner, {
                    when (it.status) {
                        Resource.Status.SUCCESS -> {
                            if (findNavController().currentDestination?.id == R.id.loginFragment) {
                                findNavController().navigate(R.id.action_loginFragment_to_watchListFragment)
                            }
                        }
                        Resource.Status.LOADING -> { }
                        Resource.Status.ERROR -> { }
                    }
                }
            )
        }else{
            showSnackbar("The username / email field is required\nThe password field is required",Snackbar.LENGTH_SHORT)
        }
    }
}