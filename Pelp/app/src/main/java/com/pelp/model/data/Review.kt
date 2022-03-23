package com.pelp.model.data

import com.google.android.gms.maps.model.LatLng
import com.pelp.R

class Review (val customerName:String, val restroomLoc: LatLng, var comments:String, var imageID:Int = R.drawable.man, var restRoomID:Int = R.drawable.ic_sea_icon_round){

}