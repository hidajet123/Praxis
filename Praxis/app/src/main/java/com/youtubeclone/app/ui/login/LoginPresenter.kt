package com.youtubeclone.app.ui.login

import android.content.Context
import com.youtubeclone.app.R
import com.youtubeclone.app.data.model.Token
import com.youtubeclone.app.data.network.YouTubeApiService
import com.youtubeclone.app.data.network.request_body.LoginBody
import com.youtubeclone.app.ui.AppSharedPreferences
import retrofit2.Call
import retrofit2.Response

class LoginPresenter(view: View) {

    private var mainView = view

    fun validateInputs(username: String, password: String, context: Context) {
        if (username.isEmpty() || password.isEmpty()) {
            mainView.showError(context.getString(R.string.invalid_inputs))
        } else if (password.length < 8) {
            mainView.showError(context.getString(R.string.short_passw))
        } else {
            val apiService = YouTubeApiService.create().login(LoginBody(username, password))
            apiService.enqueue(object : retrofit2.Callback<Token> {

                override fun onFailure(call: Call<Token>, t: Throwable) {
                    mainView.showError(t.message.toString())
                }

                override fun onResponse(call: Call<Token>, response: Response<Token>) {
                    AppSharedPreferences(context).save("token", response.body()?.token)
                    if (response.body()?.token == null) {
                        mainView.showError("Create user")
                    } else {
                        mainView.navigateToHome()
                    }

                }
            })
        }
    }

    interface View {
        fun showError(error: String)
        fun navigateToHome()
    }
}