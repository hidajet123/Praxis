package com.youtubeclone.app.ui.videos.adapters.viewHolder

import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.youtubeclone.app.R
import com.youtubeclone.app.data.model.Category
import com.youtubeclone.app.ui.videos.VideosCallback

class CategoryViewHolder(itemView: View, val callback: VideosCallback?) :
    RecyclerView.ViewHolder(itemView) {

    val button: Button = itemView.findViewById(R.id.button)

    fun bind(category: Category) {
        button.setText(category.title)
        button.setOnClickListener {
            callback?.onCategoryClick(category)
        }
    }
}