package com.example.instatask.model

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.instatask.viewmodel.TheViewModel

fun cardViewCallBack(context: Context, name: String) {
    Toast.makeText(context,"Hello, ${name}", Toast.LENGTH_LONG).show()
}

@Composable
fun JobCreatorCard(name:String,description:String,imageRes:String, vModel:TheViewModel)
{
    var context= LocalContext.current
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .wrapContentHeight().
            clickable { cardViewCallBack(context,name+description) },
        shape = MaterialTheme.shapes.medium,
        elevation = 5.dp,
        backgroundColor = MaterialTheme.colors.surface
    ) {

        Row (
            verticalAlignment = Alignment.CenterVertically

        ){

            Image(painter = painterResource(id = vModel.getImageId(context,imageRes)),
                contentDescription =null,
                modifier= Modifier
                    .size(130.dp)
                    .padding(8.dp),
                contentScale = ContentScale.Fit
            )
            Column(Modifier.padding(8.dp)) {

                Text(text = name,
                    style= MaterialTheme.typography.h6,
                    color= MaterialTheme.colors.onSurface,
                    modifier= Modifier.padding(start=30.dp)
                )
                Text(text = description,
                    style= MaterialTheme.typography.body1,
                    color= MaterialTheme.colors.onSurface,
                    modifier= Modifier.padding(start=15.dp)
                )

            }

        }

    }
}
