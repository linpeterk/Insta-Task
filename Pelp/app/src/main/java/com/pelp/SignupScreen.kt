package com.pelp

import android.util.Log
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.keyframes
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.saveable.rememberSaveableStateHolder
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.pelp.model.data.loginAnimation
import com.pelp.ui.theme.lightBlue

@Composable
fun SignupScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(7.dp)
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(7.dp)
        ) {
            Fields()
        }
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(7.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "Pelp, Yelp for Poop")
        }
        Spacer(modifier = Modifier
            .weight(2f)
        )
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(7.dp),
            horizontalArrangement = Arrangement.Center
        ){
            Button(onClick = {
                navController.navigate(Screen.Login.route)
            }) {
                Text("Login with Email")
            }
        }
    }
}

@Composable
fun Fields() {
    var username by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var realName by rememberSaveable { mutableStateOf("") }
    var zip by rememberSaveable { mutableStateOf("") }
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(4.dp)) {
        Surface(
            modifier = Modifier.size(59.dp),
            shape = CircleShape
        ) {
            Image(
                painter = painterResource(id = R.drawable.sea),
                contentDescription = "Sea World",
                modifier = Modifier
                    .size(59.dp)
                    .clip(CircleShape)
            )
        }
        Spacer(modifier = Modifier.padding(9.dp))
        Surface (
            shape = RoundedCornerShape(2.dp)
        ) {
            OutlinedTextField(
                value = username,
                onValueChange = {username = it},
                shape = RoundedCornerShape(2.dp),
                label = { Text(text = "username")},
                modifier = Modifier.width(349.dp)
            )
        }
        Surface (
            shape = RoundedCornerShape(2.dp)
        ){
            OutlinedTextField(
                value = password,
                onValueChange = {password = it},
                shape = RoundedCornerShape(2.dp),
                label = { Text(text = "password")},
                modifier = Modifier.width(349.dp)
            )
        }
        Surface (
            shape = RoundedCornerShape(2.dp)
        ){
            OutlinedTextField(
                value = realName,
                onValueChange = {realName = it},
                shape = RoundedCornerShape(2.dp),
                label = { Text(text = "First and Last Name")},
                modifier = Modifier.width(349.dp)
            )
        }
        Surface (
            shape = RoundedCornerShape(2.dp)
        ){
            OutlinedTextField(
                value = zip,
                onValueChange = {zip = it},
                shape = RoundedCornerShape(2.dp),
                label = { Text(text = "zip code")},
                modifier = Modifier.width(349.dp)
            )
        }
        Surface (
            shape = RoundedCornerShape(2.dp), modifier = Modifier.padding(10.dp)
        ){
            Button(
                onClick ={
                    Database.data.customerAdd(username, password, realName, zip.toInt())
                    //Database.data.checkCustomerSignup(username)
                }
            ){
                Text(text = "Sign Up", modifier = Modifier.padding(1.dp),color=Color.White)
            }
        }
    }
}
