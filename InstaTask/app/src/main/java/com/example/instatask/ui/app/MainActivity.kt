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
//<<<<<<< Updated upstream
import androidx.navigation.NavController
//=======
import com.example.instatask.ui.app.screens.LandingScreen
import com.example.instatask.ui.app.screens.SignUpScreen
//>>>>>>> Stashed changes
import com.example.instatask.ui.app.screens.TaskBoard
import com.example.instatask.ui.app.screens.WhenJobClicked
import com.example.instatask.ui.theme.InstaTaskTheme
import com.example.instatask.viewmodel.TheViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val theViewModel= ViewModelProvider(this).get(TheViewModel::class.java)
        setContent {
            init()
            InstaTaskTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                  //  test(theViewModel)
                    //DrawerNavGraph(theViewModel)

//                    TaskBoard()

                    WhenJobClicked(navController = NavController(this))

                   // SignUpScreen()
                  //  TaskBoard()


                }
            }
        }
    }
}
@Composable
fun greeting(){
    Text(text = "hello world")
}

@Composable
fun test(theViewModel:TheViewModel) {
  //  var a = theViewModel.count
    var a = theViewModel.count
    Column() {
        Button(onClick = { a++ }) {

        }
        Button(onClick = { theViewModel.up(1) }) {

        }

        Text(text = "int count $a")
    }
}