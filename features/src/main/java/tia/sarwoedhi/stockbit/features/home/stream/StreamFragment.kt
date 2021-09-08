package tia.sarwoedhi.stockbit.features.home.stream

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sarwoedhi.features.R
import org.koin.android.viewmodel.ext.android.viewModel

class StreamFragment : Fragment() {

    private val viewModel: StreamViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_stream, container, false)
    }

}