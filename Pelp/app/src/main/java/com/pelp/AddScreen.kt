package com.pelp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@Preview
@Composable
fun previewAddAddress(){
    addAddress(navController = rememberNavController(),/*addressLoc =Int*/)
}

@Composable
fun addAddress(navController: NavController/*,addressLock:Int*/) {
//    var restRoomObj = Database.dataBase[Database.data.getKeyFromList(addressLock)]
//    var reviewCount by rememberSaveable { mutableStateOf(restRoomObj!!.reviewArray.count())}

    Surface(modifier=Modifier.fillMaxSize()) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
            .padding(5.dp)
            .offset(y = 50.dp)) {

            val textState = remember { mutableStateOf(TextFieldValue()) }
            val textState1 = remember { mutableStateOf(TextFieldValue()) }
            var bName by rememberSaveable { mutableStateOf("") }
            var bAddress by rememberSaveable { mutableStateOf("") }
            var review by rememberSaveable { mutableStateOf("") }
            var enable by remember { mutableStateOf(true) }

            Surface(
                modifier = Modifier.size(100.dp),
                shape = CircleShape
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_sea_icon_round),
                    contentDescription = "Back To Home",
                    modifier = Modifier.fillMaxSize()



                )
            }

            Surface(
                /*color=MaterialTheme.colors.primaryVariant,*/
                shape = RoundedCornerShape(3.dp)
            ) {
                OutlinedTextField(
                    value = bName,
                    onValueChange = {bName = it },
                    shape = RoundedCornerShape(3.dp),
                    label = { Text(text = "Business Name") },
                    modifier = Modifier.width(350.dp)

                )
            }
            Surface(
                shape = RoundedCornerShape(3.dp)
            ) {
                OutlinedTextField(
                    value = bAddress,
                    onValueChange = { bAddress = it },
                    shape = RoundedCornerShape(3.dp),
                    label = { Text(text = "Business Address") },
                    modifier = Modifier.width(350.dp)
                )
            }
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start
            ) {

                Surface(

                    shape = RoundedCornerShape(3.dp),
                    modifier = Modifier.padding(3.dp)

                ) {
                    OutlinedTextField(
                        value = review,
                        onValueChange = { review = it },
                        shape = RoundedCornerShape(3.dp),
                        label = { Text(text = "How's the Experience?") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(120.dp)

                    )

                }


                Box(
                    contentAlignment = Alignment.CenterEnd,
                    modifier = Modifier.fillMaxWidth(),

                    ) {
                    Button(
                        onClick = {
                            Database.data.addBuisness(bName,bAddress,review)

                            //Database.data.addReviewPersonRest(who, Database.data.getKeyFromList(addressLock),review, Database.userBase[who]!!.imageId)
                            review = "Business Added!"
                            //reviewCount = restRoomObj!!.reviewArray.count()
                            enable = false

                        },
                        enabled = enable,
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red)
                    ) {
                        Text(text = "Submit")
                    }

                }

            }

        }

    }


}

// MakeGoogleMap(true)
// MenuTab()