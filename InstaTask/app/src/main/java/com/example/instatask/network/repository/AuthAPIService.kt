package com.example.instatask.network.repository

import com.example.instatask.network.GetCatBody
import com.example.instatask.network.ResponseTokenSkill
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthAPIService {

    @POST("get_cat_skill1")
    suspend fun getCat1(@Body getcat: GetCatBody): Response<ResponseTokenSkill>

    @POST("get_cat_skill2")
    suspend fun getCat2(@Body getcat:GetCatBody): Response<ResponseTokenSkill>

}