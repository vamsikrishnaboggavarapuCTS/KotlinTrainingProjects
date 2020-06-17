package views

import Util.Constants
import android.content.Intent
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinsample.R
import kotlinx.android.synthetic.main.connects_fragment.*
import models.Data
import network.ConnectsApi
import repositories.ConnectsRepository
import viewmodels.ConnectsViewModel

class ConnectsFragment : Fragment(),ConnectsRecyclerViewClickListener {

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
        viewModel.getConnects()

        viewModel.connects.observe(viewLifecycleOwner, Observer { con ->
            recycler_Connects.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                it.adapter = ConnectsAdapter(con.data,this)
            }
        })
    }

    override fun onRecyclerViewItemClick(view: View, data: Data) {
        when(view.id){
            R.id.imageEmail -> {
               openEmail()
            }
        }
    }

    private fun openEmail(){
        val intent = Intent(Intent.ACTION_SEND)
        intent.type= Constants.emailType
        startActivity(intent)
    }
}
