package com.example.instatask.ui.app.screens

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.KeyboardArrowLeft
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.instatask.R
import com.example.instatask.ui.Components.MakeGoogleMap
import com.example.instatask.ui.Components.TopBar
import com.example.instatask.ui.Components.utilities.CategoriesBar
import com.example.instatask.ui.Components.utilities.LazyScrollTaskBoard
import com.example.instatask.ui.app.Navigation.NavScreens
import com.example.instatask.ui.theme.GreenTask
import com.example.instatask.ui.theme.graySurface
import com.example.instatask.viewmodel.TheViewModel
import de.charlex.compose.BottomDrawerScaffold
import de.charlex.compose.BottomDrawerValue
import de.charlex.compose.rememberBottomDrawerScaffoldState
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TaskBoard(vModel: TheViewModel,
              navController: NavController
              ){

    var peekHeight = remember { mutableStateOf(200.dp) }
    val scope = rememberCoroutineScope()
    //de.charlex.compose.BottomDrawerState(initialValue = BottomDrawerValue.Expanded, drawerTopInset = 0))
    //val state = rememberBottomDrawerScaffoldState(1)
    val state = rememberBottomDrawerScaffoldState()

    var buttonText = remember{mutableStateOf("Show Map")}




   // state.bottomDrawerState.confirmStateChange(BottomDrawerValue.Expanded)

    BottomDrawerScaffold(
        //scaffoldState = rememberBottomDrawerState(5)
        scaffoldState = state  ,
        drawerModifier = Modifier.fillMaxSize(),
        drawerGesturesEnabled = true,
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = { Text(buttonText.value,
                            color= Color.White
                ) },
                backgroundColor= Color.Red,
                modifier = Modifier.wrapContentSize(),
                onClick = {
                    if (state.bottomDrawerState.isCollapsed) {

                        Log.d(TAG, "iscollapsed ${state.bottomDrawerState.isCollapsed}")
                        scope.launch {
                            state.bottomDrawerState.expand()

                        }
                        buttonText.value = "Show Map"
                    } else {
                        Log.d(TAG, "isnotcollapsed")
                        scope.launch {
                            state.bottomDrawerState.collapse()


                        }
                        buttonText.value = "Expand"
                    }


                }
            )
        },

        floatingActionButtonPosition= FabPosition.End,
        isFloatingActionButtonDocked = false,
        drawerPeekHeight = peekHeight.value,
        drawerBackgroundColor = Color.Transparent,  //Transparent drawer for custom Drawer shape
        drawerElevation = 0.dp,

        drawerContent = {

            //initalize values by fixing peekheight
            scope.launch {
                state.bottomDrawerState.expand()

            }
            
            Surface(                    //To add Padding to Drawer
                modifier = Modifier
                        .fillMaxSize()
                        .fillMaxHeight()
                        .fillMaxWidth()

                ,

            ) {
                // shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp),
                Surface(
                        color = Color.White
                    ) {
                    Column(modifier = Modifier) {
                        Box(
                            modifier = Modifier
                                    //  .weight(1f)
                                    .fillMaxWidth()
                                    //     .border(3.dp, Color.Red)
                                    .background(Color.White)

                        ) {
                           // CategoriesBar(vModel = vModel, vModel.categoriesTask, mode = 1, navController = navcontroller)
                            Column() {
                                Icon(imageVector = Icons.Outlined.ArrowBack, contentDescription = "Go back", modifier = Modifier.size(40.dp)

                                .clickable {
                                        navController.navigate(NavScreens.Gig.route){
                                            popUpTo(NavScreens.Gig.route)
                                        }
                                })

                            }
                                Column(modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(2.dp),
                                horizontalAlignment = Alignment.CenterHorizontally)
                                {
                                    Image(painter = painterResource(id = R.drawable.more), contentDescription = "Post Task",
                                            modifier = Modifier
                                                    .size(50.dp)
                                                    .background(color = GreenTask, shape = RoundedCornerShape(13.dp))
                                                    .clickable {
                                                        navController.navigate(NavScreens.PostTask.route){
                                                            popUpTo(NavScreens.PostTask.route)
                                                        }
                                                    })
                                    Text(text = "Post Task", color = graySurface, fontSize = 14.sp)
                                }

                        }

                        LazyScrollTaskBoard(vModel = vModel, navcontroller = navController, state, buttonText)

                    }


                }
                

            }
        }
    ){
        Box(modifier=Modifier
            .padding(bottom = 200.dp)) {
            MakeGoogleMap(vModel = vModel, mode = 1, navController = navController)
        //    TopBar()
        }
    }









}


