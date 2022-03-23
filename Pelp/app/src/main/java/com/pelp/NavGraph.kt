package com.pelp

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun SetupNavGraph(
    navController:NavHostController
){

    NavHost(
        navController = navController,
        startDestination = Screen.Start.route
         ){
        composable(
            route = Screen.Start.route
        ){
            Start(navController = navController)
        }

        composable(
            route = Screen.Signup.route
        ){
            SignupScreen(navController = navController)
        }

        composable(
            route = Screen.Login.route,


        ){
            LoginScreen(navController = navController )
        }

        composable(
            route = Screen.Main.route
        ){
            MainScreen(navController = navController)
        }

        composable(
            route = Screen.Profile.route
        ) {
            ProfileScreen(navController = navController)
        }
        composable( //EmergencyScreen.kt
            route = Screen.Emergency.route
        ) {
            emergency(navController = navController)
        }
        composable( //SearchScreen
            route = Screen.Search.route
        ) {
            addAddress(navController = navController)
        }
        composable( //ExpertReviewScreen.kt
            route = Screen.Review.route
        ) {
            ExpertReview(navController = navController)
        }
        composable(
            route = Screen.Sort.route
        ){
            SortScreen(navController = navController)

        }

        composable(
            route = Screen.Review.route+"/{addressLoc}", // argument must be separated by "/{}"
            arguments = listOf(navArgument("addressLoc"){type = NavType.IntType })  //navigate pass with argument
        ){
            val str: Int? = it.arguments?.getInt("addressLoc")

        if(str!= null)
            SquareImage (navController = navController, str!!)

        }
    }
}