package com.example.instatask.ui.app.screens

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.instatask.ui.app.Components.MakeGoogleMap
import com.example.instatask.ui.app.Components.TopBar
import com.google.android.gms.tasks.Task
import de.charlex.compose.BottomDrawerScaffold
import de.charlex.compose.BottomDrawerScaffoldState
import de.charlex.compose.BottomDrawerState
import de.charlex.compose.BottomDrawerValue
import de.charlex.compose.rememberBottomDrawerScaffoldState
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TaskBoard(){

    var peekHeight = remember { mutableStateOf(700.dp) }
    val scope = rememberCoroutineScope()

    val state = rememberBottomDrawerScaffoldState()
   // state.bottomDrawerState.confirmStateChange(BottomDrawerValue.Expanded)
    BottomDrawerScaffold(
        //scaffoldState = rememberBottomDrawerState(5)
        scaffoldState = state  ,
        drawerModifier = Modifier.fillMaxSize(),
        drawerGesturesEnabled = true,
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = { Text("View Map") },
                onClick = {


                    if (state.bottomDrawerState.isCollapsed) {

                        Log.d(TAG, "iscollapsed ${state.bottomDrawerState.isCollapsed}")
                        scope.launch {
                            state.bottomDrawerState.expand()
                        }
                    } else {
                        Log.d(TAG, "isnotcollapsed")
                        scope.launch {
                            state.bottomDrawerState.collapse()

                        }

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
            peekHeight.value = 150.dp
            scope.launch {
                state.bottomDrawerState.expand()

            }
            Surface(                    //To add Padding to Drawer
                modifier = Modifier
                ,
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
                            .weight(0.09f)

                        ){

                        }


                        Box(modifier = Modifier
                            .weight(0.8f)
                            .background(MaterialTheme.colors.primaryVariant)
                        ){

                        }
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