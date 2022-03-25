package com.example.instatask.ui.app.Components.utilities

import android.content.Context
import android.location.Address
import android.location.Geocoder
import android.widget.Toast
import java.io.IOException
import java.util.*

fun reverseGeocoder(context: Context, lat:Double, lng:Double):String{

    val mGeocoder = Geocoder(context, Locale.getDefault())
    var addressString= ""

    // Reverse-Geocoding starts
    try {
        val addressList: List<Address> = mGeocoder.getFromLocation(lat, lng, 1)

        // use your lat, long value here
        if (addressList != null && addressList.isNotEmpty()) {
            val address = addressList[0]

            return address.getAddressLine(0)


        }
    } catch (e: IOException) {
        Toast.makeText(context,"Unable connect to Geocoder ${e.message}", Toast.LENGTH_LONG).show()
    }

    // Finally, the address string is posted in the textView with LatLng.
    return addressString

}