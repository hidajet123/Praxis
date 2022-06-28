package com.youtubeclone.app.ui.videos.items

import com.youtubeclone.app.data.model.Category
import com.youtubeclone.app.ui.videos.VideosCallback
import com.youtubeclone.app.ui.videos.adapters.CategoryAdapter

class CategoryListItem(list: List<Category>, callback: VideosCallback?) : BaseVideoItem() {

    var adapter: CategoryAdapter? = null

    init {
        adapter = CategoryAdapter(list, callback)
    }
}