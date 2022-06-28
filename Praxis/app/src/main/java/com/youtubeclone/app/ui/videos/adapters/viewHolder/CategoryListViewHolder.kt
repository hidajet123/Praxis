package com.youtubeclone.app.ui.videos.adapters.viewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.youtubeclone.app.R
import com.youtubeclone.app.ui.videos.items.CategoryListItem

class CategoryListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val recyclerView: RecyclerView = itemView.findViewById(R.id.recyclerView)

    fun bind(categoryListItem: CategoryListItem) {
        recyclerView.adapter = categoryListItem.adapter
    }
}