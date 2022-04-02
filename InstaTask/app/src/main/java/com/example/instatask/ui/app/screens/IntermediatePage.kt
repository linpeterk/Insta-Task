package com.example.instatask.ui.app.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.instatask.ui.app.Navigation.BottomNavigationBar
import com.example.instatask.ui.app.Navigation.NavScreens
import com.example.instatask.ui.app.Navigation.Navigation
import com.example.instatask.viewmodel.TheViewModel

@Composable
fun Intermediate(navController: NavHostController, vModel:TheViewModel){

    Scaffold(
        modifier = Modifier,
        bottomBar = { BottomNavigationBar(navController) }
    ) {

        Box(modifier = Modifier.padding(bottom=56.dp)) {

            navController.navigate(NavScreens.Gig.route){
            launchSingleTop = true

           }
        }

    }
}

@Composable
public fun currentRoute(navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.arguments?.getString("route")
}