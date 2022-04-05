package com.example.instatask.ui.app

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun ProfileScreen(
    user:UserInfo,
    activity: Activity
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        //------------Box1-------
//        Box(modifier = Modifier.fillMaxWidth()) {
//            Button(onClick = { /*TODO*/ },modifier = Modifier.background(Color.Gray)) {
//                Text(text = "Navigation Drawer")
//            }
//        }
        //-------------Box2------------------
        Box() {
            val profileImg = painterResource(id = com.example.instatask.R.drawable.head)
            Box(
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    ImageCard(painter = profileImg,modifier = Modifier
                        .width(250.dp)
                        .height(180.dp))

//                    Box(){
//                        val plusIcon=painterResource(id = com.example.instatask.R.drawable.plus)
//                        Row(verticalAlignment = Alignment.CenterVertically,horizontalArrangement = Arrangement.SpaceBetween) {
//
//                            Box(){
//                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
//                                    Button(onClick = { /*TODO*/ },shape = CircleShape,modifier = Modifier.size(50.dp)) {
//                                        Icon(painter = plusIcon, contentDescription = "Find Job")
//                                    }
//                                    Text(text = "Find Job")
//                                }
//                            }
//                            Box(){
//                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
//                                    Button(
//                                        onClick = { /*TODO*/ },
//                                        shape = CircleShape,
//                                        modifier = Modifier.size(50.dp)
//                                    ) {
//                                        Icon(painter = plusIcon, contentDescription = "Change Pic")
//                                    }
//                                    Text(text = "Change Pic")
//                                }
//                            }
//                            Box(){
//                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
//                                    Button(
//                                        onClick = { /*TODO*/ },
//                                        shape = CircleShape,
//                                        modifier = Modifier.size(50.dp)
//                                    ) {
//                                        Icon(painter = plusIcon, contentDescription = "Post Job")
//                                    }
//                                    Text(text = "Post Job")
//                                }
//                            }
//
//                        }
//
//                    }
                }
            }
        }
        //-----------Box3----------------------
        Box(
            modifier = Modifier
                .padding(all = 25.dp)
        ) {
            Card(
                modifier = Modifier
                    .shadow(1.dp,RectangleShape).background(Color.White),
                elevation = 4.dp
            ) {
            Column(
                modifier = Modifier
                    .padding(20.dp)
            ) {
//
                    Text(text = "User Info:")
                    Text(text = "Name: ${user.name}")
                    Text(text = "Email: ${user.email}")
                    Text(text = "Address: ${user.address}")
                    Text(text = "Zip: ${user.zip}")
                }
            }
        }
        //-------------Box4-------------------
        Box(
            modifier = Modifier
                .padding(all = 25.dp)
        ) {
            Card(
                modifier = Modifier
                    .shadow(1.dp,RectangleShape).background(Color.White),
                elevation = 4.dp
            ) {
                Column(
                    modifier = Modifier
                        .padding(20.dp)
                ) {
                    Box() {
                            Column() {

                                Text(text = "Current Activities:")
                                Text(text = " ")
                                Text(text = "if accepted a job || if posted job in progress->")
                                Text(text = "navigation when-job-accepted on component click")
                                Text(text = " ")
                                Text(text = "if none in progress, show picture of cat")
                            }
                    }
                    Box() {
                        Column() {
                            Text(text = "Old Activities:")
                            Text(text = " ")
                            Text(text = "Job description: ")
                            Text(text = "Completion date:")
                            Text(text = "Money earned:")
//                    for(elm in activity.oldActivity){
//                        println(elm)
//                    }
                        }
                    }
                }
            }
        }
        //-----------Box5------------------------------
        Box() { Text(text = "Person Name: ${user.name}   Date:Today's Date") }
    }
}



