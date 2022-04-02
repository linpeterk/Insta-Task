package com.example.instatask.ui.app.Navigation

import com.example.instatask.R

sealed class NavScreens(var route: String, var icon: Int, var title: String) {
    object TaskBoard : NavScreens("TaskBoard", R.drawable.gigpic2, "Gigs")
    object SkillBoard : NavScreens("SkillBoard", R.drawable.deliveryman, "Professional")
    object WhenJob : NavScreens("WhenJob", R.drawable.toilet, "WhenJob")
    object Books : NavScreens("books", R.drawable.ic_sea_icon, "Earnings")
    object Profile : NavScreens("Profile", R.drawable.profile, "Profile")
    object WhenSkill: NavScreens("WhenSkill", R.drawable.ic_sea_icon, "WhenSkill")
    object PostTask: NavScreens("PostTask", R.drawable.gigpic, "PostTask")
    object Gig: NavScreens("Gig", R.drawable.gigpic, "Gig")

    object Landing: NavScreens("Landing", R.drawable.ic_sea_icon, "Landing")
    object Login: NavScreens("Login", R.drawable.ic_sea_icon, "Login")
    object Signup: NavScreens("Signup", R.drawable.ic_sea_icon, "Signup")
    object Interm: NavScreens("Interm", R.drawable.ic_sea_icon, "Interm")

}

