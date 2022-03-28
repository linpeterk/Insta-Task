package com.example.instatask.ui.Components.utilities

import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instatask.model.Categories
import com.example.instatask.viewmodel.TheViewModel
import java.util.*

@Composable
fun CategoriesBar(vmodel: TheViewModel, list:List<Categories>){


        LazyRow(
            modifier = Modifier
            //.border(3.dp, Color.Red)

        ) {
            items(list) { item -> //This is the categories List, loop through

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(15.dp)
                      //  .border(3.dp, Color.Blue)
                    //.border(3.dp, Color.Black)
                ) {

                    Box(
                        modifier = Modifier
                      //      .border(3.dp, Color.Red)
                            .clickable(onClick = {
                            vmodel.getCatlist(1) //When category clicked, load its perspective list

                          //      Log.d("Bar", "list is ${vmodel.taskList[0].description}")
                            })
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
                           // .border(3.dp, Color.Red)
                            .clickable(onClick = {
                            vmodel.getCatlist(1)
                            //      Log.d("Bar", "list is ${vmodel.taskList[0].description}")
                        })
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