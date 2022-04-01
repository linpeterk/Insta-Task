package com.example.instatask.network

import com.google.gson.annotations.SerializedName

data class GetCatBody(

  //  @SerializedName("username") val email:String,

    @SerializedName("categories")
    val categories:Int

)

data class GetReviewBody(

    @SerializedName("personID")
    val personID: Int,
    @SerializedName("review")
    val review: Int

)

data class GetGiGCategory(

    @SerializedName("personID")
    val personID: Int,

)


