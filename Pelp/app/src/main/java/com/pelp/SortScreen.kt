package com.pelp

import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.CameraPositionState
import com.google.maps.android.compose.GoogleMap
import com.pelp.ui.theme.lightBlue




@Composable
fun SortScreen(navController: NavController){

    Box(){
        MakeGoogleMap(true, modifier = Modifier.fillMaxSize())
//        GoogleMap(modifier=Modifier.fillMaxSize()){
//
//        }
    }

    IconBox(navController)
}

@Composable
fun IconBox(navController: NavController){
    Column(){
        Card(modifier = Modifier
            .height(60.dp)
            .offset(y = 442.dp)
            //.border(1.dp, Color.Black)
            .padding(4.dp)
            .fillMaxWidth(),
            shape = RoundedCornerShape(4.dp),
            Color.White,
            elevation = 4.dp){
            MenuTab(navController)
        }
        Card(modifier = Modifier
            .height(211.dp)
            .offset(y = 445.dp)
            .padding(4.dp)
            .fillMaxWidth(),
            shape = RoundedCornerShape(4.dp),
            Color.White,
            elevation=4.dp){
            
            Column(modifier= Modifier
                .fillMaxSize()
                /*.border(1.dp, Color.Black)*/) {
                Row(modifier=Modifier.fillMaxWidth()) {
                    Button(onClick = { /*dialogState.value = true*/ },
                        modifier = Modifier
                            .padding(10.dp, 8.dp, 4.dp, 8.dp)
                            .width(116.dp)
                            .height(50.dp),
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = lightBlue)
                    ) {
                        Text(
                            text = "Cleanliness",
                            textAlign = TextAlign.Center,
                            color = Color.White
                        )
                    }
                    //Spacer(modifier = Modifier.width(10.dp))
                    Button(onClick = { /*dialogState.value = true*/ },
                        modifier = Modifier
                            .padding(4.dp, 8.dp, 4.dp, 8.dp)
                            .width(116.dp)
                            .height(50.dp),
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = lightBlue)
                    ) {
                        Text(
                            text = "Proximity",
                            textAlign = TextAlign.Center,
                            color = Color.White
                        )
                    }
                    //Spacer(modifier = Modifier.width(10.dp))
                    Button(onClick = { /*dialogState.value = true*/ },
                        modifier = Modifier
                            .padding(4.dp, 8.dp, 8.dp, 8.dp)
                            .width(116.dp)
                            .height(50.dp),
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = lightBlue)
                    ) {
                        Text(
                            text = "Popularity",
                            textAlign = TextAlign.Center,
                            color = Color.White
                        )
                    }

                }

                Row(modifier=Modifier.fillMaxWidth()) {
                    Button(onClick = { /*dialogState.value = true*/ },
                        modifier = Modifier
                            .padding(10.dp, 8.dp, 4.dp, 8.dp)
                            .width(116.dp)
                            .height(50.dp),
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = lightBlue)
                    ) {
                        Text(
                            text = "Safety",
                            textAlign = TextAlign.Center,
                            color = Color.White
                        )
                    }
                    //Spacer(modifier = Modifier.width(10.dp))
                    Button(onClick = { /*dialogState.value = true*/ },
                        modifier = Modifier
                            .padding(4.dp, 8.dp, 4.dp, 8.dp)
                            .width(116.dp)
                            .height(50.dp),
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = lightBlue)
                    ) {
                        Text(
                            text = "Scenery",
                            textAlign = TextAlign.Center,
                            color = Color.White
                        )
                    }
                    //Spacer(modifier = Modifier.width(10.dp))
                    Button(onClick = { /*dialogState.value = true*/ },
                        modifier = Modifier
                            .padding(4.dp, 8.dp, 8.dp, 8.dp)
                            .width(116.dp)
                            .height(50.dp),
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = lightBlue)
                    ) {
                        Text(
                            text = "Smell",
                            textAlign = TextAlign.Center,
                            color = Color.White
                        )
                    }

                }

                Row(modifier=Modifier.fillMaxWidth()) {
                    Button(onClick = { /*dialogState.value = true*/ },
                        modifier = Modifier
                            .padding(10.dp, 8.dp, 4.dp, 8.dp)
                            .width(116.dp)
                            .height(50.dp),
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = lightBlue)
                    ) {
                        Text(
                            text = "Handicap",
                            textAlign = TextAlign.Center,
                            color = Color.White
                        )
                    }
                    //Spacer(modifier = Modifier.width(10.dp))
                    Button(onClick = { /*dialogState.value = true*/ },
                        modifier = Modifier
                            .padding(4.dp, 8.dp, 4.dp, 8.dp)
                            .width(116.dp)
                            .height(50.dp),
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = lightBlue)
                    ) {
                        Text(
                            text = "Private",
                            textAlign = TextAlign.Center,
                            color = Color.White
                        )
                    }
                    //Spacer(modifier = Modifier.width(10.dp))
                    Button(onClick = { /*dialogState.value = true*/ },
                        modifier = Modifier
                            .padding(4.dp, 8.dp, 8.dp, 8.dp)
                            .width(116.dp)
                            .height(50.dp),
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = lightBlue)
                    ) {
                        Text(
                            text = "Public",
                            textAlign = TextAlign.Center,
                            color = Color.White
                        )
                    }

                }
                
            }

        }
    }
}



