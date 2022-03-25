package com.example.instatask.ui.app.screens

import androidx.compose.runtime.Composable
import android.content.Context
import android.location.Address
import android.location.Geocoder
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.instatask.ui.app.Components.MakeGoogleMap
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.maps.android.compose.*
//import com.pelp.model.data.Location_Restroom
//import com.pelp.model.data.*
//import com.pelp.ui.theme.Blue300
//import com.pelp.ui.theme.lightBlue
import de.charlex.compose.BottomDrawerScaffold
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import java.io.IOException
import java.util.*

var cameraPositionState:CameraPositionState?=null
//var addressGlobal: Location_Restroom = Location_Restroom(loc=LatLng(100.0, 100.0))
private const val TAG = "MapSampleActivity"

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun WhenJobClicked(navController: NavController) {


        // cardCount =  remember {  mutableStateOf(dataBase.count()) }
        val composableScope = rememberCoroutineScope()
//        Log.d(Examples.TAG,"Hello from Main")
        var peekHeight = remember { mutableStateOf(250.dp)}

        BottomDrawerScaffold(
            //scaffoldState = rememberBottomDrawerState(5)
            drawerModifier = Modifier.size(530.dp),
            drawerGesturesEnabled = true,


            floatingActionButtonPosition= FabPosition.Center,
            drawerPeekHeight = peekHeight.value,
            drawerBackgroundColor = Color.Transparent,  //Transparent drawer for custom Drawer shape
            drawerElevation = 0.dp,

            drawerContent = {
                Surface(                    //To add Padding to Drawer
                    modifier = Modifier
                    ,
                    shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
                    //   elevation = 4.dp
                ) {
                    Box(modifier = Modifier
                        .fillMaxSize()
                        .fillMaxHeight()
                        .fillMaxWidth()
                    ){
                        Column() {
                            Box(modifier = Modifier
                                .weight(0.09f)

                            ){
//                                MenuTab(navController)
                            }


                            Box(modifier = Modifier
                                .weight(0.8f)
                                .background(MaterialTheme.colors.primaryVariant)
                            ){
//                                MakeScrollComponents(navController)
                            }
                        }



                    }
                }
            }
        ){
            MakeGoogleMap()
        }
        /*
  Box(modifier = Modifier
      .fillMaxSize()
      .fillMaxHeight()
      .fillMaxWidth()
  ){
      Column() {
          Box(modifier = Modifier
              .weight(1f)

          ) {


              MakeGoogleMap(true, modifier = Modifier.fillMaxSize())



          }

          Box(modifier = Modifier
              .weight(0.14f)

          ){
              MenuTab(navController)
          }


          Box(modifier = Modifier
              .weight(0.8f)
              .background(MaterialTheme.colors.primaryVariant)
          ){
              MakeScrollComponents(navController)
          }
      }



  }
  makeAddressButton(navController)
  */
}



