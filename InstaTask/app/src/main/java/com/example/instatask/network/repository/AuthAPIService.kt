package com.example.instatask.network.repository

import com.example.instatask.network.GetCatBody
import com.example.instatask.network.ResponseToken
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthAPIService {

    @POST("get_cat_skill1")
    suspend fun getCatBody(@Body getcat: GetCatBody): Response<ResponseToken>

}