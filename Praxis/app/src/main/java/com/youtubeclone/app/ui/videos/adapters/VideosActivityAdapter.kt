package com.youtubeclone.app.ui.videos.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.youtubeclone.app.R
import com.youtubeclone.app.ui.videos.adapters.viewHolder.CategoryListViewHolder
import com.youtubeclone.app.ui.videos.adapters.viewHolder.VideoListViewHolder
import com.youtubeclone.app.ui.videos.items.BaseVideoItem
import com.youtubeclone.app.ui.videos.items.CategoryListItem
import com.youtubeclone.app.ui.videos.items.VideoListItem
import com.youtubeclone.app.utils.inflateView

class VideosActivityAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val list: ArrayList<BaseVideoItem> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            ViewType.CATEGORIES.ordinal -> {
                val view = parent.inflateView(R.layout.category_list_item)
                return CategoryListViewHolder(view)
            }
            ViewType.VIDEOS.ordinal -> {
                val view = parent.inflateView(R.layout.video_list_item)
                return VideoListViewHolder(view)
            }
            else -> throw IllegalArgumentException("ViewType not implemented")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is CategoryListViewHolder -> {
                holder.bind(list.get(position) as CategoryListItem)
            }
            is VideoListViewHolder -> {
                holder.bind(list.get(position) as VideoListItem)
            }
        }
    }

    override fun getItemCount() = list.size

    override fun getItemViewType(position: Int): Int {
        return when (list.get(position)) {
            is CategoryListItem -> ViewType.CATEGORIES.ordinal
            is VideoListItem -> ViewType.VIDEOS.ordinal
            else -> throw IllegalArgumentException("ViewType not implemented")
        }
    }

    fun addItem(item: BaseVideoItem) {
        list.add(item)
        notifyItemInserted(list.size + 1)
    }

    enum class ViewType {
        CATEGORIES,
        VIDEOS
    }
}