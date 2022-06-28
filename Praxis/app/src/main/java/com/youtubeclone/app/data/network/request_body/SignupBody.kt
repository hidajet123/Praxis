package com.youtubeclone.app.data.network.request_body

data class SignupBody(
    val username: String,
    val name: String,
    val surname: String,
    val password: String
)