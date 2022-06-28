package com.youtubeclone.app.ui.videos.adapters.viewHolder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.youtubeclone.app.R
import com.youtubeclone.app.data.model.Video
import com.youtubeclone.app.ui.videos.VideosCallback
import com.youtubeclone.app.utils.loadFromUrl
import java.text.SimpleDateFormat

class VideoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val img: ImageView = itemView.findViewById(R.id.imageView)
    val logo: ImageView = itemView.findViewById(R.id.logoView)
    val name: TextView = itemView.findViewById(R.id.name)
    val views: TextView = itemView.findViewById(R.id.views)
    val releaseDate: TextView = itemView.findViewById(R.id.releaseDate)

    fun bind(video: Video, callback: VideosCallback?) {
        val format = SimpleDateFormat("yyyy-MM-dd")
        name.text = (video.title)
        val viewsString = views.context.getString(R.string.video_lbl_views, video.views)
        views.text = (viewsString)
        releaseDate.text = (format.format(format.parse(video.uploadDate)))
        img.loadFromUrl(video.thumbnail)
        //logo.loadFromUrl(video?.logo)
        itemView.setOnClickListener {
            callback?.onVideoClick(video)
        }
    }
}