package com.pelp

import android.util.Log
import androidx.compose.ui.platform.LocalContext
import com.google.android.gms.maps.model.LatLng
import com.pelp.model.data.*
import java.io.FileOutputStream
import java.util.Collections.reverse

//store restroom location data
//var dataBase: LinkedHashMap<LatLng, Location_Restroom> = LinkedHashMap()

//store customers user
//var  userBase:LinkedHashMap<String, Person> = LinkedHashMap()
//var arrayKeys: MutableList<LatLng> = mutableListOf()

////val strName = listOf("Japanese American National Museum " , "Toy District", "Brewery", "Dodger Stadium","Our Lady Queen of Angels" )
private const val TAG = "DatabaseFile"

class Database(){

    companion object{

        val data = Database()
        var dataBase: LinkedHashMap<LatLng, Location_Restroom> = LinkedHashMap()
        var userBase:LinkedHashMap<String, Person> = LinkedHashMap()


        var arrayKeys: MutableList<LatLng> = mutableListOf() // Not used except for mainframe

        var businessBase:LinkedHashMap<String,Business> = LinkedHashMap()
        //var arrayKeys: MutableList<LatLng> = mutableListOf() // Not used


    }

    fun init(){
        /*
        Initalize some plebs
         */
        customerAdd("peter", "12345", "KC", R.drawable.man ,zip=90001)
        customerAdd("carlos", "12345", "carlos", R.drawable.weird_hair, 90002)
        customerAdd("lyle", "12345", "lyle", R.drawable.old_lady, 90003)
        customerAdd("aidan", "12345", "aidan", R.drawable.girl, 90004)
        customerAdd("admin", "admin", "admin", R.drawable.admin, 90005)

        /*
        initalize some poopers
         */
        addRestroom(caliMuseum, "Japanese American National Museum")
        addRestroom(toyDistrict, "Toy District K9")
        addRestroom(brew, "Cool Brewery")
        addRestroom(dodgerS, "Dodger Stadium")
        addRestroom(church, "Our Lady Queen of Angels")

        /*
         Paid Reviews
         */

        addReviewPersonRest("peter", caliMuseum, "The Best Restroom in Town", personImage = R.drawable.man,restRoomImage = R.drawable.cleanbathroom1 )
        addReviewPersonRest("carlos", caliMuseum, "It's Craptacular", personImage = R.drawable.weird_hair,restRoomImage = R.drawable.urbanbathroom )
        addReviewPersonRest("lyle", caliMuseum, "Would poop here again", personImage = R.drawable.old_lady,restRoomImage = R.drawable.handicap )
        addReviewPersonRest("aidan", caliMuseum, "Bewarn: Risky Business", personImage = R.drawable.girl,restRoomImage = R.drawable.green_bathroom )

        addReviewPersonRest("peter", toyDistrict, "Some people have all the luck.", personImage = R.drawable.man,restRoomImage = R.drawable.futurebathroom )
        addReviewPersonRest("carlos", toyDistrict, "That’s a wrap for me", personImage = R.drawable.weird_hair,restRoomImage = R.drawable.green_bathroom )
        addReviewPersonRest("lyle", toyDistrict, "The big sofa is really not suitable for a small room.", personImage = R.drawable.old_lady,restRoomImage = R.drawable.plant_bathroom )
        addReviewPersonRest("aidan", toyDistrict, "This is going on the list.", personImage = R.drawable.girl,restRoomImage = R.drawable.luxury1)

        addReviewPersonRest("peter", brew, "The box is three times as big as that one.", personImage = R.drawable.man,restRoomImage = R.drawable.handicap )
        addReviewPersonRest("carlos", brew, "Any day will do.", personImage = R.drawable.weird_hair,restRoomImage = R.drawable.green_bathroom )
        addReviewPersonRest("lyle", brew, "Tom answered all the questions on the list.", personImage = R.drawable.old_lady,restRoomImage = R.drawable.cleanbathroom1 )
        addReviewPersonRest("aidan", brew, "Bigger is not always better.", personImage = R.drawable.girl,restRoomImage = R.drawable.futurebathroom )

        addReviewPersonRest("peter", dodgerS, "I'm not a big fan of blueberry pancakes.", personImage = R.drawable.man,restRoomImage = R.drawable.cleanbathroom1 )
        addReviewPersonRest("carlos", dodgerS, "I learned this recipe from my grandma, who learned it from hers.", personImage = R.drawable.weird_hair,restRoomImage = R.drawable.outdoorbathroom )
        addReviewPersonRest("lyle", dodgerS, "Our competitors don't normally ask us for advice, but when an airline leader reached out, we couldn't ignore it.", personImage = R.drawable.old_lady,restRoomImage = R.drawable.handicap )
        addReviewPersonRest("aidan", dodgerS, "She tried to make chicken but she must have put the wrong thing in because it came out of the oven bright green.", personImage = R.drawable.girl,restRoomImage = R.drawable.outdoorbathroom )

        addReviewPersonRest("peter", church, "He uses the snorkel to breathe under water.", personImage = R.drawable.man,restRoomImage = R.drawable.outdoorbathroom2 )
        addReviewPersonRest("carlos", church, "If I could recommend anything to try, it's this", personImage = R.drawable.weird_hair,restRoomImage = R.drawable.urbanbathroom )
        addReviewPersonRest("lyle", church, "The puzzle was taking me so long to put together that I gave up and threw it in the garbage.", personImage = R.drawable.old_lady,restRoomImage = R.drawable.handicap )
        addReviewPersonRest("aidan", church, "The laptop light was the only one light on the room.", personImage = R.drawable.girl,restRoomImage = R.drawable.cleanbathroom1 )


        checkCustomerExist("peter")
        checkCustomerExist("carlos")
        checkCustomerExist("lyle")
        checkCustomerExist("aidan")

        checkRestRoomExist(caliMuseum)
        checkRestRoomExist(toyDistrict)
        checkRestRoomExist(brew)
        checkRestRoomExist(church)
        checkRestRoomExist(caliMuseum)

       // serializeOut(dataBase, Serialize.db)

/*
        dataAdd(caliMuseum, Location_Restroom(name="Japanese American National Museum", caliMuseum))
        dataAdd(toyDistrict, Location_Restroom(name= "Toy District", toyDistrict))
        dataAdd(brew, Location_Restroom(name="Brewery", brew))
        dataAdd(dodgerS, Location_Restroom("Dodger Stadium", dodgerS))
        dataAdd(church, Location_Restroom("Our Lady Queen of Angels", church))
         reviewArray.add(Review("Carlos", loc, "It's craptacular",R.drawable.old_lady))
        reviewArray.add(Review("Lyle", loc, "Would poop here again", R.drawable.girl))
        reviewArray.add(Review("Aidan", loc, "Risky Business", R.drawable.weird_hair))
        reviewArray.add(Review("Peter", restroomLoc=loc, "The best bathroom in town", R.drawable.man))
   addImage(R.drawable.cleanbathroom1)
        addImage(R.drawable.urbanbathroom)
        addImage(R.drawable.handicap)
        customerAdd("peter", "12345", "KC")
        customerAdd("carlo", "12345", "carlo")
        customerAdd("lyle", "12345", "lyle")
        customerAdd("aidan", "12345", "aidan")
        customerAdd("admin", "admin", "admin")
        initReview()
        */

        /*
          reviewArray.add(Review("Carlos", loc, "It's craptacular",R.drawable.old_lady))
               reviewArray.add(Review("Lyle", loc, "Would poop here again", R.drawable.girl))
               reviewArray.add(Review("Aidan", loc, "Risky Business", R.drawable.weird_hair))
               reviewArray.add(Review("Peter", restroomLoc=loc, "The best bathroom in town", R.drawable.man))
         */
    }

    fun addRestroom(bname:String,baddress:String,breview:String){
        var o=Business(bname,baddress,breview)
        businessBase[bname]=o
    }

    fun addBuisness(bname:String,baddress:String,breview:String){
        var o=Business(bname,baddress,breview)
        businessBase[bname]=o
    }

    fun addRestroom(locRestRoom: LatLng, restRoomName: String){
        dataAdd(locRestRoom, Location_Restroom(restRoomName, locRestRoom))
    }

    fun customerAdd(name:String, password:String, realName:String, imageId:Int, zip:Int = 90001){
        var p = Person(name, realName, password, zip, imageId = imageId)
        userBase[name] = p

    }

    fun getLocName(loc: LatLng):String {
        return dataBase[loc]?.name.toString()
    }

    fun getName(user:String):String {
        return (userBase[user]?.realName.toString())
    }

    fun getPass(user:String):String {
        return (userBase[user]?.password.toString())
    }

    fun getZip(user:String):String{
        return (userBase[user]?.zip.toString())
    }

    /*DeFUNT*/
    fun addReviewPersonRest(userName: String, locRestRoom: LatLng, reviewComment: String, personImage: Int, restRoomImage:Int = R.drawable.ic_sea_icon_round){

        var review = Review(customerName = userName, restroomLoc = locRestRoom, comments = reviewComment, imageID = personImage, restRoomID = restRoomImage)

        //add to Location_restroom review list
        dataBase[locRestRoom]?.reviewArray?.add(review)

        //add to restroom images
        dataBase[locRestRoom]?.image_URL?.add(restRoomImage)

        //add to customer images
        dataBase[locRestRoom]?.userIMG_URL?.add(personImage) /*Don't need this*/

        // add to person history list
        customerAddHistory(userName, review)


    }
    /*DeFUNT*/
    fun adminAdd(userName:String, restRoomName:String, password:String, reviewComment:String, locRestRoom:LatLng, realName:String = "johnTEST", restroomImage:Int, personImage:Int = R.drawable.man)
    {
        //add Restroom
        dataAdd(locRestRoom, Location_Restroom(restRoomName, locRestRoom))

        //add Customer

        var review = Review(userName, locRestRoom, reviewComment, personImage)

        //add to Location_restroom review list

        dataBase[caliMuseum]?.reviewArray?.add(review)
        // add to person history list

        customerAddHistory(userName, review)
    }



    fun addReview(userName:String, loc:LatLng, comments:String){
        val review = Review(userName, loc, comments)
        customerAddHistory(userName, review)
        dataBase[loc]?.reviewArray?.add(review)
    }
    fun loginVerify(userName:String, password:String):Boolean{

        return (userBase[userName]!=null && userBase[userName]?.password ==password)
    }

    fun checkCustomerExist(name:String)
    {
        Log.d("Tag", "Person exist? Name:${userBase[name]?.userName} pass ${userBase[name]?.password}  image ${userBase[name]?.imageId}")
    }

    fun checkRestRoomExist(locRestRoom: LatLng)
    {
        Log.d("Tag", "Restroom exist? Name:${dataBase[locRestRoom]?.name} comments: ${dataBase[locRestRoom]?.reviewArray?.get(0)?.comments} Image ${dataBase[locRestRoom]?.image_URL?.get(0)}")
    }


    fun dataAdd(loc:LatLng, restR: Location_Restroom){
        dataBase[loc] = restR
        arrayKeys.add(loc)
    }



    private fun customerAddHistory(name:String, review: Review){
        if(userBase[name]!= null )
            userBase[name]?.history?.add(review)

    }





    private fun reverseHashMap(){  //get database key of next iteration, in reverse order
        reverse(arrayKeys)
    }

    fun getKeyFromList(index:Int):LatLng{  //get database key of next iteration, in reverse order
        Log.d(TAG, "ArrayKey size is ${arrayKeys.count()}")
        Log.d(TAG, "index 0 is ${arrayKeys[0]}")
        return arrayKeys[index]
    }
}
