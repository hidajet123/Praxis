package com.youtubeclone.app.ui.account

import android.content.Context
import com.youtubeclone.app.data.network.YouTubeApiService
import com.youtubeclone.app.data.model.User
import com.youtubeclone.app.ui.AppSharedPreferences
import retrofit2.Call
import retrofit2.Response

class AccountPresenter(view: View) {

    private var mainView = view

    fun userInfo(context: Context) {
        val token = AppSharedPreferences(context).getValueString("token")
        YouTubeApiService.create().getUserInfo("Bearer ${token}")
            .enqueue(object : retrofit2.Callback<User> {
                override fun onFailure(call: Call<User>, t: Throwable) {
                    mainView.showError(t.message.toString())
                }

                override fun onResponse(call: Call<User>, response: Response<User>) {
                    mainView.showUserInfo(response.body())
                }
            })
    }

    interface View {
        fun showError(error: String)
        fun showUserInfo(body: User?)
    }
}