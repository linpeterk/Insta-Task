package com.example.instatask.ui.app.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.instatask.ui.Components.TopBar

@Composable
fun greeting2(openDrawer:(Boolean)->Unit){
    Column(modifier = Modifier.fillMaxSize()){

        TopBar(title = "Test22",   buttonIcon = Icons.Filled.Menu,onButtonClicked = {openDrawer(true)})
    Text(text = "hello Test22")
    }
}