package com.example.instatask.model

data class Categories(
    var catID:Int,
    var name:String,
    var imageID:Int,
   var list:List<JobCreator> = jobCreators,
)

val listOfTaskImages = listOf("petcategory", "farming", "renovation", "trading", "deliveryman", "workinprogress")

val listOfSubPets = listOf(
    Pair("Pet Walking", "pets"),
    Pair("Pets Sitting", "workinprogress"),
    Pair("Others", "petcategory"))

val listOfSubGarden = listOf(
    Pair("Planting", "garage"),
    Pair("Plant Trimming", "cleaning"),
    Pair("Others", "farming"))

val listOfSubHome = listOf(
    Pair("Painters", "house"),
    Pair("House Cleaning", "home"),
    Pair("Others", "renovation"))

val listOfSubTrade = listOf(
    Pair("Electronics", "ic_sea_icon"),
    Pair("Collectibles", "review"),
    Pair("Others", "trading"))

val listOfSubDelivery = listOf(
    Pair("Food Delivery", "gigpic"),
    Pair("Documents Delivery", "gigpic2"),
    Pair("Others", "deliveryman"))

val listOfSubLabor = listOf(
    Pair("Moving Labors", "plus"),
    Pair("Construction Labors", "repair"),
    Pair("Others", "workinprogress"))

val listOfSubTaskImages = listOf(listOfSubPets, listOfSubGarden, listOfSubHome, listOfSubTrade, listOfSubDelivery, listOfSubLabor)

val categoryNames = listOf (
    Pair("Pets", "petcategory")
    , Pair("Gardening", "farming")
    , Pair("Home Repair", "renovation")
    ,Pair("Trading", "trading")
    ,Pair("Delivery", "deliveryman")
    ,Pair("Labor", "workinprogress")
)

data class Pair(
    val cat:String,
    val img:String,
)

// Pets
// Garden
// House
// Deliver
// Trade
// Labor
