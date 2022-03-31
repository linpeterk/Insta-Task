package com.example.instatask.ui.app.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.instatask.ui.app.screens.*
import com.example.instatask.viewmodel.TheViewModel

@Composable
fun Navigation(navController: NavHostController, vModel : TheViewModel) {
    NavHost(navController, startDestination = NavScreens.TaskBoard.route) {

        //task board
        composable(NavScreens.TaskBoard.route) {
            TaskBoard(vModel = vModel, navcontroller = navController)
        }

        //when job clicked
        composable(
            route = Screens.WhenJob.route + "/{taskID}",
            arguments = listOf(navArgument("taskID"){type = NavType.IntType})
        )
        {
            val id: Int? = it.arguments?.getInt("taskID")

            if(id!= null) {
                WhenJobClicked(vModel = vModel, navController = navController, index = id )
            }
        }




        /*
        composable(NavigationItem.Music.route) {
            MusicScreen()
        }
        composable(NavigationItem.Movies.route) {
            MovieScreen()
        }
        composable(NavigationItem.Books.route) {
            BookScreen()
        }
        composable(NavigationItem.Profile.route) {
            profileScreen()
        }


         */
    }
}