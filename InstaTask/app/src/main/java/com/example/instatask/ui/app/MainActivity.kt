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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.instatask.R
import com.example.instatask.database.datamodel.Task
import com.example.instatask.network.AirplaneModeChangeReceiver
import com.example.instatask.network.Wifi
import com.example.instatask.ui.app.screens.*
import com.example.instatask.ui.theme.InstaTaskTheme
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
            //Do not run this
           // initDatabase(theViewModel)
            InstaTaskTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {


                 //   CustomerList(theViewModel)
//                  DrawerNavGraph(theViewModel)
         //  test(theViewModel)

                    //Adama'S task for now
                  //SignUpScreen()
                    //EntranceScreen()

          //          LandingScreen()

                //    TaskBoard(theViewModel, NavController(this))


//                    TaskBoard(theViewModel)

              //   SkillBoard(theViewModel, NavController(this))


                }
            }
//
//            ProfileScreen(
//                user=UserInfo("User Full Name","username@gmail.com","123 W ABC Ave",681123),
//                activity=Activity(arrayOf<String>("Activity_one","Activity_two"),arrayOf<String>("Activity_1","Activity_2","Activity_3","Activity_4"))
//            )
            JobAccepted(job = JobDetails("QwertyName",12,15,"Developer","Name_Qwerty","Test_Test","2022-03-01"))


        }
    }
}
@Composable
fun greeting(){
    Text(text = "hello world")

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

/*
                           taskId: Int = 0,
                               categories: Int = 0,
                            task_name: String? = null,
   person_name: String? = null,
   description: String? = null,
   hourly_rate: Int = 0,
   imageId: String? = null,
   address: String? = null
                            */

@Composable
fun CustomerList (vModel: TheViewModel){
   val taskList = vModel.currentTaskList.observeAsState(arrayListOf())
    var category = remember { mutableStateOf("")}
    //var taskList = vModel.taskList.observeAsState(arrayListOf())
    Scaffold(modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            ExtendedFloatingActionButton(
                backgroundColor = Color.Red,
                text = {
                    Text(text = "Customer", color = Color.White)
                },
                onClick = {
                    val name = UUID.randomUUID().toString()
                    vModel.insertCustomer(
                        Task(
                            categories = 1,
                            task_name = "Walk my dog",
                            person_name = "Peter",
                            description = "Got a  dog that needs walking",
                            hourly_rate = 15,
                            imageId = "ImageRES",
                            address = "Orange County CA"
                        ),


                        )

                    //       customerViewModel.deleteAll()
                }, icon = {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "image",
                        tint = Color.White
                    )
                })


        },

        content = {
            LazyColumn(content = {
                items(
                    taskList.value,
                    itemContent = {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp, vertical = 8.dp), content = {
                                val color =
                                    Color(
                                        Random.nextInt(256),
                                        Random.nextInt(256),
                                        Random.nextInt(256)
                                    )

                                Box(
                                    content = {
                                        Text(
                                            text = (it.task_name ?: "")[0].uppercase(),
                                            fontSize = 24.sp,
                                            color = color
                                        )
                                    }, modifier = Modifier
                                        .size(80.dp)
                                        .border(width = 1.2.dp, color = color, shape = CircleShape),
                                    contentAlignment = Alignment.Center
                                )
                                Spacer(modifier = Modifier.size(16.dp))
                                Column(
                                    modifier = Modifier.weight(2F),
                                    content = {
                                        Spacer(modifier = Modifier.size(8.dp))
                                        Text(
                                            text = it.task_name?.uppercase() ?: "",
                                            color = color,
                                            fontSize = 16.sp,
                                            maxLines = 1,
                                            overflow = TextOverflow.Ellipsis
                                        )
                                        Text(
                                            text = "Categories: ${it.categories}",
                                            color = Color.Black,
                                            fontSize = 14.6.sp
                                        )
                                        Text(
                                            text = "Desc: ${it.description ?: "null"}",
                                            color = Color.Gray,
                                            maxLines = 1,
                                            overflow = TextOverflow.Ellipsis
                                        )
                                        Text(
                                            text = "Desc: ${it.address ?: "null"}",
                                            color = Color.Gray,
                                            maxLines = 1,
                                            overflow = TextOverflow.Ellipsis
                                        )
                                    })
                                Spacer(modifier = Modifier.size(16.dp))
                                Icon(
                                    imageVector = Icons.Default.Delete,
                                    contentDescription = "image",
                                    tint = Color.Red, modifier = Modifier
                                        .size(30.dp)
                                        .clickable(onClick = {
                                            vModel.deleteTaskById(it.taskId)
                                        })
                                )
                            })
                    })
            })
        })
    Column()
    {
        Box(modifier = Modifier.size(40.dp)) {
            Button(onClick = {
                vModel.fetchCategory(category.value.toInt())


            }, modifier = Modifier.size(20.dp)) {

            }
        }
        TextField(value = category.value, onValueChange = { it -> category.value = it })
    }
}
//Argument require for profile screen and job accepted screen
data class UserInfo(val name:String,val email:String,val address:String,val zip:Int)
data class Activity(val oldActivity:Array<String>,val currentActivity:Array<String>)
data class JobDetails(val acceptorName:String,val hours:Int,val rate:Int,val desination:String,val creatorName:String,val description:String,val acceptedDate:String)

//TopBar stuff
@Composable
fun TopBar() {
    TopAppBar(
        title = { Text(text = stringResource(R.string.app_name), fontSize = 18.sp) },
        backgroundColor = colorResource(id = R.color.purple_700),
        contentColor = Color.White
    )
}

@Preview(showBackground = true)
@Composable
fun TopBarPreview() {
    TopBar()
}
