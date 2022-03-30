package com.example.instatask.ui.app.screens

import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusRequester
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

//Home Screen
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

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start=10.dp, top=200.dp, end = 10.dp)
        ) {
            Card(
                elevation = 5.dp
            ){
                Image(painter= painterResource(id = R.drawable.ic_launcher_background), contentDescription = null, contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize())
                Column(modifier= Modifier
                    .fillMaxSize()
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
}

//Entrance Screen
@Preview(showBackground = true)
@Composable
fun EntranceScreen(){
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .fillMaxHeight()
            .background(colorResource(id = R.color.transparent)),
        //.wrapContentSize(Alignment.Center)
    ) {    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start=2.dp, top=0.dp, end = 2.dp)
    ) {
        Image(
            painterResource(R.drawable.ic_sea_icon_round),
            contentDescription = "Test 1",
            modifier = Modifier.fillMaxWidth()
                .size(80.dp)
                .background(colorResource(id = R.color.white))
                .clickable(
                    enabled = true,
                    onClickLabel = "Clickable image",
                    onClick = {Toast.makeText(context,"Image clicked",Toast.LENGTH_SHORT).show()
                    }
                )

        )
    }
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start=2.dp, top=0.dp, end = 2.dp, bottom = 20.dp)
        ) {
                Box(){
                Image(
                    painterResource(R.drawable.employee),
                    contentDescription = "Test 1",
                    modifier = Modifier.fillMaxWidth()
                        .size(200.dp)
                        .background(colorResource(id = R.color.white))
                        .clip(RoundedCornerShape(100.dp))
                        .clickable(
                            enabled = true,
                            onClickLabel = "Clickable image",
                            onClick = {
                                Toast.makeText(
                                    context,
                                    "Employee Button clicked",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        )
                )
                    Text(
                        text = "JOB SEEKERS",
                        fontSize = 15.sp,
                        color = Color.Black,
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .padding(top=200.dp)
                    )
                }

        }
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start=2.dp, top=0.dp, end = 2.dp, bottom=20.dp),

        ) {
            Box() {
                Image(
                    painterResource(R.drawable.employer),
                    contentDescription = "Test 1",
                    modifier = Modifier.fillMaxWidth()
                        .size(250.dp)
                        .background(colorResource(id = R.color.white))
                        .clip(RoundedCornerShape(100.dp))
                        .clickable(
                            enabled = true,
                            onClickLabel = "Clickable image",
                            onClick = {
                                Toast.makeText(
                                    context,
                                    "Employer Button clicked",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        )
                )
                Text(
                    text = "EMPLOYER",
                    fontSize = 15.sp,
                    color = Color.Black,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(top=250.dp)
                )
            }




            }

    }
}


@Preview(showBackground = true)
@Composable
fun LandingScreen(){

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .fillMaxHeight()
            .background(colorResource(id = R.color.transparent)),
        //.wrapContentSize(Alignment.Center)
    ){        Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start=2.dp, top=0.dp, end = 2.dp)
    ) {
        Image(
            painterResource(R.drawable.ic_sea_icon_round),
            contentDescription = "Test 1",
            modifier = Modifier.fillMaxWidth()
                .size(80.dp)
                .background(colorResource(id = R.color.white))
                .clickable(
                    enabled = true,
                    onClickLabel = "Clickable image",
                    onClick = {Toast.makeText(context,"Image clicked",Toast.LENGTH_SHORT).show()
                    }
                )

        )
    }


        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start=0.dp, top=20.dp, end = 0.dp)
        ) {
            Image(
                painterResource(R.drawable.background),
                contentDescription = "Test 1",
                modifier = Modifier.fillMaxWidth()
                    .size(300.dp)
                    .background(colorResource(id = R.color.white))
                    .clip(RoundedCornerShape(100.dp))
                    .clickable(
                        enabled = true,
                        onClickLabel = "Clickable image",
                        onClick = {Toast.makeText(context,"Image clicked",Toast.LENGTH_SHORT).show()
                        }
                    )

            )
        }

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start=80.dp, top=20.dp, end = 80.dp)
        ) {
            Box() {
                Image(
                    painterResource(R.drawable.house),
                    contentDescription = "Test 1",
                    modifier = Modifier
                        .size(60.dp)
                        .background(colorResource(id = R.color.white))
                        .clip(RoundedCornerShape(50.dp))
                        .clickable(
                            enabled = true,
                            onClickLabel = "Clickable image",
                            onClick = {
                                Toast.makeText(context, "Image clicked", Toast.LENGTH_SHORT).show()
                            }
                        )

                )
                Text(
                    text = "Maintenance",
                    fontSize = 10.sp,
                    color = Color.Red,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(top=55.dp)
                )
            }
            Box() {
                Image(
                    painterResource(R.drawable.cleaning),
                    contentDescription = "Test 2",
                    modifier = Modifier
                        .size(60.dp)
                        .background(colorResource(id = R.color.white))
                        .clip(RoundedCornerShape(50.dp))
                        .clickable(
                            enabled = true,
                            onClickLabel = "Clickable image",
                            onClick = {
                                Toast.makeText(context, "Image clicked", Toast.LENGTH_SHORT).show()
                            }
                        )
                )
                Text(
                    text = "Cleaner",
                    fontSize = 10.sp,
                    color = Color.Red,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(top=55.dp)
                )
            }
            Box() {
                Image(
                    painterResource(R.drawable.kitchen),
                    contentDescription = "Test 3",
                    modifier = Modifier
                        .size(60.dp)
                        .background(colorResource(id = R.color.white))
                        .clip(RoundedCornerShape(50.dp))
                        .clickable(
                            enabled = true,
                            onClickLabel = "Clickable image",
                            onClick = {
                                Toast.makeText(context, "Image clicked", Toast.LENGTH_SHORT).show()
                            }
                        )
                )
                Text(
                    text = "Kitchen",
                    fontSize = 10.sp,
                    color = Color.Red,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(top=55.dp)
                )
            }

        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start=80.dp, top=10.dp, end = 80.dp)
        ) {
            Box() {
                Image(
                    painterResource(R.drawable.pets),
                    contentDescription = "Test 1",
                    modifier = Modifier
                        .size(60.dp)
                        .background(colorResource(id = R.color.white))
                        .clip(RoundedCornerShape(50.dp))

                        .clickable(
                            enabled = true,
                            onClickLabel = "Clickable image",
                            onClick = {
                                Toast.makeText(context, "Image clicked", Toast.LENGTH_SHORT).show()
                            }
                        )

                )
                Text(
                    text = "Pets",
                    fontSize = 10.sp,
                    color = Color.Red,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(top=55.dp)
                )
            }
            Box() {
                Image(
                    painterResource(R.drawable.trash),
                    contentDescription = "Test 2",
                    modifier = Modifier
                        .size(60.dp)
                        .background(colorResource(id = R.color.white))
                        .clip(RoundedCornerShape(50.dp))

                        .clickable(
                            enabled = true,
                            onClickLabel = "Clickable image",
                            onClick = {
                                Toast.makeText(context, "Image clicked", Toast.LENGTH_SHORT).show()
                            }
                        )
                )
                Text(
                    text = "Trash",
                    fontSize = 10.sp,
                    color = Color.Red,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(top=55.dp)
                )
            }
            Box() {
                Image(
                    painterResource(R.drawable.garage),
                    contentDescription = "Test 3",
                    modifier = Modifier
                        .size(60.dp)
                        .background(colorResource(id = R.color.white))
                        .clip(RoundedCornerShape(50.dp))

                        .clickable(
                            enabled = true,
                            onClickLabel = "Clickable image",
                            onClick = {
                                Toast.makeText(context, "Image clicked", Toast.LENGTH_SHORT).show()
                            }
                        )
                )
                Text(
                    text = "Garage",
                    fontSize = 10.sp,
                    color = Color.Red,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(top=55.dp)
                )
            }
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start=80.dp, top=20.dp, end = 80.dp)
        ) {
            Button( modifier=Modifier
                .shadow(
                    elevation = 10.dp,
                    shape = CircleShape,
                    clip = true
                ),
                onClick = {Toast.makeText(context,"Image clicked",Toast.LENGTH_SHORT).show()},
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Red,
                    contentColor = Color.Red)

                ) {

                Text(text = "Sign Up", color=Color.White)
            }
            Button(
                modifier=Modifier
                    .shadow(
                        elevation = 10.dp,
                        shape = CircleShape,
                        clip = true
                    ),
                onClick = {Toast.makeText(context,"Image clicked",Toast.LENGTH_SHORT).show()},
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Blue,
                    contentColor = Color.Red)

                ) {

                Text(text = "Login", color=Color.White)
            }
        }
    }
}

//SignUp Screen
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
            .padding(top = 40.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start=2.dp, top=0.dp, end = 2.dp)
        ) {
            Image(
                painterResource(R.drawable.ic_sea_icon_round),
                contentDescription = "Test 1",
                modifier = Modifier.fillMaxWidth()
                    .size(80.dp)
                    .background(colorResource(id = R.color.white))
                    .clickable(
                        enabled = true,
                        onClickLabel = "Clickable image",
                        onClick = {Toast.makeText(context,"Image clicked",Toast.LENGTH_SHORT).show()
                        }
                    )

            )
        }
        Spacer(modifier = Modifier.padding(10.dp))
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            //FullName Addres textfield field
            OutlinedTextField(value = fullName.value, onValueChange = {fullName.value=it},
                label = {Text(text="Full Name", color = Color.Black, style = TextStyle(letterSpacing = TextUnit.Unspecified),
                    fontSize = TextUnit.Unspecified)},

                singleLine = true,
                modifier = Modifier.fillMaxWidth(0.8f))
            //Email Addres textfield field
            OutlinedTextField(value = email.value, onValueChange = {email.value=it},
                label = {Text(text="Email Address", color = Color.Black, style = TextStyle(letterSpacing = TextUnit.Unspecified),
                    fontSize = TextUnit.Unspecified)},

                singleLine = true,
                modifier = Modifier.fillMaxWidth(0.8f))
            //Password Addres textfield field
            OutlinedTextField(value = password.value, onValueChange = {password.value=it},
                label = {Text(text="Password", color = Color.Black, style = TextStyle(letterSpacing = TextUnit.Unspecified),
                    fontSize = TextUnit.Unspecified)},

                singleLine = true,
                modifier = Modifier.fillMaxWidth(0.8f),
                trailingIcon = {
                    IconButton(
                        modifier=Modifier,
                        onClick = { /*TODO*/
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
                label = {Text(text="address", color = Color.Black, style = TextStyle(letterSpacing = TextUnit.Unspecified),
                    fontSize = TextUnit.Unspecified)},

                singleLine = true,
                modifier = Modifier.fillMaxWidth(0.8f)
            )
            //ZipCode  textfield field
            OutlinedTextField(value = zipCode.value, onValueChange = {zipCode.value=it},
                label = {Text(text="zipCode", color = Color.Black, style = TextStyle(letterSpacing = TextUnit.Unspecified),
                    fontSize = TextUnit.Unspecified)},

                singleLine = true,
                modifier = Modifier.fillMaxWidth(0.8f)
            )

            Spacer(modifier = Modifier.padding(10.dp))
            // var regStatus by rememberSaveable{ mutableStateOf("") }
            Button(modifier=Modifier
                .fillMaxWidth()
                .padding(start=40.dp, end=40.dp)
                .shadow(
                    elevation = 10.dp,
                    shape = CircleShape,
                    clip = true
                ),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Red,
                    contentColor = Color.Red),

                onClick = { Toast.makeText(context,"You re Signed Up....", Toast.LENGTH_LONG).show()}

            ){
                Text(text="Submit", color = Color.White, style = TextStyle(letterSpacing = TextUnit.Unspecified),
                    fontSize = TextUnit.Unspecified)
            }
            Spacer(modifier=Modifier.padding(10.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 40.dp, top = 20.dp, end = 40.dp)

            ) {
                Text(text="Already have an account?", color = Color.Black, style = TextStyle(letterSpacing = TextUnit.Unspecified),
                    fontSize = TextUnit.Unspecified,
                    modifier=Modifier.padding(start = 80.dp, top = 10.dp))
                Button(
                    modifier=Modifier
                        .shadow(
                            elevation = 10.dp,
                            shape = CircleShape,
                            clip = true
                        ),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.Blue,
                        contentColor = Color.Blue),
                    onClick = {Toast.makeText(context,"Login..", Toast.LENGTH_LONG).show()},
                ) {
                    Text(text="Login", color = Color.White, style = TextStyle(letterSpacing = TextUnit.Unspecified),
                        fontSize = TextUnit.Unspecified)
                }
            }
        }
    }
}

//SignIn Screen
@Preview(showBackground = true)
@Composable
fun SignInScreen(){
    val context = LocalContext.current
    //val image = Image(painter = painterResource(id = R.drawable.project1backgroung), contentDescription = null)
    val emailAddress = remember{ mutableStateOf("")}
    val password = remember{ mutableStateOf("")}
    val passwordVisibilty = remember{ mutableStateOf(false)}
    val focusRequester: FocusRequester = remember { FocusRequester() }
    val scrollState= rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.white))
            .wrapContentSize(Alignment.Center)
            .padding(top = 40.dp)
    ){
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start=2.dp, top=0.dp, end = 2.dp)
        ) {
            Image(
                painterResource(R.drawable.ic_sea_icon_round),
                contentDescription = "Test 1",
                modifier = Modifier.fillMaxWidth()
                    .size(80.dp)
                    .background(colorResource(id = R.color.white))
                    .clickable(
                        enabled = true,
                        onClickLabel = "Clickable image",
                        onClick = {Toast.makeText(context,"Image clicked",Toast.LENGTH_SHORT).show()
                        }
                    )

            )
        }
        var emailAddress by rememberSaveable{mutableStateOf("")}
        var Password by rememberSaveable{mutableStateOf("")}
        Spacer(modifier = Modifier.padding(15.dp))
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            OutlinedTextField(value = emailAddress, onValueChange = {emailAddress=it},
                label = {Text(text="Email Address", color = Color.Black, style = TextStyle(letterSpacing = TextUnit.Unspecified),
                    fontSize = TextUnit.Unspecified)},
                singleLine = true,
                modifier = Modifier.fillMaxWidth(0.8f))
            OutlinedTextField(value = Password, onValueChange = {Password=it},
                trailingIcon = {
                    IconButton(modifier=Modifier,
                        onClick = { /*TODO*/
                            passwordVisibilty.value= !passwordVisibilty.value
                        }) {

                        Image(painterResource(id = R.drawable.eye_password), contentDescription = null)
                        if(passwordVisibilty.value) Color.Red else Color.Gray
                    }
                },
                label = {Text(text="Password", color = Color.Black, style = TextStyle(letterSpacing = TextUnit.Unspecified),
                    fontSize = TextUnit.Unspecified)},

                singleLine = true,
                visualTransformation = if(passwordVisibilty.value) VisualTransformation.None
                else PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth(0.8f)
            )
            Spacer(modifier = Modifier.padding(10.dp))

            //Email and Password Check Button
            var status by rememberSaveable{mutableStateOf("")}
            val context= LocalContext.current
            Button(
                modifier=Modifier
                    .fillMaxWidth()
                    .padding(start=40.dp, end=40.dp)
                    .shadow(
                        elevation = 10.dp,
                        shape = CircleShape,
                        clip = true
                    ),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Red,
                    contentColor = Color.Red),

                onClick = {Toast.makeText(context,"You re Signed In....", Toast.LENGTH_LONG).show()},
            ){
                Text(text="Login", color = Color.White, style = TextStyle(letterSpacing = TextUnit.Unspecified),
                    fontSize = TextUnit.Unspecified)
            }
            Spacer(modifier=Modifier.padding(10.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 40.dp, top = 20.dp, end = 40.dp)

            ) {
                Text(text="Don't have an account?", color = Color.Black, style = TextStyle(letterSpacing = TextUnit.Unspecified),
                    fontSize = TextUnit.Unspecified,
                    modifier=Modifier.padding(start = 80.dp, top = 10.dp))
                Button(
                    modifier=Modifier
                        .shadow(
                            elevation = 10.dp,
                            shape = CircleShape,
                            clip = true
                        ),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.Blue,
                        contentColor = Color.Blue),
                    onClick = {Toast.makeText(context,"Signing Up..", Toast.LENGTH_LONG).show()},
                ) {
                    Text(text="Sign Up", color = Color.White, style = TextStyle(letterSpacing = TextUnit.Unspecified),
                        fontSize = TextUnit.Unspecified)
                }
            }
        }
    }

}

//Profile Screen
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
            Column(modifier= Modifier
                .fillMaxSize()
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

//LogOut Screen
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
            Column(modifier= Modifier
                .fillMaxSize()
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

//Settings Screen
@Preview(showBackground = true)
@Composable
fun SettingsScreen(){
    Column( horizontalAlignment= Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 10.dp)
            .background(colorResource(id = R.color.white))
        //.wrapContentSize(Alignment.Center)
    ) {
        Card(
            elevation = 5.dp
        ){
            Image(painter= painterResource(id = R.drawable.ic_launcher_background), contentDescription = null, contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize())
            Column(modifier= Modifier
                .fillMaxSize()
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






