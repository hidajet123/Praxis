package com.youtubeclone.app.ui.videos

import com.youtubeclone.app.data.model.Category
import com.youtubeclone.app.data.model.Video
import com.youtubeclone.app.data.network.YouTubeApiService
import retrofit2.Call
import retrofit2.Response
import com.youtubeclone.app.data.model.Result

class VideosPresenter(view: View) {

    private var mainView: View = view

    fun loadCategories() {
        val api = YouTubeApiService.create()
        api.getCategories().enqueue(object : retrofit2.Callback<List<Category>> {
            override fun onFailure(call: Call<List<Category>>, t: Throwable) {
                mainView.showError(t.message.toString())
            }

            override fun onResponse(
                call: Call<List<Category>>,
                response: Response<List<Category>>
            ) {
            //    mainView.showCategories(response.body()!!)

            }

        })
        loadVideos()
    }

    fun loadVideos() {
        val api = YouTubeApiService.create()
        api.getVideos()
            .enqueue(object : retrofit2.Callback<Result> {
                override fun onFailure(
                    call: Call<Result>,
                    t: Throwable
                ) {
                    mainView.showError(t.message.toString())
                }

                override fun onResponse(
                    call: Call<Result>,
                    response: Response<Result>
                ) {
                    if (response.body()?.data?.rows == null) {
                        mainView.showError("Video list = null")
                    } else if (response.body()?.data?.rows!!.isEmpty()) {
                        mainView.showError("Error")
                    } else {
                        mainView.showVideos(response.body()?.data?.rows!!)
                    }

                }
            })
    }

    interface View {
        fun showError(error: String)
        fun showCategories(list: List<Category>)
        fun showVideos(list: List<Video>)
    }
}
