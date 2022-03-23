package com.pelp.model.data

import Examples.TAG
import android.util.Log
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.keyframes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp

/*
    val size by animateDpAsState(targetValue = boxSize, keyframes {
                durationMillis = 5000
                 boxSize at 0 with LinearEasing
                 boxSize * 1.5f at 1000 with FastOutLinearInEasing
                 boxSize * 2f at 5000
        }
    )

     */


@Composable
fun loginAnimation(sizeState: Dp = 10.dp){
    Log.d(TAG, "Animation Playing")

    val size by animateDpAsState(targetValue = sizeState,
        keyframes {
        durationMillis = 5000
            sizeState at 0 with LinearEasing
            sizeState * 1.5f at 1000 with FastOutLinearInEasing
            sizeState * 2f at 5000
    }
    )


Box() {
    Box(
        modifier = Modifier
            .size(size)
            .background(Color.Red)
         .border(2.dp, Color.Blue)
    ) {

    }
}

}