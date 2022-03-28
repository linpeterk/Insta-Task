package com.example.instatask.ui.app.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.instatask.R
import com.example.instatask.model.jobCreators
import com.example.instatask.ui.Components.AllReviews
import com.example.instatask.ui.Components.MakeGoogleMap
import com.example.instatask.ui.Components.TopBar
import com.example.instatask.ui.theme.graySurface
import com.example.instatask.viewmodel.TheViewModel
import de.charlex.compose.BottomDrawerScaffold

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun WhenSkillClicked(navController: NavController, viewModel: TheViewModel, index: Int) {
    var context= LocalContext.current

    val composableScope = rememberCoroutineScope()

    var peekHeight = remember { mutableStateOf(250.dp) }
    val taskInfo = viewModel.getTasklist()[index]


            Surface(                    //To add Padding to Drawer
                modifier = Modifier,
                shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
                //   elevation = 4.dp

            ) {
                Box(modifier = Modifier
                    .fillMaxSize()
                    .fillMaxHeight()
                    .fillMaxWidth()
                ){
                    Column() {

                        Box(modifier = Modifier
                            .weight(0.4f)
                            .background(graySurface)
                        ){
//                                MakeScrollComponents(navController)
                            Card(

                                modifier = Modifier
                                    .padding(10.dp)
                                    .fillMaxWidth()
                                    .wrapContentHeight(),
//                                    clickable { cardViewCallBack(context,name+description) }

                                shape = MaterialTheme.shapes.medium,
                                elevation = 5.dp,
                                backgroundColor = MaterialTheme.colors.surface
                            ) {

                                Row (
                                    verticalAlignment = Alignment.CenterVertically

                                ){

                                    Image(painter = painterResource(taskInfo.imageRes), //WORKER CARD
                                        contentDescription =null,
                                        modifier= Modifier
                                            .size(130.dp)
                                            .padding(8.dp),
                                        contentScale = ContentScale.Fit
                                    )
                                    Column(Modifier.padding(8.dp)) {

                                        Text(text = "Name is ${taskInfo.name}",
                                            style= MaterialTheme.typography.h6,
                                            color= MaterialTheme.colors.onSurface,
                                            modifier= Modifier.padding(start=30.dp)
                                        )
                                        Text(text = "Description is ${taskInfo.description}",
                                            style= MaterialTheme.typography.body1,
                                            color= MaterialTheme.colors.onSurface,
                                            modifier= Modifier.padding(start=15.dp)
                                        )

                                    }

                                }

                            }
                        }
                        Row(modifier = Modifier //
                            .fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center

                        ){

//                              MenuTab(navController)
                            Button(                                     // ACCEPT OR REPORT BUTTON

                                onClick = { /*navController.navigate(route=Screen.Login.route)*/},
                                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red),
                                modifier = Modifier
                            ) {
                                Text(text = "Accept", modifier = Modifier.padding(5.dp), color = Color.White)
                            }
                            Button(
                                onClick = {/*
                                        navController.navigate(Screen.Signup.route)
                                    */},
                                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
                            ) {
                                Text(text = "Report", modifier = Modifier.padding(5.dp), color = Color.White)
                            }
                        }


                        Box(modifier = Modifier                                     // REVIEWS OF WORKER
                            .weight(0.8f)
                            .background(MaterialTheme.colors.primaryVariant)
                        ){
//                                MakeScrollComponents(navController)
                            AllReviews(jobCreators)
                        }
                    }

                    TopBar()

                }

            }

        }




