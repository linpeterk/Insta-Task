package com.pelp

import android.content.ContentValues.TAG
import android.content.Context
import android.location.Address
import android.location.Geocoder
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import com.pelp.model.data.loginAnimation
import java.io.IOException
import java.util.*


@Composable
fun animationAlert(flag:Boolean){

        //loginAnimation(flag)

}

fun reverseGeocoder(context: Context, lat:Double, lng:Double):String{

    val mGeocoder = Geocoder(context, Locale.getDefault())
    var addressString= ""

    // Reverse-Geocoding starts
    try {
        val addressList: List<Address> = mGeocoder.getFromLocation(lat, lng, 1)

        // use your lat, long value here
        if (addressList != null && addressList.isNotEmpty()) {
            val address = addressList[0]
            var sb:String =""


            return address.getAddressLine(0)

            //  addressString = sb.toString()

        }
    } catch (e: IOException) {
        Toast.makeText(context,"Unable connect to Geocoder ${e.message}", Toast.LENGTH_LONG).show()
    }

    // Finally, the address string is posted in the textView with LatLng.
    return addressString

}
/*
fun Geocoder(context: Context, lat:Double, lng:Double):LatLng{

    val mGeocoder = Geocoder(context, Locale.getDefault())

    //getFromLocationName(String locationName, int maxResults, Geocoder.GeocodeListener listener)

    var result = mGeocoder.getFromLocationName("1600 Amphitheatre Parkway, Mountain View, CA", 5)

    var addressString= ""

    // Reverse-Geocoding starts
    try {
        val addressList: List<Address> = mGeocoder.getFromLocation(lat, lng, 1)

        // use your lat, long value here
        if (addressList != null && addressList.isNotEmpty()) {
            val address = addressList[0]
            var sb:String =""


            return address.getAddressLine(0)

            //  addressString = sb.toString()

        }
    } catch (e: IOException) {
        Toast.makeText(context,"Unable connect to Geocoder ${e.message}", Toast.LENGTH_LONG).show()
    }

    // Finally, the address string is posted in the textView with LatLng.
    return addressString

}
*/
