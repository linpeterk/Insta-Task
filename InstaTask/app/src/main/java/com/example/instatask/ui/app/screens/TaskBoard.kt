package com.example.instatask.ui.app.screens

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import com.example.instatask.ui.theme.graySurface
import com.example.instatask.viewmodel.TheViewModel
import de.charlex.compose.BottomDrawerScaffold
import de.charlex.compose.BottomDrawerValue
import de.charlex.compose.rememberBottomDrawerScaffoldState
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TaskBoard(vmodel: TheViewModel,
              navcontroller: NavController
              ){

    var peekHeight = remember { mutableStateOf(200.dp) }
    val scope = rememberCoroutineScope()

    val state = rememberBottomDrawerScaffoldState(1)

    var buttonText by remember{mutableStateOf("Show Map")}




    state.bottomDrawerState.confirmStateChange(BottomDrawerValue.Collapsed)

    BottomDrawerScaffold(
        //scaffoldState = rememberBottomDrawerState(5)
        scaffoldState = state  ,
        drawerModifier = Modifier.fillMaxSize(),
        drawerGesturesEnabled = true,
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = { Text(buttonText,
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

                        buttonText = "Show Map"
                    } else {
                        Log.d(TAG, "isnotcollapsed")
                        scope.launch {
                            state.bottomDrawerState.collapse()


                        }

                        buttonText = "Expand"

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
             //   shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp),

                //   elevation = 4.dp
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
                            CategoriesBar(vModel = vmodel, vmodel.categoriesTask, 1)

                        }

                        LazyScrollTaskBoard(vModel = vmodel, navcontroller = navcontroller)
//                        LazyColumn(
//                            modifier = Modifier
//                                .background(graySurface)
//                                .padding(5.dp)
//                                .fillMaxSize()
//
//                        ){
//
//                            items(vmodel.getFakeTasklist()){ item->
//                                Spacer(modifier = Modifier.padding(3.dp))
//                                Card(
//                                    shape = RoundedCornerShape(8.dp),
//                                    modifier = Modifier
//                                        .fillMaxWidth()
//                                        .height(140.dp)
//
//
//
//                                    //.border(2.dp, Color.Red)
//                                             ,
//
//                                    elevation = 7.dp
//
//                                ){
//                               Row(){
//                                   Image(painter = painterResource(id = item.imageRes ), contentDescription = null,
//                                   modifier = Modifier
//                                      // .border(2.dp, Color.Red)
//                                       .padding(40.dp)
//
//                                   )
//                                    Column(modifier = Modifier.padding(8.dp)
//                                        .verticalScroll(rememberScrollState())){
//
//                                        Text(text = "${item.name}: ")
//                                        Spacer(modifier = Modifier.padding(5.dp))
//                                        Text(text = "Review: \n\"${item.description} \"",
//                                            overflow = TextOverflow.Visible,
//                                            fontSize = 16.sp,
//                                            fontFamily = FontFamily.Cursive
//                                            )
//
//                                    }
//
//
//                               }
//
//                                }
//
//                            }
//
//                        }
                    }


                }
                

            }
        }
    ){
        Box() {
            MakeGoogleMap()
            TopBar()
        }
    }









}


