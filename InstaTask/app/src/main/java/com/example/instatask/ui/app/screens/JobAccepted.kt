package com.example.instatask.ui.app

import android.widget.Toast
import com.example.instatask.ui.app.CircularProgressBar



import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.instatask.ui.Components.MakeGoogleMap
import com.example.instatask.viewmodel.TheViewModel
import com.google.maps.android.compose.GoogleMap



@Composable
fun JobAccepted(
    vModel: TheViewModel, navController:NavController
) {

    val context = LocalContext.current

    //var job = JobDetails("QwertyName",12,15,"Developer","Name_Qwerty","Test_Test","2022-03-01")

     var task = vModel.task.value
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        //-------------Box2------------------
        Box( Modifier
            .fillMaxWidth()
            .height(150.dp)) {
            Column(
                horizontalAlignment= Alignment.CenterHorizontally
            ) {
                MakeGoogleMap(vModel = vModel, navController = navController, mode = 1)

            }
        }

//-----------Box3----------------------
        Box(
        ) {
            Card(
                modifier = Modifier
                    .padding(25.dp)
                    .width(500.dp),
                shape = RoundedCornerShape(10.dp),
                contentColor = Color.Black,
                elevation = 15.dp,
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
//                    Text(text = " ")
//                    Text(text = "${task.taskId}")
//                    Text(text = "${task.task_name}")
//                    Text(text = "Job Accepted on ${task.datetime}")
//                    Text(text = " ")
//                    Text(text = "${task.description}")
//                    Text(text = " ")
//                    Text(text = "Job Creator: ${task.person_name}")
//                    // Text(text = "What doing: ${job.desination}")
//                    Text(text = "$${task.hourly_rate}/Hr")
////                Text(text = "${job.hours} Hours Total")
//                    Text(text = " ")
//                    Text(text = "Job Acceptor: ${"??"}")
//                    Text(text = " ")


                    Text(text = "Job Accepted!!!",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 30.sp)
                    Text(text = "Job details")
                   Text(text = "${task.task_name}")
                    Text(text = "Scheduled time")
                      Text(text = " ${task.datetime}")
                    Text(text = "job posted by")
                     Text(text = " ${task.person_name}")
                    Text(text = " $${task.hourly_rate}/hr")

                }
            }

        }


//-----------Box4-----------------------------
        Box() {
            Column(
                Modifier.padding(40.dp),
                horizontalAlignment = Alignment.CenterHorizontally,) {
                CircularProgressBar(
                    percentage = 0.8f,
                    number = 100
                )//percentage can be ranged 0.0-1 (ie.0%-100%)--to be passed dynamically;number should always be 100
                Text(text = " ")
                Row() {

                    Button(onClick = { Toast.makeText(context,"JOB COMPLETED",Toast.LENGTH_LONG).show() }, modifier = Modifier.background(Color.Gray)) {
                        Text(text = "Job Done")
                    }
                    Text(text = " ")
                    Button(onClick = {Toast.makeText(context,"JOB CANCELLED",Toast.LENGTH_LONG).show() }, modifier = Modifier.background(Color.Gray)) {
                        Text(text = "Cancelled")
                    }
                }

            }
        }
    }



}

