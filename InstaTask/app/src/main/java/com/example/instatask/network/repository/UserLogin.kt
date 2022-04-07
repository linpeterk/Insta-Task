package com.example.instatask.network.repository

import com.google.gson.annotations.SerializedName

data class UserLogin(
    @SerializedName("user_email_address") val user_email_address: String,
    @SerializedName("user_passsword") val user_passsword: String
)
