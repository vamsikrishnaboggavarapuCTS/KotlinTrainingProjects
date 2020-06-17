package views.MyWall

import Util.Constants
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinsample.R
import com.example.kotlinsample.databinding.MywallRecycleimageitemBinding
import com.example.kotlinsample.databinding.MywallRecyletextitemBinding
import models.MyWallModelItem
import models.MyWallUIModel


class MyWallAdapter(private val mywall :List<MyWallUIModel?>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val Image_Card : Int = 0
    private val Text_Card: Int = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        if (viewType == Image_Card) {
            return ImageViewHolder(
                DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.mywall_recycleimageitem,
                    parent,
                    false
                )
            )
        }
        else{
            return TextViewHolder(
                DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.mywall_recyletextitem,
                    parent,
                    false
                )
            )
        }
    }

    override fun getItemCount(): Int {
        return mywall.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == Image_Card)
            (holder as ImageViewHolder).mywallRecycleimageitemBinding.mywall = mywall[position]
        else
            (holder as TextViewHolder).mywallRecyletextitemBinding.mywall = mywall[position]
    }

    override fun getItemViewType(position: Int): Int {
        return if (mywall[position]?.postType == Constants.imageText) Image_Card else Text_Card
    }


    inner class ImageViewHolder(val mywallRecycleimageitemBinding: MywallRecycleimageitemBinding):RecyclerView.ViewHolder(mywallRecycleimageitemBinding.root){

    }

    inner class TextViewHolder(val mywallRecyletextitemBinding: MywallRecyletextitemBinding):RecyclerView.ViewHolder(mywallRecyletextitemBinding.root){

    }
}