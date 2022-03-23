package com.pelp.model.data

import com.pelp.R


data class Person(

    var userName:String,
    var realName:String,
    var password:String,
    var zip:Int,
    var imageId:Int = R.drawable.admin,
    var history:MutableList<Review> = mutableListOf()


)
