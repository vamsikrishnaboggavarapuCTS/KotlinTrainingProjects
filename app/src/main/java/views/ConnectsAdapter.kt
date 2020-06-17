package views

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinsample.R
import com.example.kotlinsample.databinding.ConnectsRecycleitemBinding
import models.Data

class ConnectsAdapter(private val connects :List<Data>,
                      private val listener: ConnectsRecyclerViewClickListener): RecyclerView.Adapter<ConnectsAdapter.ConnectsViewHolder>() {

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
        holder.recyclerviewConnectsBinding.imageEmail.setOnClickListener {
            listener.onRecyclerViewItemClick(holder.recyclerviewConnectsBinding.imageEmail, connects[position])
        }
    }

    inner class ConnectsViewHolder(val recyclerviewConnectsBinding: ConnectsRecycleitemBinding):RecyclerView.ViewHolder(recyclerviewConnectsBinding.root)
}