package com.example.instatask.ui.app.screens

import com.example.instatask.R

/* SCREENS
      LandingPage / Signup / Login / Entrance- Adama
      Job Board /  Skill board    -  Peter
      when job component clicked / when skill component clicked   - Carlos
      Profile screen / when job is accepted - Chinchu

    Functionality
      Navigation drawer -DONE
      Viewmodel - DONE

    Later
    Room Database
    DataStore
    Google Map
    Animation?

    Database instantiation
 */

sealed class Screens( val title:String, val route:String)
{
    object Test1:Screens("Test 1", "test1")
    object Test22:Screens("Test 22", "test22")
/*

    object Account:DrawerScreen("Account","account")
    object Help:DrawerScreen("Help","help")
*/
}
val drawerScreens= listOf(
    Screens.Test1,
    Screens.Test22
)

sealed class NavigationItem(var route:String, var icon:Int, var title:String){
    object Home: NavigationItem("home", R.drawable.home,"Home")
    object Profile: NavigationItem("profile", R.drawable.profile,"Profile")
    object Settings: NavigationItem("settings", R.drawable.settings,"Settings")
    object Logout: NavigationItem("logout", R.drawable.logout,"Logout")

}

