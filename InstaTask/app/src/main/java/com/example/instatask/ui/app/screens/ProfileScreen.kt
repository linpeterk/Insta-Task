package com.example.instatask.ui.app

import android.widget.Toast
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instatask.R
import com.example.instatask.ui.theme.Purple200
import com.example.instatask.ui.theme.graySurface
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ProfileScreen(
    user:UserInfo,
    activity: Activity
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween

    ) {

        //TopAppBar

        Box() {

            var showMenu by remember { mutableStateOf(false) }
            val context = LocalContext.current

            TopAppBar(
                title = {
                    Text(
                        "My Profile ",
                        fontSize = 25.sp

                    )
                },
                backgroundColor = Color.White,

                actions = {


                    IconButton(onClick = { showMenu = !showMenu }) {
                        Icon(Icons.Default.MoreVert, "")
                    }

                    DropdownMenu(
                        expanded = showMenu,
                        onDismissRequest = { showMenu = false }
                    ) {

                        DropdownMenuItem(onClick = {
                            Toast.makeText(context, "Settings", Toast.LENGTH_SHORT).show()
                        }) {
                            Text(text = "Settings")
                        }

                        DropdownMenuItem(onClick = {
                            Toast.makeText(
                                context,
                                "Edit Profile",
                                Toast.LENGTH_SHORT
                            ).show()
                        }) {
                            Text(text = "Edit Profile")
                        }

                        DropdownMenuItem(onClick = {
                            Toast.makeText(context, "Logout", Toast.LENGTH_SHORT).show()
                        }) {
                            Text(text = "Logout")
                        }

                    }


                })
        }


        //Profile Image

        Box() {

            val profileImg = painterResource(id = R.drawable.head)
            Box(
                modifier = Modifier
                    .padding(10.dp),

                ) {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                        // .fillMaxSize()
                        .padding(10.dp)
//                //verticalArrangement = Arrangement.Center
                ) {

                    Image(
                        modifier = Modifier
                            .size(150.dp)
                            .clip(CircleShape)
                            .border(
                                width = 10.dp,
                                color = Color.Black,
                                shape = CircleShape
                            ),
                        painter = painterResource(id = R.drawable.head),
                        contentDescription = "Circular Image"
                    )
                }

            }


        }


        //user Info

        Box(
            modifier = Modifier
                .padding(30.dp),
            Alignment.Center,
        ) {
            Card(
                modifier = Modifier
                    .shadow(1.dp, RectangleShape)
                    .background(Color.White),
                shape = RoundedCornerShape(10.dp),
//            contentColor = Color.White,
                //elevation = 5.dp,
            ) {
                Column(
                    modifier = Modifier
                        .padding(50.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    var text by remember { mutableStateOf("") }
                    Row(modifier = Modifier.fillMaxWidth()) {

                        Spacer(modifier = Modifier.size(15.dp))
                        Text(
                            text = "user.name",
                            //fontSize = 20.dp,
                            // Alignment.Center,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Icon(imageVector = Icons.Filled.Email, contentDescription = "Email")
                        Spacer(modifier = Modifier.size(20.dp))
                        Text(text = "user.email")
                    }
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Icon(imageVector = Icons.Filled.Call, contentDescription = "Call")
                        Spacer(modifier = Modifier.size(20.dp))
                        Text(text = "user.phone")
                    }
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Icon(imageVector = Icons.Filled.LocationOn, contentDescription = "Location")
                        Spacer(modifier = Modifier.size(20.dp))
                        Text(text = "user.address")
                    }


                }
            }
        }


//current activities

        @ExperimentalMaterialApi
        var bgColor by remember { mutableStateOf(Purple200) }

        val color = animateColorAsState(
            targetValue = bgColor,
            animationSpec = tween(
                durationMillis = 2000
            )
        )

        val squareSize = 150.dp
        val swipeAbleState = rememberSwipeableState(initialValue = 0)
        val sizePx = with(LocalDensity.current) { squareSize.toPx() }
        val anchors = mapOf(0f to 0, sizePx to 1)



        Column(
            modifier = Modifier
                //.fillMaxSize()
                //.background(Color.White)
                .padding(10.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    // .fillMaxWidth()
                    .clip(RoundedCornerShape(15.dp))
                    .background(Color.Gray)
                    .swipeable(
                        state = swipeAbleState,
                        anchors = anchors,
                        thresholds = { _, _ ->
                            FractionalThreshold(0.3f)
                        },
                        orientation = Orientation.Horizontal
                    )
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    IconButton(
                        onClick = {
                            bgColor = Color.Green
                        },
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape)
                            .background(Color.LightGray)
                    ) {
                        Icon(
                            Icons.Filled.Edit,
                            contentDescription = "Edit",
                            tint = Color.Green
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    IconButton(
                        onClick = {
                            bgColor = Color.Red
                        },
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape)
                            .background(Color.LightGray)
                    ) {
                        Icon(
                            Icons.Filled.Delete,
                            contentDescription = "Delete",
                            tint = Color.Red
                        )
                    }
                }

                Box(
                    modifier = Modifier
                        .offset {
                            IntOffset(
                                swipeAbleState.offset.value.roundToInt(), 0
                            )
                        }
                        .clip(RoundedCornerShape(15.dp))
                        //.fillMaxWidth()
                        .height(200.dp)
                        //.fillMaxHeight()
                        .background(color.value)
                        .align(Alignment.CenterStart)

                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(20.dp),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_sea_icon),
                                contentDescription = "Circle Image",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(70.dp)
                                    .clip(CircleShape)
                            )

                            Spacer(modifier = Modifier.padding(10.dp))

                            Column {
                                Text(
                                    text = "Current Activities",
                                    color = Color.Black,
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold
                                )

                                Spacer(modifier = Modifier.padding(10.dp))

                                Text(
                                    text = "Lorem Ipsum is simply dummy text of the printing and type setting industry...",
                                    color = Color.Black,
                                    fontSize = 20.sp
                                )
                            }
                        }
                    }
                }
            }
        }
    }

}



























//


//        Box() {
//
//            val profileImg = painterResource(id = R.drawable.head)
//            Box(
//                modifier = Modifier
//                    .padding(16.dp)
//            ) {
//                Column(horizontalAlignment = Alignment.CenterHorizontally) {
//
//                    Image(
//                        modifier = Modifier
//                            .size(150.dp)
//                            .clip(CircleShape)
//                            .border(
//                                width = 10.dp,
//                                color = Color.White,
//                                shape = CircleShape
//                            ),
//                        painter = painterResource(id = R.drawable.head),
//                        contentDescription = "Circular Image"
//                    )
//                }
//
//            }
//
//            //-------------Box2------------------
//            Box() {
//
//                val profileImg = painterResource(id = com.example.instatask.R.drawable.head)
//                Box(
//                    modifier = Modifier
//                        .padding(16.dp)
//                ) {
//                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
//
//                        Image(
//                            modifier=Modifier
//                                .size(150.dp)
//                                .clip(CircleShape)
//                                .border(
//                                    width=10.dp,
//                                    color=Color.White,
//                                    shape=CircleShape
//                                ),
//                            painter=painterResource(id = com.example.instatask.R.drawable.head),
//                            contentDescription="Circular Image"
//                        )
//
//
//
//
//
////                 //   ImageCard(painter = profileImg,modifier = Modifier
////                        .width(250.dp)
////                        .height(180.dp))//
//
////                    Box(){
////                        val plusIcon=painterResource(id = com.example.instatask.R.drawable.plus)
////                        Row(verticalAlignment = Alignment.CenterVertically,horizontalArrangement = Arrangement.SpaceBetween) {
////
////                            Box(){
////                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
////                                    Button(onClick = { /*TODO*/ },shape = CircleShape,modifier = Modifier.size(50.dp)) {
////                                        Icon(painter = plusIcon, contentDescription = "Find Job")
////                                    }
////                                    Text(text = "Find Job")
////                                }
////                            }
////                            Box(){
////                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
////                                    Button(
////                                        onClick = { /*TODO*/ },
////                                        shape = CircleShape,
////                                        modifier = Modifier.size(50.dp)
////                                    ) {
////                                        Icon(painter = plusIcon, contentDescription = "Change Pic")
////                                    }
////                                    Text(text = "Change Pic")
////                                }
////                            }
////                            Box(){
////                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
////                                    Button(
////                                        onClick = { /*TODO*/ },
////                                        shape = CircleShape,
////                                        modifier = Modifier.size(50.dp)
////                                    ) {
////                                        Icon(painter = plusIcon, contentDescription = "Post Job")
////                                    }
////                                    Text(text = "Post Job")
////                                }
////                            }
////
////                        }
////
////                    }
//                    }
//                }
//            }
//            //-----------Box3----------------------
//            Box(
//                modifier = Modifier
//                    .padding(all = 25.dp),
//            ) {
//                Card(
//                    modifier = Modifier
//                        .shadow(1.dp,RectangleShape).background(Color.White),
//                    shape = RoundedCornerShape(10.dp),
//                    contentColor = Color.Black,
//                    elevation = 10.dp,
//                ) {
//                    Column(
//                        modifier = Modifier
//                            .padding(20.dp)
//                    ) {
////
//                        Text(text = "User Info:")
//                        Text(text = "Name: ${user.name}")
//                        Text(text = "Email: ${user.email}")
//                        Text(text = "Address: ${user.address}")
//                        Text(text = "Zip: ${user.zip}")
//                    }
//                }
//            }
//            //-------------Box4-------------------
//            Box(
//                modifier = Modifier
//                    .padding(all = 25.dp)
//            ) {
//                Card(
//                    modifier = Modifier
//                        .shadow(1.dp,RectangleShape).background(Color.White),
//                    shape = RoundedCornerShape(10.dp),
//                    contentColor = Color.Black,
//                    elevation = 10.dp,
//                ) {
//                    Column(
//                        modifier = Modifier
//                            .padding(20.dp)
//                    ) {
//                        Box() {
//                            Column() {
//
//                                Text(text = "Current Activities:")
//                                Text(text = " ")
//                                Text(text = "if accepted a job || if posted job in progress->")
//                                Text(text = "navigation when-job-accepted on component click")
//                                Text(text = " ")
//                                Text(text = "if none in progress, show picture of cat")
//                            }
//                        }
//                        Box() {
//                            Column() {
//                                Text(text = "Old Activities:")
//                                Text(text = " ")
//                                Text(text = "Job description: ")
//                                Text(text = "Completion date:")
//                                Text(text = "Money earned:")
////                    for(elm in activity.oldActivity){
////                        println(elm)
////                    }
//                            }
//                        }
//                    }
//                }
//            }
//            //-----------Box5------------------------------
//            Box() { Text(text = "Person Name: ${user.name}   Date:Today's Date") }
//        }
//
//}
//
////Image(
////    modifier=Modifier
////    .size(300.dp)
////    .clip(CircleShape)
////    .border(
////        width=10.dp,
////        color=Color.gray,
////        shape=CircularShape
////    ),
////    paniter=painterResource(id = com.example.instatask.R.drawable.head),
////    contentDescription="Circular Image"
////)
//
