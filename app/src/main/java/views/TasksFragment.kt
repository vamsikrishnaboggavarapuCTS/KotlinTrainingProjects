package views

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.util.Executors

import com.example.kotlinsample.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.tasks_fragment.*
import viewmodels.TasksViewModel

class TasksFragment : Fragment() {

    private lateinit var viewModel: TasksViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.tasks_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(TasksViewModel::class.java)

        btnTask1.setOnClickListener {

   }
    }

}
