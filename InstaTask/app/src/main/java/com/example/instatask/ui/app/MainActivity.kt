package com.example.instatask.ui.app

import android.annotation.SuppressLint
import android.content.Intent
import android.content.IntentFilter
import android.net.wifi.WifiManager
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.instatask.R
import com.example.instatask.database.datamodel.Task
import com.example.instatask.database.datamodel.deleteDB
import com.example.instatask.database.datamodel.initDatabase
import com.example.instatask.network.AirplaneModeChangeReceiver
import com.example.instatask.network.Wifi
import com.example.instatask.ui.app.Navigation.BottomNavigationBar
import com.example.instatask.ui.app.Navigation.NavScreens
import com.example.instatask.ui.app.Navigation.Navigation
import com.example.instatask.ui.app.screens.*
import com.example.instatask.ui.theme.InstaTaskTheme
import com.example.instatask.ui.theme.graySurface
import com.example.instatask.viewmodel.TheViewModel
import java.util.*
import kotlin.random.Random

class MainActivity : ComponentActivity() {

    lateinit var airReceiver: AirplaneModeChangeReceiver

    lateinit var wifiReceiver2: Wifi


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        airReceiver = AirplaneModeChangeReceiver()
        wifiReceiver2 = Wifi()

        val theViewModel= ViewModelProvider(this).get(TheViewModel::class.java) // viewmodel

        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            registerReceiver(airReceiver,it)
        }


        IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION).also {
            registerReceiver(wifiReceiver2,it)
        }

        setContent {
            init(theViewModel)

         //   deleteDB(theViewModel) // Definitely don't run this
//initDatabase(theViewModel) //Do not run this, run only once to initiate database


            InstaTaskTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
//                    GigPage()
        //PostTask(theViewModel, navController = NavController(this))
                 //   CustomerList(theViewModel)

              //   DrawerNavGraph(theViewModel)

//                 DrawerNavGraph(theViewModel)

         //  test(theViewModel)

                    //Adama'S task for now
                     //SignUpScreen()
                    //EntranceScreen()

                  //LandingScreen()







                    //LandingScreen()


                //    TaskBoard(theViewModel, NavController(this))



                //MainScreen(theViewModel)

                MainScreen(theViewModel)


//                    TaskBoard(theViewModel)

              //   SkillBoard(theViewModel, NavController(this))
                }
            }
//            ProfileScreen(
//                user=UserInfo("User Full Name","username@gmail.com","123 W ABC Ave",681123),
//                activity=Activity(arrayOf<String>("Activity_one","Activity_two"),arrayOf<String>("Activity_1","Activity_2","Activity_3","Activity_4"))
//            )
     //       JobAccepted(job = JobDetails("QwertyName",12,15,"Developer","Name_Qwerty","Test_Test","2022-03-01"))

        }
    }
}

@SuppressLint("ResourceType")
@Composable
fun test(theViewModel:TheViewModel) {

var context = LocalContext.current
    var list= theViewModel.currentSkillList

  //  var listName = list.name
   // var listHr= theViewModel.currentSkillList[index].hourlyRate
   // var a = theViewModel.count
    Column() {
        Button(onClick = {
         //   theViewModel.catlist(1)
            theViewModel.getCatlist(1)

        }) {
            Text(text = " GET API ")
        }
        Button(onClick = {  }) {

        }
        Log.d("Image ID", "Image ID ${R.drawable.petcategory}")
       Log.d("TESTS", "MSG ${context.getResources().getIdentifier("petcategory", "drawable", context.getPackageName())}")
        //Image(painter = painterResource(id = 2130968639), contentDescription = "")

        Text(text = "List is ${theViewModel.currentSkillList}")

    }
}


//Argument require for profile screen

data class UserInfo(val name:String,val email:String,val address:String,val zip:Int)
data class Activity(val oldActivity:Array<String>,val currentActivity:Array<String>)
data class JobDetails(val acceptorName:String,val hours:Int,val rate:Int,val desination:String,val creatorName:String,val description:String,val acceptedDate:String)


//BOTTOM NAVIGATION BAR stuff
//NEW FILES ADDED - NavScreens.kt, ContentScreens.kt

@Composable
fun MainScreen(vModel : TheViewModel) {
    val navController = rememberNavController()
    Scaffold(
    modifier = Modifier,
       bottomBar = { BottomNavigationBar(navController) }
    ) {

        Box(modifier = Modifier.padding(bottom=56.dp)) {
            Navigation(navController = navController, vModel = vModel)
        }

    }
}



//END OF BOTTOM NAVIGATION BAR stuff

