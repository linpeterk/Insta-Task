package com.example.instatask.ui.app

import android.util.Log
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.instatask.model.Categories
import com.example.instatask.viewmodel.TheViewModel
import kotlinx.coroutines.launch
import com.example.instatask.R
import com.example.instatask.database.datamodel.Task
import com.example.instatask.network.ResponseGig
import com.example.instatask.ui.app.screens.*

//Initialize values needed for screens to operate drawers in navigation. Created global variables instead of passing through each screen's parameters
lateinit var DrawersStatus:(Boolean)->Unit  //Used by topappbar in topbar, allow for opening or closing drawers without passing through each functions.
lateinit var drawerState: DrawerState
@Composable

fun init(vModel: TheViewModel){

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

    vModel.getCatlist(1)
    val temp = vModel.getGigLists()


    if(temp != null){
        yourInterest = temp.ur
        otherInterest = temp.other

    }
    Log.d("urInt", "$yourInterest")
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
                       // launchSingleTop = true

                    }
                }
                )

            }

        ) {

            NavHost(navController = navController, startDestination = Screens.TaskBoard.route)
            {

                composable(
                    route = Screens.WhenJob.route + "/{taskID}",
                    arguments = listOf(navArgument("taskID"){type = NavType.IntType})
                )
                {
                    val id: Int? = it.arguments?.getInt("taskID")

                    if(id!= null) {
                        WhenJobClicked(vModel = vmodel, navController = navController, taskId = id )
                    }
                }

                composable(
                    route = Screens.WhenSkill.route + "/{taskID}",
                    arguments = listOf(navArgument("taskID"){type = NavType.IntType})
                )
                {
                    val id: Int? = it.arguments?.getInt("taskID")
                    if(id!=null) {
                        WhenSkillClicked(
                            viewModel = vmodel,
                            navController = navController,
                            index = id
                        )
                    }
                }

                composable(Screens.TaskBoard.route)
                {
                    TaskBoard(vModel = vmodel, navController)
                }

                composable(Screens.PostScreen.route)
                {

                    PostTask(vModel = vmodel, navController= navController)
                }

                composable(Screens.SkillBoard.route)
                {

                    SkillBoard(vModel = vmodel, navController)
                }

                //3rd
                composable(Screens.WhenJob.route)
                {

                 //   WhenJobClicked(vmodel = vmodel, navController)
                }



            }
        }


    }



}


