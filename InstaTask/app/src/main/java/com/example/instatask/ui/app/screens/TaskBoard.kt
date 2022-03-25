package com.example.instatask.ui.app.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.example.instatask.ui.app.Components.MakeGoogleMap
import com.example.instatask.ui.app.Components.topBar
import com.google.android.gms.tasks.Task

@Composable
fun TaskBoard(){

    Column() {

        Box() {

            MakeGoogleMap()
            topBar()
        }

    }





}