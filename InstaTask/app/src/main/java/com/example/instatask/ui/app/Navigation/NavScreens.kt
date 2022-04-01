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

}

