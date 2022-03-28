package com.example.instatask.network

import com.google.gson.annotations.SerializedName

data class GetCatBody(

  //  @SerializedName("username") val email:String,

    @SerializedName("categories")
    val categories:Int

)


