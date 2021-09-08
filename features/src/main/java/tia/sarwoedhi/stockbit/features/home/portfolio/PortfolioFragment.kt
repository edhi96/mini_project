package tia.sarwoedhi.stockbit.features.home.portfolio

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sarwoedhi.features.R
import org.koin.android.viewmodel.ext.android.viewModel

class PortfolioFragment : Fragment() {
    private val viewModel: PortfolioViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_portfolio, container, false)
    }

}