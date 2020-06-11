package views

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinsample.R
import com.example.kotlinsample.databinding.ConnectsRecycleitemBinding
import kotlinx.android.synthetic.main.connects_fragment.view.*
import models.Data

class ConnectsAdapter(private val connects :List<Data>): RecyclerView.Adapter<ConnectsAdapter.ConnectsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConnectsViewHolder =
        ConnectsViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.connects_recycleitem,
                parent,
                false
            )
        )

    override fun getItemCount() = connects.size

    override fun onBindViewHolder(holder: ConnectsViewHolder, position: Int) {
        holder.recyclerviewConnectsBinding.connects = connects[position]
    }

    inner class ConnectsViewHolder(val recyclerviewConnectsBinding: ConnectsRecycleitemBinding):RecyclerView.ViewHolder(recyclerviewConnectsBinding.root)
}