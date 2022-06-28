package com.youtubeclone.app.ui.videos.adapters.viewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.youtubeclone.app.R
import com.youtubeclone.app.ui.videos.items.VideoListItem

class VideoListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val recyclerView: RecyclerView = itemView.findViewById(R.id.recyclerView)

    fun bind(videoListItem: VideoListItem) {
        recyclerView.adapter = videoListItem.adapter
    }
}