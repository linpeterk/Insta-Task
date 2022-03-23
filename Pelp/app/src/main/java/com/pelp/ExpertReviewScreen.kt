package com.pelp

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.android.gms.maps.GoogleMap
import com.pelp.ui.theme.lightBlue


var mMap: GoogleMap? = null

@Composable
fun ExpertReview(navController: NavController){


    Box(
        modifier = Modifier
            .background(Color.Transparent)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = {  }, modifier = Modifier
                .width(250.dp)
                .height(50.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = lightBlue)

            ){
                Text(text = "Address Button", modifier = Modifier.padding(2.dp),color=Color.White)
            }
            Row(){
                Button(onClick = {  }, modifier = Modifier
                    .width(50.dp)
                    .height(50.dp)
                    .padding(5.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = lightBlue)

                ){
                    Text(text = "Sort", modifier = Modifier.padding(2.dp),color=Color.White)
                }
                Button(onClick = {  }, modifier = Modifier
                    .width(50.dp)
                    .height(50.dp)
                    .padding(5.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = lightBlue)

                ){
                    Text(text = "Emergency", modifier = Modifier.padding(2.dp),color=Color.White)
                }
                Button(onClick = {  }, modifier = Modifier
                    .width(50.dp)
                    .height(50.dp)
                    .padding(5.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = lightBlue)

                ){
                    Text(text = "Stuff", modifier = Modifier.padding(2.dp),color=Color.White)
                }
            }
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
            ) {


                repeat(10) {
                    Card(
                        modifier = Modifier
                            .height(100.dp),
                        shape = RoundedCornerShape(3.dp)
                        // .fillMaxWidth()

                    ) {
                        Text(
                            "Title Bar",
                            modifier = Modifier
                                .border(4.dp, Color.LightGray)
                                .background(Color.White)
                                .padding(5.dp)
                                .height(20.dp)
                                .fillMaxWidth()
                        )
                    }
                    Card(
                        modifier = Modifier
                            .height(128.dp),
                        shape = RoundedCornerShape(3.dp)
                        // .fillMaxWidth()

                    ) {
                        Text(
                            "Generate Stuff Here",
                            modifier = Modifier
                                .border(4.dp, Color.LightGray)
                                .background(Color.White)
                                .padding(24.dp)
                                .height(150.dp)
                                .fillMaxWidth()
                        )
                    }
                }
            }
        }
    }

}