package com.example.instatask.network

import com.google.gson.annotations.SerializedName
import java.util.*

data class ResponseSkillType(

    @SerializedName("id")
    var id:Int = 0,
    @SerializedName("name")
    var name:String = "",
    @SerializedName("hourlyRate")
    var hourlyRate:Int = 0,

    @SerializedName("description")
    var description:String = "",
    @SerializedName("imageRes")
    var imageRes:String = "",
    @SerializedName("available")
    var available:String = "",
    @SerializedName("workLocation")
    var workLocation:String = "",

    )

