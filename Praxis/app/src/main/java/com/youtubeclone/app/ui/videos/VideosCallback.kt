package com.youtubeclone.app.ui.videos

import com.youtubeclone.app.data.model.Category
import com.youtubeclone.app.data.model.Video

interface VideosCallback {
    fun onCategoryClick(category: Category)
    fun onVideoClick(video: Video)
}