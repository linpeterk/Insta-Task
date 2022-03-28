package com.example.instatask.model

data class JobCreator (

    val id:Int,
    val name:String,
    val hourlyRate:Int = 25,
    val description:String,
    val imageRes:Int,
    val available:String = "Monday-Friday",
    val workLocation:String = "Orange County Area"

    )