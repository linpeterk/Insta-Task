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
        description = "All about your house and garage cleaning",
        imgUri = R.drawable.cleaning
    ),
    SliderData(
        title = "Trash",
        4.0f,
        description = "All about your Trash",
        imgUri = R.drawable.trash
    ),
    SliderData(
        title = "House",
        4.0f,
        description = "All about your house maintenance",
        imgUri = R.drawable.house
    ),
    SliderData(
        title = "Pets",
        4.0f,
        description = "All about your Pets",
        imgUri = R.drawable.pets
    ),
    SliderData(
        title = "Kitchen",
        4.0f,
        description = "All about your kitchen",
        imgUri = R.drawable.kitchen
    ),
    SliderData(
        title = "Garage",
        4.0f,
        description = "All about your garage",
        imgUri = R.drawable.garage
    )

)