package com.youtubeclone.app.ui.videos

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.youtubeclone.app.R
import com.youtubeclone.app.data.model.Category
import com.youtubeclone.app.data.model.Video
import com.youtubeclone.app.ui.AppSharedPreferences
import com.youtubeclone.app.ui.account.AccountActivity
import com.youtubeclone.app.ui.login.LoginActivity
import com.youtubeclone.app.ui.player.VideoPlayerActivity
import com.youtubeclone.app.ui.videos.adapters.VideosActivityAdapter
import com.youtubeclone.app.ui.videos.items.CategoryListItem
import com.youtubeclone.app.ui.videos.items.VideoListItem

class VideosActivity : AppCompatActivity(), VideosPresenter.View, VideosCallback {

    private lateinit var recyclerView: RecyclerView
    private lateinit var presenter: VideosPresenter
    private val adapter = VideosActivityAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_videos)
        setupUI()
        init()
    }

    private fun setupUI() {
        setSupportActionBar(findViewById(R.id.toolbar))
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.adapter = adapter
    }

    private fun init() {
        presenter = VideosPresenter(this)
        presenter.loadCategories()
    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }

    override fun showCategories(list: List<Category>) {
        if (list != null) {
            val categoryListItem = CategoryListItem(list, this)
            adapter.addItem(categoryListItem)
        }
    }

    override fun showVideos(list: List<Video>) {
        val videoListItem = VideoListItem(list, this)
        adapter.addItem(videoListItem)
    }

    override fun onCategoryClick(category: Category) {

    }

    override fun onVideoClick(video:Video) {
        val intent = Intent(this, VideoPlayerActivity::class.java)
        val bundle = Bundle()
        bundle.putString("video", Gson().toJson(video))
        intent.putExtra("bundle", bundle)
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.account) {
            if (AppSharedPreferences(this).getValueString("token") != null) {
                val intent = Intent(this, AccountActivity::class.java)
                startActivity(intent)
            } else {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}