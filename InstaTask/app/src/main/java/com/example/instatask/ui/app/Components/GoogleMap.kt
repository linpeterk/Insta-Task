package com.example.instatask.ui.app.Components

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.CameraPositionState
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.rememberCameraPositionState
import java.util.HashMap
//var cameraPositionState:CameraPositionState?=null

val caliMuseum = LatLng(34.05, -118.24)
val toyDistrict = LatLng(34.047, -118.243)
val brew = LatLng(34.051, -118.234)
val dodgerS = LatLng(34.073, -118.241)
val church = LatLng(34.05693923331048, -118.23957346932366)

@Composable
 fun MakeGoogleMap(
    makeMarker: Boolean = false,
    modifier: Modifier
){

    val coroutineScope = rememberCoroutineScope()


    var cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(caliMuseum, 15f)
    }

//    LaunchedEffect(){
//
//    }
    var uiSettings by remember { mutableStateOf(MapUiSettings(compassEnabled = false, myLocationButtonEnabled = true, mapToolbarEnabled = true)) }

    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState!!,
        uiSettings = uiSettings,


        onPOIClick = {
            Log.d(TAG, "POI clicked: ${it.name}")
        },

        onMapLongClick = {
//
//            cameraPositionState!!.position =
//                CameraPosition.fromLatLngZoom(
//                    userCurrentLocation,
//                    15f
//                )


        }
    ) {
      //  if(makeMarker)
            //makeMarkers(obj)


    }


}