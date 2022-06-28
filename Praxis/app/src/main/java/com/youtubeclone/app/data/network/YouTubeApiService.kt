package com.youtubeclone.app.data.network

import com.youtubeclone.app.data.model.*
import com.youtubeclone.app.data.network.request_body.LoginBody
import com.youtubeclone.app.data.network.request_body.SignupBody
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.*

interface YouTubeApiService {

    @GET("videos?size=10&page=0")
    fun getVideos(): Call<Result>

    @GET("categories")
    fun getCategories(): Call<List<Category>>

    @GET("users/me")
    fun getUserInfo(@Header("Authorization") token: String?): Call<User>

    @POST("auth/login")
    fun login(@Body loginBody: LoginBody): Call<Token>

    @POST("auth/signup")
    fun signup(@Body signupBody: SignupBody): Call<Token>

    companion object {

        const val BASE_URL = "https://youtube-clone-backend.herokuapp.com/api/v1/"

        fun create(): YouTubeApiService {
            val logger = HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY)

            val okHttpClient = OkHttpClient
                .Builder()
                .addInterceptor(logger)
                .build()

            val retrofit = Retrofit.Builder()
                .addConverterFactory(MoshiConverterFactory.create())
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .build()

            return retrofit.create(YouTubeApiService::class.java)
        }
    }
}