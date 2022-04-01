package com.example.instatask.ui.Components.utilities

import android.util.Log
import android.widget.Toast
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.instatask.model.Categories
import com.example.instatask.ui.app.Navigation.NavScreens
import com.example.instatask.ui.app.screens.Screens
import com.example.instatask.viewmodel.TheViewModel
import java.util.*

@Composable
fun CategoriesBar(vModel: TheViewModel, list:List<Categories>, mode:Int, navController: NavController){
val context = LocalContext.current

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
                                //1 for job board, 2 for skill board. Job board performs database retrieval, skill does API
                                if(mode == 1) {
                                    vModel.fetchCategory(item.catID)
                                }
                                else{
                                    //When category clicked, load its perspective list
                                    vModel.getCatlist(item.catID)
                                }
                                if(item.catID == 0) //POST TASK CLICKED, NAVIGATE TO POST SCREEN
                                {
                                    if(mode == 1 ) //Task board's post task
                                    navController.navigate(NavScreens.PostTask.route){
                                        popUpTo(NavScreens.PostTask.route)
                                        launchSingleTop = true
                                    }
                                    else {
                                        Toast.makeText(context, "Denied: Please register a Business Account", Toast.LENGTH_LONG).show()
                                    }
                                }
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
                                vModel.getCatlist(item.catID)
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