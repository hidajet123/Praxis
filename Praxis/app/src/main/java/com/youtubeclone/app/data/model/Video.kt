package com.youtubeclone.app.data.model

import java.util.*


data class Result(val totalitems: Int, val data: Data)
data class Data(val count: Int, val rows: List<Video>)
data class Video(
    val id: Int,
    val title: String,
    val url: String,
    val thumbnail: String,
    val views: Int,
    val videoDuration: Double,
    val description: String,
    val uploadDate: String,
    val createdAt: String,
    val updatedAt: String,
    val UserId: Int,
    val categoryVideoId: Int
)

