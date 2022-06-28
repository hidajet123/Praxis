package com.youtubeclone.app.ui.videos.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.youtubeclone.app.R
import com.youtubeclone.app.data.model.Category
import com.youtubeclone.app.ui.videos.VideosCallback
import com.youtubeclone.app.ui.videos.adapters.viewHolder.CategoryViewHolder
import com.youtubeclone.app.utils.inflateView

class CategoryAdapter(
    val list: List<Category>,
    val callback: VideosCallback?
) : RecyclerView.Adapter<CategoryViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryViewHolder {
        val view = parent.inflateView(R.layout.category_item)
        return CategoryViewHolder(view, callback)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(list.get(position))
    }
}