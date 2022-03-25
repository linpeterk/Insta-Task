package com.example.instatask.ui.app.Components.utilities

import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.android.gms.maps.model.CameraPosition

@Composable
fun MakeScrollComponents(navController: NavController){

    // var scrollState:ScrollState =  rememberScrollState()
    // val context = LocalContext.current
    // var textFieldCount by remember { mutableStateOf (destObject.count()) }

    //val gradient = Brush.verticalGradient(0f to Color.Gray, 1000f to Color.White)
    Box(

        modifier = Modifier
            //  .background(Color.Black)
            .fillMaxWidth()
            .fillMaxHeight(1f)
            // .offset(y=300.dp)
            .verticalScroll(rememberScrollState())
            .background(Blue)

        ,
        // .offset(y = 500.dp)

    ) {

        Column (
            modifier = Modifier
                //.verticalScroll(rememberScrollState())
                .padding(horizontal = 10.dp)

        ) {
            var  dataBaseIter:Int

            if(Database.dataBase.count()>0){
                dataBaseIter=Database.dataBase.count()-1}else dataBaseIter = 0
            //      var entry = Database.dataBase.iterator().next()


            // cardCount.value // force update components

            //////////////////////MAKING ALL THE CARDS//////////////////////////////////////////
            repeat(
                times= Database.dataBase.count()
            ) {
                var currentRestRoom = Database.dataBase[Database.data.getKeyFromList(dataBaseIter)]
                Spacer(modifier = Modifier.padding(7.dp))
                //FIRST CARDS
                Card(
                    modifier = Modifier
                        .height(40.dp)
                        .clickable(onClick = {
//                            Log.d(TAG, "Name is ${lastLoc?.name}")
                            cameraPositionState!!.position =
                                CameraPosition.fromLatLngZoom(
                                    Database.data.getKeyFromList(Database.dataBase.count() - 1 - (it % 5)),
                                    15f
                                )
                            //destObject[destObjSize - it].loc
                        }),
                    RoundedCornerShape(15.dp),
                    elevation = 10.dp
                    // .fillMaxWidth()

                ) {
                    Text(
                        text=currentRestRoom?.name!!,
                        modifier = Modifier
                            .background(Color.White)
                            .padding(5.dp)
                            .fillMaxWidth()

                        ,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        textAlign = TextAlign.Center


                    )
                }
                //SECOND CARD
                Spacer(modifier = Modifier.padding(1.dp))
                Card(
                    modifier = Modifier
                        .height(133.dp)
                        //Toast.makeText(context, "TestA", Toast.LENGTH_LONG) toast syntax
                        .clickable(onClick = {
                            Log.d(TAG, "B4address = ${Database.dataBase.count() - 1 - (it % 5)}")

                            navController.navigate(Screen.Review.route + "/${Database.dataBase.count() - 1 - (it % 5)}")

                        }

                        ),

                    shape= RoundedCornerShape(15.dp),
                    elevation = 10.dp

                ) {

//////////////////////SECOND CARD COTENTS//////////////////////////////////////////
                    val rndsImage = (0..(currentRestRoom!!.image_URL.count()-1)).random()
                    val rndsComment = (0..(currentRestRoom!!.reviewArray.count()-1)).random()
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(2.dp)

                        ,
                        verticalAlignment = Alignment.CenterVertically,

                        ) {

                        Surface(
                            modifier = Modifier
                                /*.size(50.dp, 50.dp)*/
                                .weight(.6f)
                                .fillMaxHeight()
                            ,

                            /*.border(2.dp, Color.Blue),*/
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Row( modifier= Modifier.horizontalScroll(rememberScrollState())) {
                                repeat(currentRestRoom.image_URL.count()) {
                                    Box() {
                                        Image(
                                            modifier = Modifier
                                                //.size(50.dp, 50.dp),
                                                .fillMaxSize(),
                                            contentScale = ContentScale.Inside,
                                            painter = painterResource(id = currentRestRoom!!.image_URL[it]),
                                            //  painter = painterResource(id = restRoomObj?.userIMG_URL?.get(it)!!),
                                            contentDescription = "Urban Bathroom"
                                            /*contentScale = ContentScale.Fit*/
                                        )
                                    }
                                }
                            }


                        }
                        //  restRoomObj is the current component's location_restroom

                        Box(
                            modifier = Modifier
                                .weight(1.0f)
                                .fillMaxHeight()
                                .padding(4.dp),
                            contentAlignment = Alignment.Center
                            //.border(2.dp, Color.Red),
                        ) {

                            //   Text(text = restRoomObj!!.reviewArray[it].customerName,
                            Text(
                                text = "${currentRestRoom!!.reviewArray[rndsComment].customerName}:\n\n\"${currentRestRoom!!.reviewArray[rndsComment].comments}\"",
                                fontSize= 14.sp,
                                modifier = Modifier.fillMaxWidth()
                            )
                            //Spacer(modifier = Modifier.height(30.dp))
                            //  var str: String = dataBase[addressGlobal.loc]?.reviewArray!!.get(it)

                        }

                    }



////////////////////////////////////////////////////////////////////////////
                }

                if(dataBaseIter>0) {
                    --dataBaseIter
                    //  currentRestRoom= Database.dataBase[Database.data.getKeyFromList(dataBaseIter)]
                }
            }
        }
    }
}