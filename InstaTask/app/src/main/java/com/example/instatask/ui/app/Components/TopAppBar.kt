package com.example.instatask.ui.app.Components

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

@Composable

fun topBar(title: String, buttonIcon: ImageVector, onButtonClicked:()->Unit)
{
    TopAppBar(
        title = { Text(text = title) },
        navigationIcon={ IconButton(onClick = { onButtonClicked() }) {
            Icon(buttonIcon,contentDescription = "")
        }
        },
        backgroundColor = MaterialTheme.colors.primaryVariant
    )
}
