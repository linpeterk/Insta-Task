package com.example.instatask.ui.Components.utilities

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instatask.viewmodel.TheViewModel

@Composable
fun CategoriesBar(vmodel: TheViewModel, modifier : Modifier){


        LazyRow(
            modifier = modifier
            //.border(3.dp, Color.Red)

        ) {
            items(vmodel.getCategory()) { item ->

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(15.dp)
                    //.border(3.dp, Color.Black)
                ) {

                    Box(
                        modifier = Modifier
                        //.border(3.dp, Color.Blue)
                    ) {
                        Image(
                            painter = painterResource(id = item.imageID), contentDescription = null,
                            modifier = Modifier.size(40.dp)
                        )
                    }
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.wrapContentSize()
                        //  .border(2.dp, Color.Yellow)
                    ) {
                        Text(
                            text = item.name,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                            modifier = Modifier
                        )

                    }

                }


            }

        }




}