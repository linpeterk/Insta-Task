package com.example.instatask.ui.Components.utilities

import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import com.example.instatask.database.datamodel.Task
import com.example.instatask.ui.Components.cameraPositionState
import com.example.instatask.ui.Components.googleHQ
import com.example.instatask.ui.app.Navigation.NavScreens
import com.example.instatask.ui.app.screens.Screens
import com.example.instatask.ui.theme.graySurface
import com.example.instatask.viewmodel.TheViewModel
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import de.charlex.compose.BottomDrawerScaffoldState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun LazyScrollTaskBoard(vModel: TheViewModel, navcontroller:NavController, state: BottomDrawerScaffoldState, buttonText : MutableState<String>){

   // val currentList = vModel.currentTaskList.observeAsState(arrayListOf())
    val currentList = vModel.currentTaskList
    val scope  = rememberCoroutineScope()

   // vModel.loginRequestLiveData
    LazyColumn(
        modifier = Modifier
            .background(graySurface)
            .padding(5.dp)
            .fillMaxSize()

    ){

        items(
            currentList
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
                            .clickable {
                                cameraPositionState?.position = CameraPosition.fromLatLngZoom(
                                    LatLng(item.lat ?: 37.4198, item.lng ?: -122.0788), 14f
                                )
                                scope.launch { state.bottomDrawerState.collapse() }
                                buttonText.value = "Expand"
                            }

                    )
                    Column(modifier = Modifier
                        .padding(8.dp)
                        .verticalScroll(rememberScrollState())
                        .clickable(onClick = {
                            vModel.fetchTaskById(item.taskId)
//                            vModel.getReviews(2, 2)
                            navcontroller.navigate(NavScreens.WhenJob.route + "/${item.taskId}")

                        })
                    ){

                        Text(text = "${item.task_name?: "No name Found"}", fontSize = 18.sp, fontWeight = FontWeight.W500, modifier = Modifier.fillMaxWidth())
                        Text(text = "${item.person_name}", fontSize = 14.sp,  modifier = Modifier.fillMaxWidth())
                        Text(text = "Hourly $${item.hourly_rate?: 0}", fontSize = 14.sp,  modifier = Modifier.fillMaxWidth())
                        Text(text = "Address: ${item.address ?: "No Address Found"}, CA", fontSize = 14.sp,  modifier = Modifier.fillMaxWidth())

                        Spacer(modifier = Modifier.padding(5.dp))

                        Text(text = "Description: \n\"${item.description} \"",
                            overflow = TextOverflow.Visible,
                            fontSize = 14.sp,
                            fontFamily = FontFamily.Serif
                        )
                    }
                }
            }

        }

    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun LazyScrollSkillBoard(vModel: TheViewModel, navcontroller:NavController , state: BottomDrawerScaffoldState, buttonText:MutableState<String>){

    val scope  = rememberCoroutineScope()

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
                            .clickable {
                                cameraPositionState?.position = CameraPosition.fromLatLngZoom(
                                    LatLng(item.lat, item.lng), 14f)

                                scope.launch { state.bottomDrawerState.collapse() }
                                buttonText.value = "Expand"
                            }
                    )
                    Column(modifier = Modifier
                        .padding(8.dp)
                        .verticalScroll(rememberScrollState())
                        .clickable(onClick = {

                            vModel.getReviews(2, 2)
                            navcontroller.navigate(NavScreens.WhenSkill.route + "/${item.id - 1}") {
                                popUpTo(NavScreens.WhenSkill.route)
                                launchSingleTop = true
                            }

                        })
                    ){

                        Text(text = "${item.name}", fontSize = 18.sp, fontWeight = FontWeight.W500, modifier = Modifier.fillMaxWidth())
                        Text(text = "Hourly $${item.hourlyRate}", fontSize = 14.sp,  modifier = Modifier.fillMaxWidth())
                        Text(text = "Areas served: ${item.workLocation}, CA", fontSize = 14.sp,  modifier = Modifier.fillMaxWidth())
                        Text(text = "Hours: ${item.available}", fontSize = 14.sp,  modifier = Modifier.fillMaxWidth())
                        Spacer(modifier = Modifier.padding(5.dp))

                        Text(text = "Description: \n\"${item.description} \"",
                            overflow = TextOverflow.Visible,
                            fontSize = 14.sp,
                            fontFamily = FontFamily.Serif
                        )
                    }
                }
            }

        }

    }
}