package com.example.instatask.ui.app.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.instatask.ui.app.Activity
import com.example.instatask.ui.app.UserInfo
import com.example.instatask.ui.app.screens.*
import com.example.instatask.viewmodel.TheViewModel
import com.google.accompanist.pager.ExperimentalPagerApi


@OptIn(ExperimentalPagerApi::class)
@Composable
fun Navigation(navController: NavHostController, vModel : TheViewModel) {
    NavHost(navController, startDestination = NavScreens.Landing.route) {

        //task board Gigs
        composable(NavScreens.TaskBoard.route) {
            TaskBoard(vModel = vModel, navController = navController)
        }
        composable(NavScreens.SkillBoard.route)
        {

            SkillBoard(vModel = vModel, navcontroller= navController)
        }

        //when job clicked
        composable(
            route = Screens.WhenJob.route + "/{taskID}",
            arguments = listOf(navArgument("taskID"){type = NavType.IntType})
        )
        {
            val id: Int? = it.arguments?.getInt("taskID")

            if(id!= null) {
                WhenJobClicked(vModel = vModel, navController = navController, taskId = id )
            }
        }

        composable(
            route = Screens.WhenSkill.route + "/{taskID}",
            arguments = listOf(navArgument("taskID"){type = NavType.IntType})
        )
        {
            val id: Int? = it.arguments?.getInt("taskID")

            if(id!= null) {
                WhenSkillClicked(viewModel = vModel, navController = navController, index = id )
            }
        }
        composable(NavScreens.Profile.route)
        {

            com.example.instatask.ui.app.ProfileScreen(
                user= UserInfo("User Full Name","username@gmail.com","123 W ABC Ave",681123),
                activity= Activity(arrayOf<String>("Activity_one","Activity_two"),arrayOf<String>("Activity_1","Activity_2","Activity_3","Activity_4"))
            )
        }
        composable(NavScreens.PostTask.route)
        {

            PostTask(vModel = vModel, navController)
        }

//        composable(NavScreens.Interm.route){
//            Intermediate(navController = navController, vModel = vModel)
//        }
        composable(NavScreens.Gig.route)
        {

            GigPage(vModel = vModel, navController = navController)
        }

        composable(NavScreens.Landing.route)
        {

            SliderScreen(navController = navController)
        }

        composable(NavScreens.Login.route)
        {

            SignInScreen(navController = navController)
        }

        composable(NavScreens.Signup.route)
        {

            SignUpScreen(navController = navController)
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