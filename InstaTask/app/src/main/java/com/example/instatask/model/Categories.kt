package com.example.instatask.model

data class Categories(
    var catID:Int,
    var name:String,
    var imageID:Int,
   var list:List<JobCreator> = jobCreators,
)

// Pets
// Garden
// House
// Deliver
// Trade
// Labor
