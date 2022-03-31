package com.example.instatask.ui.app.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instatask.ui.theme.graySurface
import com.example.instatask.ui.theme.lightBlue


@Composable
fun GigPage(){
    LazyColumn(modifier = Modifier.fillMaxSize()){
        item(){
            Box(modifier = Modifier.background(lightBlue)){
            Text(text="Start your gig Today", modifier = Modifier.fillMaxWidth().height(100.dp).padding(28.dp),
                textAlign = TextAlign.Center,
                color= graySurface,
                fontSize = 28.sp
                        )}

        }
        item(){
            Text(text="Pick and Go", modifier = Modifier.fillMaxWidth().padding(5.dp),
                textAlign = TextAlign.Center,
                fontStyle = FontStyle.Italic,
                fontSize = 12.sp
                //color= Color.Blue
            )}

        item(){
            Text(text = "Your interests",
               modifier = Modifier.padding(10.dp),
            fontSize = 16.sp,
                color = graySurface,
                fontWeight = FontWeight.SemiBold
                )
        }

        item(){
            Card(modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .padding(horizontal = 30.dp, vertical = 5.dp)
               // .border(2.dp, Color.Red)
                ,shape= RoundedCornerShape(8.dp),
                elevation = 5.dp
            ) {
                Row() {


                }
            }

        }

    }
}