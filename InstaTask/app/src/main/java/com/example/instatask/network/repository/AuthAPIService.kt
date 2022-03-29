package com.example.instatask.network.repository

import com.example.instatask.network.GetCatBody

import com.example.instatask.network.ResponseTokenSkill

import com.example.instatask.network.GetReviewBody
import com.example.instatask.network.ResponseTokenReview


import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthAPIService {

    @POST("get_cat_skill1")
    suspend fun getCat1(@Body getcat: GetCatBody): Response<ResponseTokenSkill>

    @POST("get_cat_skill2")
    suspend fun getCat2(@Body getcat:GetCatBody): Response<ResponseTokenSkill>

    @POST("get_cat_skill3")
    suspend fun getCat3(@Body getcat:GetCatBody): Response<ResponseTokenSkill>

    @POST("reviews_skillComponent")
    suspend fun getReviews(@Body getReview: GetReviewBody): Response<ResponseTokenReview>

}

