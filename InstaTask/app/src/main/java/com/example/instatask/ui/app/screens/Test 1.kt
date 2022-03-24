package com.example.instatask.ui.app.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.instatask.ui.app.Components.topBar


@Composable
fun greeting1(openDrawer:()->Unit){
    Column(

        modifier= Modifier.fillMaxSize()
    ) {



        topBar(title = "Test1",   buttonIcon =Icons.Filled.Menu,onButtonClicked = {openDrawer()})


        Column(
            modifier= Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {

            Text(text = "Home Page Content goes here")
        }

    }


}