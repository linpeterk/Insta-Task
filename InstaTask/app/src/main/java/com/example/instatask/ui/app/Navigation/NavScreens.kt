package com.example.instatask.ui.app.Navigation

import com.example.instatask.R

sealed class NavScreens(var route: String, var icon: Int, var title: String) {
    object TaskBoard : NavScreens("TaskBoard", R.drawable.jobimageone, "Gigs")
    object SkillBoard : NavScreens("SkillBoard", R.drawable.professionalimagefive, "Pro")
    object WhenJob : NavScreens("WhenJob", R.drawable.toilet, "WhenJob")
    object Books : NavScreens("books", R.drawable.ic_sea_icon, "Earnings")
    object Profile : NavScreens("Profile", R.drawable.profileimagetwo, "Pro-file")
    object WhenSkill: NavScreens("WhenSkill", R.drawable.ic_sea_icon, "WhenSkill")
    object PostTask: NavScreens("PostTask", R.drawable.taskimagethree, "Post Gig")
    object Gig: NavScreens("Gig", R.drawable.gigimageone, "Gigs")

    object Landing: NavScreens("Landing", R.drawable.ic_sea_icon, "Landing")
    object Login: NavScreens("Login", R.drawable.ic_sea_icon, "Login")
    object Signup: NavScreens("Signup", R.drawable.ic_sea_icon, "Signup")

    object JobAccepted: NavScreens("JobAccepted", R.drawable.ic_sea_icon, "JobAccepted")
  //  object Interm: NavScreens("Interm", R.drawable.ic_sea_icon, "Interm")

}

