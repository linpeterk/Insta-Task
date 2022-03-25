package com.example.instatask.ui.app.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instatask.R

@Preview(showBackground = true)
@Composable
fun HomeScreen(){
    Column( horizontalAlignment= Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 20.dp)
            .background(colorResource(id = R.color.white))
        //.wrapContentSize(Alignment.Center)
    ) {
        Card(
            elevation = 5.dp
        ){
            Image(painter= painterResource(id = R.drawable.ic_launcher_background), contentDescription = null, contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize())
            Column(modifier= Modifier.fillMaxSize()
                .padding(0.dp)){
                Text(
                    text = "Home!",
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    textAlign = TextAlign.Center,
                    fontSize = 25.sp
                )
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreen(){
    Column( horizontalAlignment= Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 20.dp)
            .background(colorResource(id = R.color.white))
        //.wrapContentSize(Alignment.Center)
    ) {
        Card(
            elevation = 5.dp
        ){
            Image(painter= painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = null, contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize())
            Column(modifier= Modifier.fillMaxSize()
                .padding(0.dp)){
                Text(
                    text = "Profile",
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    textAlign = TextAlign.Center,
                    fontSize = 25.sp
                )
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun SettingsScreen(){
    Column( horizontalAlignment= Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 20.dp)
            .background(colorResource(id = R.color.white))
        //.wrapContentSize(Alignment.Center)
    ) {
        Card(
            elevation = 5.dp
        ){
            Image(painter= painterResource(id = R.drawable.ic_launcher_background), contentDescription = null, contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize())
            Column(modifier= Modifier.fillMaxSize()
                .padding(0.dp)){
                Text(
                    text = "Settings",
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    textAlign = TextAlign.Center,
                    fontSize = 25.sp
                )
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun LogOutScreen(){
    Column( horizontalAlignment= Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 20.dp)
            .background(colorResource(id = R.color.white))
        //.wrapContentSize(Alignment.Center)
    ) {
        Card(
            elevation = 5.dp
        ){
            Image(painter= painterResource(id = R.drawable.ic_launcher_background), contentDescription = null, contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize())
            Column(modifier= Modifier.fillMaxSize()
                .padding(0.dp)){
                Text(
                    text = "LogOut",
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    textAlign = TextAlign.Center,
                    fontSize = 25.sp
                )
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun SignInScreen(){
    Column( horizontalAlignment= Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 20.dp)
            .background(colorResource(id = R.color.white))
        //.wrapContentSize(Alignment.Center)
    ) {
        Card(
            elevation = 5.dp
        ){
            Image(painter= painterResource(id = R.drawable.ic_launcher_background), contentDescription = null, contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize())
            Column(modifier= Modifier.fillMaxSize()
                .padding(0.dp)){
                Text(
                    text = "SignIn",
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    textAlign = TextAlign.Center,
                    fontSize = 25.sp
                )
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun SignUpScreen(){
    val context = LocalContext.current
    val fullName = rememberSaveable{ mutableStateOf("") }
    val email = rememberSaveable{ mutableStateOf("") }
    val password = rememberSaveable{ mutableStateOf("") }
    val address = rememberSaveable{ mutableStateOf("") }
    val zipCode = rememberSaveable{ mutableStateOf("") }

    val passwordVisibilty = rememberSaveable{ mutableStateOf(false) }
    val confirmationOfPasswordVisibilty = rememberSaveable{ mutableStateOf(false) }

    val scrollSate= rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.white))
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text="Sign Up", fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 25.sp
        )
        Spacer(modifier = Modifier.padding(10.dp))
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            //FullName Addres textfield field
            OutlinedTextField(value = fullName.value, onValueChange = {fullName.value=it},
                label = {Text(text="Full Name", color = Color.Black, style = TextStyle(fontWeight = FontWeight.Bold, letterSpacing = TextUnit.Unspecified),
                    fontSize = TextUnit.Unspecified)},
                placeholder = {Text(text="Full Name", color = Color.Black, style = TextStyle(fontWeight = FontWeight.Bold, letterSpacing = TextUnit.Unspecified),
                    fontSize = TextUnit.Unspecified )},
                singleLine = true,
                modifier = Modifier.fillMaxWidth(0.8f))
            //Email Addres textfield field
            OutlinedTextField(value = email.value, onValueChange = {email.value=it},
                label = {Text(text="Email Address", color = Color.Black, style = TextStyle(fontWeight = FontWeight.Bold, letterSpacing = TextUnit.Unspecified),
                    fontSize = TextUnit.Unspecified)},
                placeholder = {Text(text="Email Address", color = Color.Black, style = TextStyle(fontWeight = FontWeight.Bold, letterSpacing = TextUnit.Unspecified),
                    fontSize = TextUnit.Unspecified)},
                singleLine = true,
                modifier = Modifier.fillMaxWidth(0.8f))
            //Password Addres textfield field
            OutlinedTextField(value = password.value, onValueChange = {password.value=it},
                label = {Text(text="Password", color = Color.Black, style = TextStyle(fontWeight = FontWeight.Bold, letterSpacing = TextUnit.Unspecified),
                    fontSize = TextUnit.Unspecified)},
                placeholder = {Text(text="Password", color = Color.Black, style = TextStyle(fontWeight = FontWeight.Bold, letterSpacing = TextUnit.Unspecified),
                    fontSize = TextUnit.Unspecified)},
                singleLine = true,
                modifier = Modifier.fillMaxWidth(0.8f),
                trailingIcon = {
                    IconButton(onClick = { /*TODO*/
                        passwordVisibilty.value= !passwordVisibilty.value
                    }) {

                        Image(painterResource(id = R.drawable.eye_password), contentDescription = null)
                        if(passwordVisibilty.value) Color.Red else Color.Gray
                    }
                },
                visualTransformation = if(passwordVisibilty.value) VisualTransformation.None
                else PasswordVisualTransformation()
            )
            //Address Addres textfield field
            OutlinedTextField(value = address.value, onValueChange = {address.value=it},
                label = {Text(text="address", color = Color.Black, style = TextStyle(fontWeight = FontWeight.Bold, letterSpacing = TextUnit.Unspecified),
                    fontSize = TextUnit.Unspecified)},
                placeholder = {Text(text="address", color = Color.Black, style = TextStyle(fontWeight = FontWeight.Bold, letterSpacing = TextUnit.Unspecified),
                    fontSize = TextUnit.Unspecified)},
                singleLine = true,
                modifier = Modifier.fillMaxWidth(0.8f)
            )
            //ZipCode  textfield field
            OutlinedTextField(value = zipCode.value, onValueChange = {zipCode.value=it},
                label = {Text(text="zipCode", color = Color.Black, style = TextStyle(fontWeight = FontWeight.Bold, letterSpacing = TextUnit.Unspecified),
                    fontSize = TextUnit.Unspecified)},
                placeholder = {Text(text="zipCode", color = Color.Black, style = TextStyle(fontWeight = FontWeight.Bold, letterSpacing = TextUnit.Unspecified),
                    fontSize = TextUnit.Unspecified)},
                singleLine = true,
                modifier = Modifier.fillMaxWidth(0.8f)
            )

            Spacer(modifier = Modifier.padding(10.dp))
           // var regStatus by rememberSaveable{ mutableStateOf("") }
            Button(onClick = { Toast.makeText(context,"You re Signed Up....", Toast.LENGTH_LONG).show()},
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.Red),
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(50.dp)
                    .background(colorResource(id = R.color.purple_200))

            ){
                Text(text="Submit", color = Color.White, style = TextStyle(fontWeight = FontWeight.Bold, letterSpacing = TextUnit.Unspecified),
                    fontSize = TextUnit.Unspecified)
            }
        }
    }
}




