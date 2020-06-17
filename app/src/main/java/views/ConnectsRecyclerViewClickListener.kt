package views

import android.view.View
import models.Data

interface ConnectsRecyclerViewClickListener {
    fun onRecyclerViewItemClick(view: View, data: Data)
}