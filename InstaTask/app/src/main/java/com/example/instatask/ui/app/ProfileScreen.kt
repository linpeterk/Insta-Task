package com.example.instatask.ui.app

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ProfileScreen(
    user:UserInfo,
    activity: Activity
) {
//    Text(text = "This is my Profile Page:${user.name}//${user.address}//>>//")
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Box(){
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Navigation Drawer")
            }
        }
        Box(){
            Text(text = "Box with Image and round button")
        }
        Box(){
            Column(
                //modifier = Modifier.fillMaxSize(),
                //horizontalAlignment = Alignment.Start
            ) {
                Text(text = "User Info:")
                Text(text = "Name: ${user.name}")
                Text(text = "Email: ${user.email}")
                Text(text = "Address: ${user.address}")
                Text(text = "Zip: ${user.zip}")
            }
        }
        Box(){
            Column() {
                Box() {
                    Text(text = "Current Activities:")
                    for(elmnt in activity.currentActivity){
                        println(elmnt)
                    }
                }
                Box() {
                    Text(text = "Old Activities:")
                    for(elm in activity.oldActivity){
                        println(elm)
                    }
                }
            }
        }
        Box(){ Text(text = "Person Name: ${user.name}   Date:Today's Date")}
    }
}



