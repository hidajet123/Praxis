package com.youtubeclone.app.ui.videos.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.youtubeclone.app.R
import com.youtubeclone.app.data.model.Video
import com.youtubeclone.app.ui.videos.VideosCallback
import com.youtubeclone.app.ui.videos.adapters.viewHolder.VideoViewHolder
import com.youtubeclone.app.utils.inflateView

class VideoAdapter(
    val videos: List<Video>,
    val callback: VideosCallback?
) : RecyclerView.Adapter<VideoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val view = parent.inflateView(R.layout.video_item)
        return VideoViewHolder(view)
    }

    override fun getItemCount() = videos.size

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        holder.bind(videos.get(position), callback)
    }
}