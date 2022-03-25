package com.example.instatask.ui.app

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.instatask.ui.app.screens.Screens
import com.example.instatask.ui.app.screens.greeting1
import com.example.instatask.ui.app.screens.greeting2
import com.example.instatask.viewmodel.TheViewModel
import kotlinx.coroutines.launch


lateinit var DrawersStatus:(Boolean)->Unit
lateinit var drawerState: DrawerState
@Composable
fun init(){

     drawerState = rememberDrawerState(DrawerValue.Closed)

    // REPLACE THIS WITH VIEWMODEL   !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    var scope = rememberCoroutineScope()

    DrawersStatus = { DrawState ->
        scope.launch {

            if(DrawState){
            drawerState.open()
            }
            else {
                drawerState.close()
            }
        }
    }
}
@Composable
fun DrawerNavGraph(vmodel: TheViewModel) {

    val navController = rememberNavController()

    Surface(
        color = MaterialTheme.colors.background

    ) {
        //create drawer state open or close

        //Create component to hold the drawer
        ModalDrawer(
            drawerState = drawerState,
            gesturesEnabled = drawerState.isOpen, //if drawerstate is open
            drawerContent = {

                //draw the stuff inside drawer
                //close drawer when destination is clicked, then go destination
                LeftDrawer(onDestinationClicked = { route ->
                    DrawersStatus(false)
                    /*
                    navController.navigate(route=Screen.Profile.route){
                        popUpTo(Screen.Profile.route){
                            inclusive=true
                        }
                     */

                    //go destinations
                    navController.navigate(route) {
                        popUpTo(route)
                        launchSingleTop = true

                    }
                }
                )

            }

        ) {

            NavHost(navController = navController, startDestination = Screens.Test1.route)
            {

                composable(Screens.Test1.route)
                {


                    greeting1()
                }

                //2nd

                composable(Screens.Test22.route)
                {

                    greeting2(openDrawer =
                        DrawersStatus
                    )
                }

                //3rd


            }
        }


    }



}


