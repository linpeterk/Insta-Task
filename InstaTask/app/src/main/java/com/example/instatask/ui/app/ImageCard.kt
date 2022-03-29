package com.example.instatask.ui.app


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp

@Composable
fun ImageCard(
    painter: Painter,
    modifier: Modifier=Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth().height(200.dp).width(200.dp),
        shape= RoundedCornerShape(15.dp),
        elevation = 5.dp
    ) {
        Image(painter = painter, contentDescription = "ProfilePic",contentScale = ContentScale.Crop)
    }
}