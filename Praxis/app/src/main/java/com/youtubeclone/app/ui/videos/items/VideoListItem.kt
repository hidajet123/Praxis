package com.youtubeclone.app.ui.videos.items

import com.youtubeclone.app.data.model.Video
import com.youtubeclone.app.ui.videos.VideosCallback
import com.youtubeclone.app.ui.videos.adapters.VideoAdapter

class VideoListItem(list: List<Video>, callback: VideosCallback?) : BaseVideoItem() {

    var adapter: VideoAdapter? = null

    init {
        adapter = VideoAdapter(list, callback)
    }
}