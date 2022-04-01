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
    @SerializedName("lat")
    var lat:Double = 37.4198,
    @SerializedName("lng")
    var lng:Double = -122.0788,
    )

data class ResponseReviewType(
    @SerializedName("id")
    var id:Int = 0,
    @SerializedName("name")
    var name:String = "",
    @SerializedName("review")
    var review:String = "",
    @SerializedName("imageRes")
    var imageRes:String = "",
    @SerializedName("available")
    var available:String = "",
    @SerializedName("workLocation")
    var workLocation:String? = null


)


data class ResponseGigType(
    @SerializedName("catID")
    var id:Int = 0,
    @SerializedName("name")
    var name:String = "",
    @SerializedName("money")
    var money:String = "",
    @SerializedName("imageRes")
    var imageRes:String = "",

)
