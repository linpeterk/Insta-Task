package com.example.instatask.ui.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider

import androidx.navigation.NavController

import com.example.instatask.ui.theme.InstaTaskTheme
import com.example.instatask.viewmodel.TheViewModel
import com.example.instatask.R
import com.example.instatask.ui.app.screens.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val theViewModel= ViewModelProvider(this).get(TheViewModel::class.java)
        setContent {
            init(theViewModel)
            InstaTaskTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {



                   DrawerNavGraph(theViewModel)
       //     test(theViewModel, 1)

                    //Adama'S task for now
                  //SignUpScreen()
                  //SignInScreen()
                    //EntranceScreen()
          //          LandingScreen()


                  //  TaskBoard(theViewModel, NavController(this))



//                    TaskBoard(theViewModel)

                 //  SkillBoard(theViewModel, NavController(this))




    //                WhenSkillClicked(navController = NavController(this), theViewModel, 2)

               //     WhenJobClicked(navController = NavController(this), theViewModel, 2)
//                    WhenSkillClicked(navcontroller = NavController(this))

                 //   SignInScreen()
                //    SignUpScreen()
                  //  TaskBoard()



                    //DrawerNavGraph(theViewModel)


                }
            }
//            ProfileScreen
//            ProfileScreen(
//                user=UserInfo("User Full Name","username@gmail.com","123 W ABC Ave",681123),
//                activity=Activity(arrayOf<String>("Activity_one","Activity_two"),arrayOf<String>("Activity_1","Activity_2","Activity_3","Activity_4"))
//            )

        }
    }
}
@Composable
fun greeting(){
    Text(text = "hello world")

}

@Composable
fun test(theViewModel:TheViewModel, index:Int) {
  //  var a = theViewModel.count

    var list= theViewModel.taskList[index]
    var listName = list.name
    var listHr= theViewModel.taskList[index].hourlyRate
    var a = theViewModel.count
    Column() {
        Button(onClick = {
            theViewModel.catlist(1)

        }) {
            Text(text = " GET API ")
        }
        Button(onClick = { theViewModel.up(1) }) {

        }

        Text(text = "int count $a")


        Text(text = "List is ${theViewModel.list[0]}")

    }



}
//Argument require for profile screen
data class UserInfo(val name:String,val email:String,val address:String,val zip:Int)
data class Activity(val oldActivity:Array<String>,val currentActivity:Array<String>)



