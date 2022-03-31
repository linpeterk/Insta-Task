package com.example.instatask.ui.app.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign

@Composable
fun GigPage(){
    LazyColumn(modifier = Modifier.fillMaxSize()){
        item(){
            Text(text="Pick and Go", modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                //color= Color.Blue
            )}
        item(){
            Text(text="Pick and Go", modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                //color= Color.Blue
            )}


    }
}