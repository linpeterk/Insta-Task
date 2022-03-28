package com.example.instatask.ui.Components

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*

//var cameraPositionState:CameraPositionState?=null

val caliMuseum = LatLng(34.05, -118.24)
val toyDistrict = LatLng(34.047, -118.243)
val brew = LatLng(34.051, -118.234)
val dodgerS = LatLng(34.073, -118.241)
val church = LatLng(34.05693923331048, -118.23957346932366)



@Composable
  fun MakeGoogleMap(
    makeMarker: Boolean = false,
) {
    var cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(caliMuseum, 15f)
    }

    var uiSettings by remember {
        mutableStateOf(
            MapUiSettings(
                compassEnabled = true,
                myLocationButtonEnabled = true,
                mapToolbarEnabled = true
            )
        )
    }

    var properties by remember {
        mutableStateOf(MapProperties(mapType = MapType.NORMAL))
    }



    Box(Modifier.fillMaxSize())
    {
         GoogleMap(
            modifier = Modifier.matchParentSize(),
            cameraPositionState = cameraPositionState!!,
            uiSettings = uiSettings,
            properties= properties,


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
        )
//        Switch(
//            checked = uiSettings.mapToolbarEnabled,
//            onCheckedChange = {
//                uiSettings = uiSettings.copy(mapToolbarEnabled = it)
//            }
//        )







//    LaunchedEffect(){
//
//    }


    }
}