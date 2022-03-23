package com.pelp

import android.util.Log
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.keyframes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
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

var who:String = ""
@Composable
fun LoginScreen(
    navController: NavController ,
) {
    var userName by rememberSaveable { mutableStateOf("")}
    Log.d(Examples.TAG,"Hello from Login")
    var alert by rememberSaveable { mutableStateOf(false)}
    var sizeState by remember { mutableStateOf(0.dp) }
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(5.dp)) {

        Surface(
            modifier = Modifier
                .size(120.dp)
                .padding(15.dp),
            shape = CircleShape
        ) {

            Image(
                painter = painterResource(id = R.drawable.ic_sea_icon_round),
                contentDescription = "Sea World",
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
            )


        }
        Spacer(modifier = Modifier.padding(10.dp))
        Text(text="Disclaimers: A statement that denies something, especially responsibility." ,
            fontSize = 12.sp,
            modifier = Modifier
                .height(50.dp)
                .fillMaxWidth(),
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center,
            color=Color.Black
            )

        var result by rememberSaveable {mutableStateOf("admin/admin")}

        var password by rememberSaveable {mutableStateOf("")}
        Surface(
            shape = RoundedCornerShape(3.dp)
        ) {
            OutlinedTextField(
                value = userName,
                onValueChange = { userName = it },
                shape = RoundedCornerShape(3.dp),
                label = { Text(text = "User Name") },
                modifier = Modifier.width(350.dp)

                )

        }
        Surface(
            shape = RoundedCornerShape(3.dp)
        ) {
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                shape = RoundedCornerShape(3.dp),
                label = { Text(text = "Password") },
                modifier = Modifier.width(350.dp)
                )
        }
        Surface(
            shape = RoundedCornerShape(3.dp), modifier = Modifier.padding(10.dp)

        ) {


            Button(onClick = { who = userName
                if(Database.data.loginVerify(userName, password)){
                  //  alert = true
                    sizeState += 450.dp
             //   navController.navigate(route=Screen.Main.route)
                }
              else{
                    result= "These credential does not match our record"
                }
            {
            //    popUpTo(Screen.Main.route){
            //        inclusive=true

         //       }
            }
                             }, modifier = Modifier
                .width(350.dp)
                .height(50.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red)

            ){
                Text(text = "Log in with Email", fontSize = 15.sp, fontStyle = FontStyle.Normal, modifier = Modifier.padding(2.dp),color=Color.White)
            }

        }
        Text(text=result)
       Spacer(modifier = Modifier.padding(100.dp))
        Row() {
            Box(modifier = Modifier.fillMaxHeight(), contentAlignment = Alignment.TopStart) {
                Text(
                    text = "Already have a Pelp Account?",
                    color=Color.Black,
                    fontSize = 15.sp,
                    modifier = Modifier
                       ,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.Normal,

                )
            }
            Button(onClick = {
                             navController.navigate(Screen.Signup.route)
            }, modifier = Modifier
                .height(40.dp)
                .width(100.dp)
                ,
                colors = ButtonDefaults.buttonColors(backgroundColor = lightBlue)

            ){
                Text(text = "Sign Up", modifier = Modifier.padding(2.dp),color=Color.White)
            }

        }
    }
/*
    if(alert) {
        alert = false
        loginAnimation(sizeState)
    }
    else {
        loginAnimation()
    }

 */

    val size by animateDpAsState(targetValue = sizeState,
        keyframes {
            durationMillis = 3000
            sizeState at 0 with FastOutLinearInEasing
            sizeState * 1.5f at 1000 with FastOutLinearInEasing
            sizeState * 2f at 3000

        }
    )
    var alpha by rememberSaveable{ mutableStateOf(0.3f) }

Log.d(Examples.TAG, "Size is $size")
    if(size>800.dp) {
        navController.navigate(Screen.Main.route) {
            popUpTo(Screen.Main.route) {
                           inclusive=true
            }
        }
    }
    if(size>400.dp && size<800.dp){
        alpha = 0.4f

    }
    else {
        alpha=1.0f

    }

        Box(
            modifier = Modifier
                .size(size)
                .background(Color.Red)
                .wrapContentSize(),

            contentAlignment = Alignment.Center

        ) {

            Text(
                text = "Welcome $userName!", modifier = Modifier
                    .fillMaxWidth()
                    .alpha(alpha),
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                fontStyle= FontStyle.Normal,
                color = Color.White,
                textAlign = TextAlign.Center

               )

        }


}