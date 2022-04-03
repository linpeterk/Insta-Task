package com.example.instatask.data

import com.example.instatask.R

data class SliderData (
    val title: String,
    val rating : Float,
    val description: String,
    val imgUri: Int
        )

//Slider List

val SliderList = listOf(
    SliderData(
        title = "Cleaning",
        4.0f,
        description = "",
        imgUri = R.drawable.cleaning
    ),
    SliderData(
        title = "Pets",
        4.0f,
        description = "",
        imgUri = R.drawable.my_pets
    ),
    SliderData(
        title = "Garage Works",
        4.0f,
        description = "",
        imgUri = R.drawable.garage
    )

)