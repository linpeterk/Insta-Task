package com.example.instatask.ui.Components

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.roundToInt
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import com.example.instatask.ui.theme.graySurface
import java.security.AccessController.getContext


object Player {
    val maps = HashMap<String, Boolean>()
    // val list = mutableStateListOf<Pair>()
    val list = mutableStateListOf<Offset>()
    val dragList = mutableStateListOf<Offset>()

}

class Pair(val x:Int, val y:Int){

}



//
// var rnds_x:Int? = null
//var rnds_y:Int? = null


@Composable
fun DrawBoard(){

    val context = LocalContext.current
    val theDpWidth = with(LocalDensity.current) {
        1000.toDp()
    }

    val theDpHeight = with(LocalDensity.current) {
        400.toDp()
    }
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Card(
            elevation = 9.dp,
            // shape = RectangleShape,
            backgroundColor = graySurface,
            modifier = Modifier
                //  .border(3.dp, Color.Blue)
                .requiredSize(width = theDpWidth, height = theDpHeight)
                .padding(horizontal = 30.dp, vertical = 15.dp)
                .background(graySurface)
                .pointerInput(Unit) {

                    detectDragGestures { change, dragAmount ->
                        Log.d("Pixel", "Pixel=$change")

                        Player.dragList.add(change.position)

                    }

//                    detectTapGestures(onPress = { offset ->
//
//
//                        Player.list.add(offset)
//                        //currently not used  Player.maps[pixel_x.toString() + pixel_y.toString()] = true
//
//                        Log.d("PixelPlus", "PixelPlus=${offset.toString() + offset.toString()}")
//                        Log.d("Pixel", "Pixel=$offset")
//
////                        detectDragGestures { change, dragAmount ->
////                            Log.d("Pixel", "Pixel=$change")
////
////                            Player.dragList.add(change.position)
////
////                        }
//
//                    })

                }
                .drawWithContent {
                    drawPoints(
                        points = Player.dragList,
                        PointMode.Points,
                        Color.Red,
                        strokeWidth = 15.0f,

                    )
                }

        )
        {
            Text(
                text = "", modifier = Modifier
                //     .background(graySurface)
                //   .border(4.dp, Color.Red)
            )
        }
        Button(onClick = {
            Toast.makeText(context, "Signature Submitted", Toast.LENGTH_LONG).show()
        }, modifier = Modifier.width(300.dp)) {
            Text(text = "Submit Signature")
        }
    }



}