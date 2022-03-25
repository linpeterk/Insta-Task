package com.example.instatask.ui.app.Components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.instatask.ui.app.DrawersStatus

@Composable

fun topBar(title: String = "", buttonIcon: ImageVector = Icons.Filled.Menu, onButtonClicked:(Boolean)->Unit = DrawersStatus)
{
    TopAppBar(
        title = { Text(text = title) },

        navigationIcon={ IconButton(onClick = { onButtonClicked(true) }) {
            Icon(buttonIcon,contentDescription = "")
        }
        },
        backgroundColor = Color.Transparent,
        elevation = 0.dp

    )
}
