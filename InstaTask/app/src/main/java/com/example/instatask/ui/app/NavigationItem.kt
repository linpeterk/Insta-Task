package com.example.instatask.ui.app

import com.example.instatask.R

sealed class NavigationItem(var route: String, var icon: Int, var title: String) {
    object Home : NavigationItem("home", R.drawable.home, "Home")
    object Music : NavigationItem("music", R.drawable.toilet, "Music")
    object Movies : NavigationItem("movies", R.drawable.deliveryman, "Movies")
    object Books : NavigationItem("books", R.drawable.ic_sea_icon, "Books")
    object Profile : NavigationItem("profile", R.drawable.profile, "Profile")

}

