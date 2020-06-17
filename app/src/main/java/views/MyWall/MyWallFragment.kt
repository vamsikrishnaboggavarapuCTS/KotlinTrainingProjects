package views.MyWall

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.kotlinsample.R
import kotlinx.android.synthetic.main.my_wall_fragment.*
import kotlinx.coroutines.runBlocking
import network.MyWallApi
import repositories.MyWallRepository
import viewmodels.MyWallViewModel

class MyWallFragment : Fragment() {

    private lateinit var viewModel: MyWallViewModel
private lateinit var factory:MyWallViewModelFactory
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.my_wall_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val api = MyWallApi()

        val repository = MyWallRepository(api)

        factory = MyWallViewModelFactory(repository)
        viewModel = ViewModelProviders.of(this, factory).get(MyWallViewModel::class.java)
            //viewModel.preData()

        runBlocking{
            viewModel.prepareData()
        }

        viewModel.mywalls.observe(viewLifecycleOwner, Observer { con ->
            mywall_recycler.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                it.adapter = MyWallAdapter(con)
            }
        })



    }

}
