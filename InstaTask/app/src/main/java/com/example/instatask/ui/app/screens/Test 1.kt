package com.example.instatask.ui.app.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.instatask.ui.Components.MakeGoogleMap
import com.example.instatask.ui.Components.TopBar
import com.example.instatask.ui.app.DrawersStatus


@Composable
fun greeting1(openDrawer:(Boolean)->Unit = DrawersStatus){
    Column(

        modifier= Modifier.fillMaxSize()
    ) {



        TopBar(title = "Test1",   buttonIcon =Icons.Filled.Menu,onButtonClicked = {openDrawer(true)})


        Column(
            modifier= Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Box(){
                Text(text = "Home Page Content goes here")
            }


            Box(){
               // MakeGoogleMap(vModel)
            }
        }

    }


}