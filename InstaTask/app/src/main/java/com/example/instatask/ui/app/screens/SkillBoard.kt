package com.example.instatask.ui.app.screens

import android.content.ContentValues
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.instatask.ui.Components.MakeGoogleMap
import com.example.instatask.ui.Components.TopBar
import com.example.instatask.ui.Components.utilities.CategoriesBar
import com.example.instatask.ui.Components.utilities.LazyScrollSkillBoard
import com.example.instatask.viewmodel.TheViewModel
import de.charlex.compose.BottomDrawerScaffold
import de.charlex.compose.BottomDrawerScaffoldState
import de.charlex.compose.BottomDrawerValue
import de.charlex.compose.rememberBottomDrawerScaffoldState
import kotlinx.coroutines.launch

/*
        KuangCheng (Peter) Lin
        Display Skillboard

 */
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SkillBoard(
    vModel:TheViewModel,
    navcontroller: NavController

){

    var peekHeight = remember { mutableStateOf(200.dp) }
    val scope = rememberCoroutineScope()

    //
  //  val state = rememberBottomDrawerScaffoldState(bottomDrawerState =
   // de.charlex.compose.BottomDrawerState(initialValue = BottomDrawerValue.Expanded, drawerTopInset = 0))
    val state = rememberBottomDrawerScaffoldState()
    var buttonText = remember{ mutableStateOf("Show Map") }




   // state.bottomDrawerState.confirmStateChange(BottomDrawerValue.Collapsed)

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

                        Log.d(ContentValues.TAG, "iscollapsed ${state.bottomDrawerState.isCollapsed}")
                        scope.launch {
                            state.bottomDrawerState.expand()

                        }

                        buttonText.value = "Show Map"
                    } else {
                        Log.d(ContentValues.TAG, "isnotcollapsed")
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

            Surface(
                //To add Padding to Drawer
                modifier = Modifier
                    .fillMaxSize()
                    .fillMaxHeight()
                    .fillMaxWidth(),
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
                            CategoriesBar(vModel = vModel, vModel.categoriesSkill, 2, navController = navcontroller)

                        }

                        LazyScrollSkillBoard(vModel = vModel, navcontroller = navcontroller, state, buttonText)

                    }
                }
            }
        }

    ) {
        Box(modifier=Modifier
            .padding(bottom = 200.dp)
           // .border(3.dp, Color.Red)
        ) {
            MakeGoogleMap(vModel = vModel, mode = 2, navController = navcontroller)
            TopBar()
        }
    }
}
