package views

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.kotlinsample.R
import network.ConnectsApi
import repositories.ConnectsRepository
import viewmodels.ConnectsViewModel

class ConnectsFragment : Fragment() {

    private lateinit var viewModel: ConnectsViewModel
    private lateinit var factory: ConnectsViewModelFactory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.connects_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val api = ConnectsApi()
        val repository = ConnectsRepository(api)

        factory = ConnectsViewModelFactory(repository)
        viewModel = ViewModelProviders.of(this, factory).get(ConnectsViewModel::class.java)


    }
}
