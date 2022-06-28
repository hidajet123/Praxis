package com.youtubeclone.app.ui.player

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.MediaController
import android.widget.TextView
import android.widget.VideoView
import com.google.gson.GsonBuilder
import com.youtubeclone.app.R
import com.youtubeclone.app.data.model.Video

class VideoPlayerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_player)
        init()
    }

    fun init() {
        val intent = getIntent().getBundleExtra("bundle")
        val gson = GsonBuilder().create()
        val video = gson.fromJson(intent?.getString("video"), Video::class.java)
        val videoView: VideoView = findViewById(R.id.videoView)
        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)
        videoView.setMediaController(mediaController)
        videoView.setVideoPath(video.url)
        videoView.requestFocus()
        videoView.start()

        val videoName: TextView = findViewById(R.id.video_name)
        videoName.text = (video.title)

        val description: TextView = findViewById(R.id.description)
        description.text = (video.description + " " + this.getString(R.string.video_lbl_views, video.views))



    }
}