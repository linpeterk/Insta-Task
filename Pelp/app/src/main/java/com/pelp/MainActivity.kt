package com.pelp

import Examples.*
import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.model.LatLng
import com.pelp.model.data.writeFile
import com.pelp.ui.theme.PelpTheme

lateinit var userCurrentLocation:LatLng

var permission = true

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getLocationPermission()
        Database.data.init() // Don't Comment this out! it's in database
        setContent {
           // writeFile()
             // Don't Comment this out!
            // A surface container using the 'background' color from the theme

           var navController: NavHostController

            PelpTheme {
                navController = rememberNavController()
             //  SetupNavGraph(navController = navController)
                MainScreen(navController = navController)
            }

          //  TestScreen(navController)
            //addAddress(navController = rememberNavController())
//        SignupScreen(navController = navController)
            //SquareImage (navController, 2)
        //   SetupNavGraph(navController = navController)



       //    MainScreen(navController = navController)

           //MainScreen(navController = navController)

            // A surface container using the 'background' color from the theme
//            navController = rememberNavController()
//            SetupNavGraph(navController = navController)
//            ExpertReview()
           // LandingPageScreen(navController = navController)
            // testingScrolls()

     //   SquareImage(navController = navController, addressLoc =2 )
//            emergency(navController = navController)
//            searchAddress(navController = navController)

//            MainScreen()

//            SortScreen(navController = navController)

   //         SquareImage (navController, 2)


            //LoginScreen(navController)
          //  ProfileScreen(navController = navController)



        }
    }
     var _locationPermissionGranted = MutableLiveData(false)
    var locationPermissionGranted : LiveData<Boolean> = _locationPermissionGranted

    fun getLocationPermission(){
        if(ContextCompat.checkSelfPermission(this.applicationContext, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)
        {
            if(ContextCompat.checkSelfPermission(this.applicationContext, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED)
            {
                permissionGrant(true)
                getDeviceLocation()
            }
            permission=true
            getDeviceLocation()
        }

    }

    fun permissionGrant(setGranted:Boolean){
        _locationPermissionGranted.value = setGranted
    }

    @SuppressLint("MissingPermission")
    fun getDeviceLocation(){
        val fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)

        try{
            if ( locationPermissionGranted.value == true) {


                val locationResult = fusedLocationProviderClient.lastLocation

                locationResult.addOnCompleteListener{

                    task->
                    if(task.isSuccessful()) {
                        val lastLocation = task.result

                        userCurrentLocation = LatLng(lastLocation.latitude, lastLocation.longitude)

                        Log.d(TAG, "lat ${lastLocation.latitude} and long ${lastLocation.longitude}")
                    }
                }


            }
        }catch(e:SecurityException){

        }
    }





}


