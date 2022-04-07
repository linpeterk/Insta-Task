package com.example.instatask.ui.app.screens

import android.graphics.PorterDuff
import android.os.Bundle
import android.widget.RatingBar
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import com.example.instatask.R
import com.example.instatask.data.SliderList
import com.example.instatask.database.datamodel.UserRow
import com.example.instatask.ui.app.Navigation.NavScreens
import com.example.instatask.ui.theme.graySurface
import com.example.instatask.ui.theme.lightBlue
import com.example.instatask.viewmodel.UserInfoViewModel
import com.google.accompanist.pager.*
import kotlin.math.absoluteValue

class SignUp: ComponentActivity(){
    override fun onCreate(savedInstanceSate: Bundle?){
        super.onCreate(savedInstanceSate)
        val userInfoViewModel = ViewModelProvider(this).get(UserInfoViewModel::class.java)

    }
}

//Home Screen

@Composable
fun HomeScreen(navController:NavController){
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
                .padding(start = 10.dp, top = 200.dp, end = 10.dp)
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

//Pager Slider Screen
@ExperimentalPagerApi
@Composable
fun SliderScreen(navController:NavController){
    val context = LocalContext.current
    val pagerState = rememberPagerState(
        pageCount = SliderList.size,
        initialPage = 0
        )
//    LaunchedEffect(Unit){
//     //   while(true){
//            yield()
//   //         delay(2000)
////            pagerState.animateScrollToPage(
////                page = (pagerState.currentPage + 1) % (pagerState.pageCount),
////                animationSpec = tween(1500)
////            )
//      //  }
//    }

    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 2.dp, top = 0.dp, end = 2.dp, 10.dp)
        ) {
            Image(
                painterResource(R.drawable.shamo),
                contentDescription = "Test 1",
                modifier = Modifier
                    .fillMaxWidth()
                    .size(100.dp)
                    .padding(5.dp)
                    .background(colorResource(id = R.color.white))
                    .clickable(
                        enabled = true,
                        onClickLabel = "Clickable image",
                        onClick = {
                            Toast
                                .makeText(context, "Image clicked", Toast.LENGTH_SHORT)
                                .show()
                        }
                    )
            )
        }
        Column(modifier = Modifier
            .height(20.dp)
            .fillMaxWidth()
            .background(color = Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            Text(text="InstaTask", color = graySurface, fontSize = 18.sp)
        }
       Spacer(modifier = Modifier.height(5.dp))
        HorizontalPager(state = pagerState,
            modifier = Modifier
                .weight(1f)
                .padding(0.dp, 0.dp, 0.dp, 40.dp)
        ) {page ->
            Surface(modifier = Modifier
                .graphicsLayer {
                    val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue
                    lerp(
                        start = 0.85f,
                        stop = 1f,
                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    ).also { scale ->
                        scaleX = scale
                        scaleY = scale
                    }
                    alpha = lerp(
                        start = 0.5f,
                        stop = 1f,
                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    )
                }
                .fillMaxWidth()
                .padding(0.dp, 0.dp, 0.dp, 0.dp),
          //  shape = RoundedCornerShape(20.dp)
             ){
                val newSliders = SliderList[page]
                Box(modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .align(Alignment.Center)
                )   {
                    Image(painter = painterResource(id = newSliders.imgUri) , contentDescription = "Image",contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                    Column(modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(15.dp)
                    ) {
                            Text(
                                text=newSliders.title,
                                style = MaterialTheme.typography.h5,
                                color = graySurface,
                                fontWeight = FontWeight.Bold
                            )

                        //val ratingBar = RatingBar(
                        //LocalContext.current, null, R.attr.ratingBarStyleSmall
                        val context = LocalContext.current
                        var ratingBar = RatingBar(context, null, android.R.attr.ratingBarStyleSmall).apply{
                            rating = newSliders.rating
                            progressDrawable.setColorFilter(
                                android.graphics.Color.parseColor("#FF0000"),
                                PorterDuff.Mode.SRC_ATOP
                            )
                        }
                        AndroidView(factory = { ratingBar },
                                modifier = Modifier.padding(0.dp,0.dp,0.dp,0.dp)
                        )
                        Text(
                            text=newSliders.description,
                            style = MaterialTheme.typography.body1,
                            color = graySurface,
                            fontWeight = FontWeight.Normal,
                            modifier = Modifier.padding(0.dp,0.dp,0.dp,0.dp)
                        )
                    }
                }
            }
        }
        //Horizontal dot indicator
        HorizontalPagerIndicator(
            pagerState = pagerState,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp, 0.dp, 16.dp, 20.dp)
        )

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 80.dp, top = 0.dp, end = 80.dp, 20.dp)
        ) {
            Button(
                modifier = Modifier
                    .fillMaxWidth(10f)
                    .shadow(
                        elevation = 10.dp,
                        shape = CircleShape,
                        clip = true
                    ),
                onClick = {
                            navController.navigate(NavScreens.Signup.route)
                            {
                                popUpTo(NavScreens.Signup.route)
                            }
                   // Toast.makeText(context, "Image clicked", Toast.LENGTH_SHORT).show()

                          },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Black,
                    contentColor = Color.Black
                )

            ) {

                Text(text = "Sign Up", color = Color.White)
            }

        }
        Spacer(modifier = Modifier.height(2.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 80.dp, top = 0.dp, end = 80.dp, 20.dp)
            )
            {
                Button(
                    modifier = Modifier
                        .fillMaxWidth(10f)
                        .shadow(
                            elevation = 10.dp,
                            shape = CircleShape,
                            clip = true
                        ),
                    onClick = {
                        navController.navigate(NavScreens.Login.route)
                        {
                            popUpTo(NavScreens.Login.route)
                        }

                      //  Toast.makeText(context, "Image clicked", Toast.LENGTH_SHORT).show()
                              },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = lightBlue,
                        contentColor = lightBlue
                    )

                ) {

                    Text(text = "Login", color = Color.White)
                }
        }
    }

}


//Entrance Screen

@Composable
fun EntranceScreen(navController:NavController){
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
            .padding(start = 2.dp, top = 0.dp, end = 2.dp)
    ) {
        Image(
            painterResource(R.drawable.ic_sea_icon_round),
            contentDescription = "Test 1",
            modifier = Modifier
                .fillMaxWidth()
                .size(80.dp)
                .background(colorResource(id = R.color.white))
                .clickable(
                    enabled = true,
                    onClickLabel = "Clickable image",
                    onClick = {
                        Toast
                            .makeText(context, "Image clicked", Toast.LENGTH_SHORT)
                            .show()
                    }
                )

        )
    }
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 2.dp, top = 0.dp, end = 2.dp, bottom = 20.dp)
        ) {
                Box(){
                Image(
                    painterResource(R.drawable.employee),
                    contentDescription = "Test 1",
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(200.dp)
                        .background(colorResource(id = R.color.white))
                        .clip(RoundedCornerShape(100.dp))
                        .clickable(
                            enabled = true,
                            onClickLabel = "Clickable image",
                            onClick = {
                                Toast
                                    .makeText(
                                        context,
                                        "Employee Button clicked",
                                        Toast.LENGTH_SHORT
                                    )
                                    .show()
                            }
                        )
                )
                    Text(
                        text = "JOB SEEKERS",
                        fontSize = 15.sp,
                        color = Color.Black,
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .padding(top = 200.dp)
                    )
                }

        }
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 2.dp, top = 0.dp, end = 2.dp, bottom = 20.dp),

        ) {
            Box() {
                Image(
                    painterResource(R.drawable.employer),
                    contentDescription = "Test 1",
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(250.dp)
                        .background(colorResource(id = R.color.white))
                        .clip(RoundedCornerShape(100.dp))
                        .clickable(
                            enabled = true,
                            onClickLabel = "Clickable image",
                            onClick = {
                                Toast
                                    .makeText(
                                        context,
                                        "Employer Button clicked",
                                        Toast.LENGTH_SHORT
                                    )
                                    .show()
                            }
                        )
                )
                Text(
                    text = "EMPLOYER",
                    fontSize = 15.sp,
                    color = Color.Black,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(top = 250.dp)
                )
            }




            }

    }
}



@Composable
fun LandingScreen(navController:NavController){

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
            .padding(start = 2.dp, top = 0.dp, end = 2.dp)
    ) {
        Image(
            painterResource(R.drawable.ic_sea_icon_round),
            contentDescription = "Test 1",
            modifier = Modifier
                .fillMaxWidth()
                .size(80.dp)
                .background(colorResource(id = R.color.white))
                .clickable(
                    enabled = true,
                    onClickLabel = "Clickable image",
                    onClick = {
                        Toast
                            .makeText(context, "Image clicked", Toast.LENGTH_SHORT)
                            .show()
                    }
                )

        )
    }


        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 0.dp, top = 20.dp, end = 0.dp)
        ) {
            Image(
                painterResource(R.drawable.background),
                contentDescription = "Test 1",
                modifier = Modifier
                    .fillMaxWidth()
                    .size(300.dp)
                    .background(colorResource(id = R.color.white))
                    .clip(RoundedCornerShape(100.dp))
                    .clickable(
                        enabled = true,
                        onClickLabel = "Clickable image",
                        onClick = {
                            Toast
                                .makeText(context, "Image clicked", Toast.LENGTH_SHORT)
                                .show()
                        }
                    )

            )
        }

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 80.dp, top = 20.dp, end = 80.dp)
        ) {
            Box() {
                Image(
                    painterResource(R.drawable.house),
                    contentDescription = "Test 1",
                    modifier = Modifier
                        .size(60.dp)
                        .background(colorResource(id = R.color.white))
                       // .clip(RoundedCornerShape(50.dp))
                        .clickable(
                            enabled = true,
                            onClickLabel = "Clickable image",
                            onClick = {
                                Toast
                                    .makeText(context, "Image clicked", Toast.LENGTH_SHORT)
                                    .show()
                            }
                        )

                )
                Text(
                    text = "Maintenance",
                    fontSize = 10.sp,
                    color = Color.Red,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(top = 55.dp)
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
                                Toast
                                    .makeText(context, "Image clicked", Toast.LENGTH_SHORT)
                                    .show()
                            }
                        )
                )
                Text(
                    text = "Cleaner",
                    fontSize = 10.sp,
                    color = Color.Red,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(top = 55.dp)
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
                                Toast
                                    .makeText(context, "Image clicked", Toast.LENGTH_SHORT)
                                    .show()
                            }
                        )
                )
                Text(
                    text = "Kitchen",
                    fontSize = 10.sp,
                    color = Color.Red,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(top = 55.dp)
                )
            }

        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 80.dp, top = 10.dp, end = 80.dp)
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
                                Toast
                                    .makeText(context, "Image clicked", Toast.LENGTH_SHORT)
                                    .show()
                            }
                        )

                )
                Text(
                    text = "Pets",
                    fontSize = 10.sp,
                    color = Color.Red,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(top = 55.dp)
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
                                Toast
                                    .makeText(context, "Image clicked", Toast.LENGTH_SHORT)
                                    .show()
                            }
                        )
                )
                Text(
                    text = "Trash",
                    fontSize = 10.sp,
                    color = Color.Red,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(top = 55.dp)
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
                                Toast
                                    .makeText(context, "Image clicked", Toast.LENGTH_SHORT)
                                    .show()
                            }
                        )
                )
                Text(
                    text = "Garage",
                    fontSize = 10.sp,
                    color = Color.Red,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(top = 55.dp)
                )
            }
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 80.dp, top = 20.dp, end = 80.dp)
        ) {
            Button( modifier=Modifier
                .shadow(
                    elevation = 10.dp,
                    shape = CircleShape,
                    clip = true
                ),
                onClick = {Toast.makeText(context,"Image clicked",Toast.LENGTH_SHORT).show()},
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.DarkGray,
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

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SignUpScreen(navController:NavController, userInfoViewModel: UserInfoViewModel){
    val context = LocalContext.current
    val KeyboardController = LocalSoftwareKeyboardController.current

    //val userInfoViewModel = ViewModelProvider(context).get(UserInfoViewModel::class.java)

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
            .padding(top = 20.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 2.dp, top = 0.dp, end = 2.dp, 10.dp)
        ) {
            Image(
                painterResource(R.drawable.shamo),
                contentDescription = "Test 1",
                modifier = Modifier
                    .fillMaxWidth()
                    .size(100.dp)
                    .background(colorResource(id = R.color.white))
                    .clickable(
                        enabled = true,
                        onClickLabel = "Clickable image",
                        onClick = {
                            Toast
                                .makeText(context, "Image clicked", Toast.LENGTH_SHORT)
                                .show()
                        }
                    )

            )
        }
        Column(modifier = Modifier
            .height(20.dp)
            .fillMaxWidth()
            .background(color = Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            Text(text="InstaTask", color = graySurface, fontSize = 18.sp)
        }
        Spacer(modifier = Modifier.padding(5.dp))
        Column(modifier = Modifier
            .height(40.dp)
            .fillMaxWidth()
            .background(color = Color.White),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center) {
            Text(text="Disclaimer is a statement that denies something, especially responsibility", color = Color.Gray, fontSize = 15.sp, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Start)
        }
        Spacer(modifier = Modifier.padding(5.dp))
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
            Button(modifier= Modifier
                .fillMaxWidth()
                .padding(start = 40.dp, end = 40.dp)
                .shadow(
                    elevation = 10.dp,
                    shape = CircleShape,
                    clip = true
                ),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Black,
                    contentColor = Color.Black),

                onClick = {
                    if(fullName.value.isNullOrEmpty()||
                            email.value.isNullOrEmpty()||
                            password.value.isNullOrEmpty()||
                        address.value.isNullOrEmpty()||
                            zipCode.value.isNullOrEmpty()
                    ) {
                        Toast.makeText(context, "All field might be filed", Toast.LENGTH_LONG).show()
                    }else {
                        userInfoViewModel.insertNewUser(
                            UserRow(
                                user_full_name = fullName.value,
                                user_email_address = email.value,
                                user_passsword = password.value,
                                user_address = address.value,
                                user_zip_code = zipCode.value)
                            )
                        navController.navigate(NavScreens.Login.route)
                        {
                            popUpTo(NavScreens.Login.route)

                        }
                    }
                        //  Toast.makeText(context,"You re Signed Up....", Toast.LENGTH_LONG).show()

                    }

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
                                backgroundColor = lightBlue,
                                contentColor = lightBlue),
                            onClick = {

                                //Toast.makeText(context,"Login..", Toast.LENGTH_LONG).show()
                                navController.navigate(NavScreens.Login.route)
                                {
                                    popUpTo(NavScreens.Login.route)
                                }

                            },
                        ) {
                            Text(text="Login", color = Color.White, style = TextStyle(letterSpacing = TextUnit.Unspecified),
                                fontSize = TextUnit.Unspecified)
                        }
                    }
                }
        }
}


//SignIn Screen

@Composable
fun SignInScreen(navController:NavController, userInfoViewModel: UserInfoViewModel){
    val context = LocalContext.current

    val userList = userInfoViewModel.getAllUsers().observeAsState(arrayListOf())

   // val emailAddress = rememberSaveable{ mutableStateOf("")}
    //val password = rememberSaveable{ mutableStateOf("")}
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
                .padding(start = 2.dp, top = 0.dp, end = 2.dp, 10.dp)
        ) {
            Image(
                painterResource(R.drawable.shamo),
                contentDescription = "Test 1",
                modifier = Modifier
                    .fillMaxWidth()
                    .size(130.dp)
                    .padding(10.dp)
                    .background(colorResource(id = R.color.white))
                    .clickable(
                        enabled = true,
                        onClickLabel = "Clickable image",
                        onClick = {
                            Toast
                                .makeText(context, "Image clicked", Toast.LENGTH_SHORT)
                                .show()
                        }
                    )

            )
        }
        Column(modifier = Modifier
            .height(20.dp)
            .fillMaxWidth()
            .background(color = Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            Text(text="InstaTask", color = graySurface, fontSize = 18.sp)
        }
        Spacer(modifier = Modifier.padding(5.dp))
        Column(modifier = Modifier
            .height(40.dp)
            .fillMaxWidth()
            .background(color = Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            Text(text="Disclaimer is a statement that denies something, especially responsibility", color = Color.Gray, fontSize = 15.sp,modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Start )
        }
        Spacer(modifier = Modifier.padding(5.dp))
        val emailAddress = rememberSaveable{ mutableStateOf("") }
        val password = rememberSaveable{ mutableStateOf("") }
        //var emailAddress by rememberSaveable{mutableStateOf("")}
        //var Password by rememberSaveable{mutableStateOf("")}
        Spacer(modifier = Modifier.padding(15.dp, 0.dp,15.dp,15.dp))
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            OutlinedTextField(value = emailAddress.value, onValueChange = {emailAddress.value=it},
                label = {Text(text="Email Address", color = Color.Black, style = TextStyle(letterSpacing = TextUnit.Unspecified),
                    fontSize = TextUnit.Unspecified)},
                singleLine = true,
                modifier = Modifier.fillMaxWidth(0.8f))
            //Password
            OutlinedTextField(value = password.value, onValueChange = {password.value=it},
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
                modifier= Modifier
                    .fillMaxWidth()
                    .padding(start = 40.dp, end = 40.dp)
                    .shadow(
                        elevation = 10.dp,
                        shape = CircleShape,
                        clip = true
                    ),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Black,
                    contentColor = Color.Black),

                onClick = {
                    if( emailAddress.value.isNullOrEmpty() || password.value.isNullOrEmpty()){
                        Toast.makeText(context,"Please enter a valid Email or Password", Toast.LENGTH_LONG).show()
                    }else{
                        val listHolder = userList.value
                       // listHolder.forEach(userList ->
                        //if(emailAddress.value.equals(userList.value)))

                        navController.navigate(NavScreens.Gig.route)
                        {
                            popUpTo(NavScreens.Gig.route)
                        }
                        //Toast.makeText(context,"You re Signed In....", Toast.LENGTH_LONG).show()
                        //
                    }
                    },

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
                        backgroundColor = lightBlue,
                        contentColor = lightBlue),
                    onClick = {

                      //  Toast.makeText(context,"Signing Up..", Toast.LENGTH_LONG).show()
                        navController.navigate(NavScreens.Signup.route)
                        {
                            popUpTo(NavScreens.Signup.route)
                        }

                              },
                ) {
                    Text(text="Sign Up", color = Color.White, style = TextStyle(letterSpacing = TextUnit.Unspecified),
                        fontSize = TextUnit.Unspecified)
                }
            }
        }
    }

}

//Profile Screen

@Composable
fun ProfileScreen(navController:NavController){
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

@Composable
fun LogOutScreen(navController:NavController){
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

@Composable
fun SettingsScreen(navController:NavController){
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







