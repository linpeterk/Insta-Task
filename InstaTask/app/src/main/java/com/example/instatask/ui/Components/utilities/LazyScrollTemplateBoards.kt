package com.example.instatask.ui.Components.utilities

import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import com.example.instatask.database.datamodel.Task
import com.example.instatask.ui.app.screens.Screens
import com.example.instatask.ui.theme.graySurface
import com.example.instatask.viewmodel.TheViewModel

@Composable
fun LazyScrollTaskBoard(vModel: TheViewModel, navcontroller:NavController){

    val currentList = vModel.currentTaskList.observeAsState(arrayListOf())
   // vModel.loginRequestLiveData
    LazyColumn(
        modifier = Modifier
            .background(graySurface)
            .padding(5.dp)
            .fillMaxSize()

    ){

        items(
            currentList.value
        ){ item->
            Spacer(modifier = Modifier.padding(3.dp))
            Card(
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)
                ,

                elevation = 7.dp

            ){
                Row(){
                    Log.d("ImageRES", item.imageId?:"null")
                    Log.d("ImageRES", item.person_name?:"null")
                    Image(painter = painterResource(id = vModel.getImageId(context = LocalContext.current,item.imageId?:"workinprogress") ), contentDescription = null,
                        modifier = Modifier
                            //    .border(2.dp, Color.Red)
                            .padding(20.dp)
                            .size(70.dp)

                    )
                    Column(modifier = Modifier
                        .padding(8.dp)
                        .verticalScroll(rememberScrollState())
                        .clickable(onClick = {

                            navcontroller.navigate(Screens.WhenJob.route + "/${item.taskId - 1}")

                        })
                    ){

                        Text(text = "${item.task_name?: "No name Found"}", fontSize = 16.sp, modifier = Modifier.fillMaxWidth())
                        Text(text = "Hourly $${item.hourly_rate?: 0}", fontSize = 12.sp,  modifier = Modifier.fillMaxWidth())
                        Text(text = "Areas served: ${item.address ?: "No Address Found"}, CA", fontSize = 12.sp,  modifier = Modifier.fillMaxWidth())
                        Text(text = "Hours: ${item.description ?: "No Descript"}", fontSize = 12.sp,  modifier = Modifier.fillMaxWidth())
                        Spacer(modifier = Modifier.padding(5.dp))

                        Text(text = "Description: \n\"${item.description} \"",
                            overflow = TextOverflow.Visible,
                            fontSize = 16.sp,
                            fontFamily = FontFamily.Cursive
                        )
                    }
                }
            }

        }

    }
}

@Composable
fun LazyScrollSkillBoard(vModel: TheViewModel, navcontroller:NavController){

    LazyColumn(
        modifier = Modifier
            .background(graySurface)
            .padding(5.dp)
            .fillMaxSize()

    ){

        items(
            vModel.currentSkillList
        ){ item->
            Spacer(modifier = Modifier.padding(3.dp))
            Card(
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)
                ,

                elevation = 7.dp

            ){
                Row(){
                    Log.d("ImageRES", item.imageRes)
                    Log.d("ImageRES", item.name)
                    Image(painter = painterResource(id = vModel.getImageId(context = LocalContext.current,item.imageRes) ), contentDescription = null,
                        modifier = Modifier
                            //    .border(2.dp, Color.Red)
                            .padding(20.dp)
                            .size(70.dp)

                    )
                    Column(modifier = Modifier
                        .padding(8.dp)
                        .verticalScroll(rememberScrollState())
                        .clickable(onClick = {

                            vModel.getReviews(2, 2)
                            navcontroller.navigate(Screens.WhenSkill.route + "/${item.id - 1}")

                        })
                    ){

                        Text(text = "${item.name}", fontSize = 16.sp, modifier = Modifier.fillMaxWidth())
                        Text(text = "Hourly $${item.hourlyRate}", fontSize = 12.sp,  modifier = Modifier.fillMaxWidth())
                        Text(text = "Areas served: ${item.workLocation}, CA", fontSize = 12.sp,  modifier = Modifier.fillMaxWidth())
                        Text(text = "Hours: ${item.available}", fontSize = 12.sp,  modifier = Modifier.fillMaxWidth())
                        Spacer(modifier = Modifier.padding(5.dp))

                        Text(text = "Description: \n\"${item.description} \"",
                            overflow = TextOverflow.Visible,
                            fontSize = 16.sp,
                            fontFamily = FontFamily.Cursive
                        )
                    }
                }
            }

        }

    }
}