package tia.sarwoedhi.stockbit.features.home.watch_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sarwoedhi.features.R
import org.koin.android.viewmodel.ext.android.viewModel


class WatchListFragment : Fragment() {
    private val viewModel: WatchListViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_watch_list, container, false)
    }

}