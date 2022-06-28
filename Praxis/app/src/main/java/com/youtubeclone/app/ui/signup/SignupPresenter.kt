package com.youtubeclone.app.ui.signup

import android.content.Context
import com.youtubeclone.app.R
import com.youtubeclone.app.data.model.Token
import com.youtubeclone.app.data.network.YouTubeApiService
import com.youtubeclone.app.data.network.request_body.LoginBody
import com.youtubeclone.app.data.network.request_body.SignupBody
import com.youtubeclone.app.ui.AppSharedPreferences
import retrofit2.Call
import retrofit2.Response

class SignupPresenter(view: View) {

    private val mainView = view

    fun valideInputs(
        name: String,
        username: String,
        surname: String,
        password: String,
        context: Context
    ) {

        if (name.isEmpty() || username.isEmpty() || surname.isEmpty() || password.isEmpty()) {
            mainView.showError(context.getString(R.string.invalid_inputs))
        } else if (password.length < 8) {
            mainView.showError(context.getString(R.string.short_passw))
        } else {
            val apiService =
                YouTubeApiService.create().signup(SignupBody(username, name, surname, password))

            apiService.enqueue(object : retrofit2.Callback<Token> {

                override fun onFailure(call: Call<Token>, t: Throwable) {
                    mainView.showError(t.message.toString())
                }

                override fun onResponse(call: Call<Token>, response: Response<Token>) {
                    if (response.body()?.message == null) {
                        mainView.showError("User already exists")
                    } else {
                        getToken(username, password, context)
                    }
                }
            })
        }
    }

    fun getToken(username: String, password: String, context: Context) {
        val api = YouTubeApiService.create().login(LoginBody(username, password))
        api.enqueue(object : retrofit2.Callback<Token> {

            override fun onFailure(call: Call<Token>, t: Throwable) {
                mainView.showError(t.message.toString())
            }

            override fun onResponse(call: Call<Token>, response: Response<Token>) {
                AppSharedPreferences(context).save("token", response.body()?.token)
                mainView.navigateToHome()
            }
        })
    }

    interface View {
        fun showError(error: String)
        fun navigateToHome()
    }
}