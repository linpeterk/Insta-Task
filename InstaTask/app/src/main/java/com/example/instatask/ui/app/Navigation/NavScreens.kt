package com.example.instatask.ui.app.Navigation

import com.example.instatask.R

sealed class NavScreens(var route: String, var icon: Int, var title: String) {
    object TaskBoard : NavScreens("TaskBoard", R.drawable.farming, "Gigs")
    object WhenJob : NavScreens("WhenJob", R.drawable.toilet, "WhenJob")
    object SkillBoard : NavScreens("SkillBoard", R.drawable.deliveryman, "Professional")
    object Books : NavScreens("books", R.drawable.ic_sea_icon, "Books")
    object Profile : NavScreens("profile", R.drawable.profile, "Profile")

}

