package com.example.instatask.ui.app

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.instatask.ui.Components.MakeGoogleMap
import com.example.instatask.viewmodel.TheViewModel
import com.google.maps.android.compose.GoogleMap

@Composable
fun JobAccepted(
    vModel: TheViewModel, navController:NavController
) {

   // var job = JobDetails("QwertyName",12,15,"Developer","Name_Qwerty","Test_Test","2022-03-01")

    var task = vModel.task.value
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        //------------Box1-------
        Box(modifier = Modifier.fillMaxWidth()) {
            Button(onClick = { /*TODO*/ },modifier = Modifier.background(Color.Gray)) {
                Text(text = "Navigation Drawer")
            }
        }
        //-------------Box2------------------
        Box(modifier = Modifier
            .width(500.dp)
            .height(200.dp)) {
            MakeGoogleMap(vModel = vModel, navController = navController, mode =2)

            //make.googlemap
        }
        //-----------Box3----------------------
        Box(
            modifier = Modifier
                .padding(all = 5.dp)
        ) {
            Column(
                modifier = Modifier
                    .border(2.dp, Color.Gray)
                    .padding(20.dp)
                    .width(500.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "${task.taskId}")
                Text(text = "${task.task_name}")
                Text(text = "Job Accepted on ${task.datetime}")
                Text(text = " ")
                Text(text = "${task.description}")
                Text(text = " ")
                Text(text = "Job Creator: ${task.person_name}")
               // Text(text = "What doing: ${job.desination}")
                Text(text = "$${task.hourly_rate}/Hr")
//                Text(text = "${job.hours} Hours Total")
                Text(text = " ")
                Text(text = "Job Acceptor: ${"??"}")

            }
        }
        //-----------Box4-----------------------------
        Box(){
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                CircularProgressBar(percentage = 0.8f, number = 100)//percentage can be ranged 0.0-1 (ie.0%-100%)--to be passed dynamically;number should always be 100

                Row(){
                    Button(onClick = { /*TODO*/ },modifier = Modifier.background(Color.Gray)) {
                        Text(text = "Contact")
                    }
                    Button(onClick = { /*TODO*/ },modifier = Modifier.background(Color.Gray)) {
                        Text(text = "Job Done")
                    }
                    Button(onClick = { /*TODO*/ },modifier = Modifier.background(Color.Gray)) {
                        Text(text = "Cancelled")
                    }
                }

            }
        }
        //--------------Box5----------------------------
        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)){
            Column(modifier = Modifier
                .border(2.dp, Color.Gray)
                .padding(10.dp)) {
                Text(text = "Maybe implement:")
                Text(text = "Camera")
                Text(text = "Permission")
            }
        }
    }
}