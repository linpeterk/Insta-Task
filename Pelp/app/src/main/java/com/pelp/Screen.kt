package com.pelp

sealed class Screen(val route:String){

    object Login:Screen(route="login_screen")
    object Start:Screen(route="start_screen")
    object Main:Screen(route="main_screen")
    object Profile:Screen(route="profile_screen")
    object Sort:Screen(route="sort_screen")
    object Review:Screen(route="review_screen")
    object Signup:Screen(route="signup_screen")
    object Emergency:Screen(route = "emergency_screen")
    object Search:Screen(route = "search_screen")
//    object ExpertReview:Screen(route = "expertReview_screen")


}
