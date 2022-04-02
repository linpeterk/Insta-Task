package com.example.instatask.ui.app.screens

import android.util.Log
import android.view.RoundedCorner
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly
import androidx.navigation.NavController
import androidx.room.ColumnInfo
import com.example.instatask.R
import com.example.instatask.database.datamodel.Task
import com.example.instatask.ui.Components.googleHQ
import com.example.instatask.ui.app.Navigation.NavScreens
import com.example.instatask.ui.theme.graySurface
import com.example.instatask.viewmodel.TheViewModel
import kotlin.math.log

//Drop down menu

//val listoflistImages = listOf<List<Any>>()
/*
KuangCheng Lin (Peter)
Post tasks to add tasks to database, users fill out forms to create task object then insert

 */

/*  list of categories*/
//val listOfPets = listOf("petcategory", "workinprogress")
//val listOfGarden = listOf("farming")
//val listOfHome = listOf("renovation")
//val listOfTrade = listOf("trading")
//val listOfDelivery = listOf("deliveryman")
//val listOfLabor = listOf("workinprogress")

//val listOfTaskImages = listOf("listOfPets", listOfGarden, listOfHome, listOfTrade, listOfDelivery, listOfLabor)

val listOfTaskImages = listOf("petcategory", "farming", "renovation", "trading", "deliveryman", "workinprogress")

val listOfSubPets = listOf("pets", "workinprogress")
val listOfSubGarden = listOf("ic_sea_icon", "workinprogress")
val listOfSubHome = listOf("ic_sea_icon", "workinprogress")
val listOfSubTrade = listOf("ic_sea_icon", "workinprogress")
val listOfSubDelivery = listOf("ic_sea_icon", "workinprogress")
val listOfSubLabor = listOf("ic_sea_icon", "workinprogress")

val listOfSubTaskImages = listOf(listOfSubPets, listOfSubGarden, listOfSubHome, listOfSubTrade, listOfSubDelivery, listOfSubLabor)



@Composable
fun PostTask(vModel: TheViewModel, navController: NavController){
    var context = LocalContext.current

    var expandedFirst = remember{mutableStateOf(false)} //Status of the First dropdown menu
    var expandedSecond = remember{mutableStateOf(false)} //Status of the Second dropdown menu
    var selectedText = remember {mutableStateOf("Select Category")} //text on dropdown menu
    var selectedSubText = remember {mutableStateOf("Select SubCategory")} //text on subcategory dropdown menu


    var image = remember {mutableStateOf("workinprogress")} //image to be displayed

    //all the information needed to be stored for task
    var task_name by remember {mutableStateOf("")}
    var user_name by remember {mutableStateOf("")}
    var description by remember {mutableStateOf("")}
    var hourly_rate by remember {mutableStateOf("")}
    var date by remember {mutableStateOf("")}
    var address by remember {mutableStateOf("")}
    var catIndex = remember {mutableStateOf(0)}


    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        //Title
        Text(
            text = "Post Task",
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            textAlign = TextAlign.Center,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )

        Row(verticalAlignment = Alignment.CenterVertically) {

            //Image to be displayed
            Surface(
                modifier = Modifier
                    .size(90.dp)
                    .padding(5.dp)
            ) {
                Image(
                    painter = painterResource(id = vModel.getImageId(context, image.value)),
                    contentDescription = "Post image"
                )
            }

            //The First Dropdown Menu here
            Column() {
                //the first dropdownmenu category
                Box(
                    modifier = Modifier
                        .padding(10.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Box(
                        modifier = Modifier
                            .offset(x = -100.dp, y = 15.dp)
                    )
                    {
                        DropDownMenu(expandedFirst, image, selectedText, catIndex, listOfTaskImages)
                    }
                    Card(
                        elevation = 5.dp,
                        shape = RoundedCornerShape(15.dp)
                    ) {
                        Spacer(modifier = Modifier.padding(5.dp))
                        Text(
                            text = selectedText.value, modifier = Modifier
                                .width(150.dp)
                                .height(25.dp)
                                //   .border(1.dp, graySurface)
                                .clickable {
                                    expandedFirst.value = true
                                },
                            textAlign = TextAlign.Center
                        )
                    }

                }

                //The second dropdown category
                Box(
                    modifier = Modifier
                        .padding(10.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Box(
                        modifier = Modifier
                            .offset(x = -100.dp, y = 15.dp)
                    )
                    {
                        DropDownMenu(expandedSecond, image, selectedSubText, catIndex, listOfSubTaskImages[0])
                    }
                    Card(
                        elevation = 5.dp,
                        shape = RoundedCornerShape(15.dp)
                    ) {
                        Spacer(modifier = Modifier.padding(5.dp))
                        Text(
                            text = selectedSubText.value, modifier = Modifier
                                .width(150.dp)
                                .height(25.dp)
                                //   .border(1.dp, graySurface)
                                .clickable {
                                    expandedSecond.value = true
                                },
                            textAlign = TextAlign.Center
                        )
                    }

                }




            }
        }
        Column(modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
            ) {
            OutlinedTextField(
                value = task_name,
                onValueChange = { task_name = it },
                label = { Text(text = "Task Title") },
                shape = RoundedCornerShape(2.dp),
                modifier = Modifier.padding(0.4.dp)
            )
            Row(modifier = Modifier.padding(horizontal = 55.dp)) {
                OutlinedTextField(
                    value = user_name,
                    onValueChange = { user_name = it },
                    label = { Text(text = "Your Name") },
                    shape = RoundedCornerShape(2.dp),
                    modifier = Modifier
                        .padding(0.4.dp)
                        .weight(1f)
                )

                OutlinedTextField(
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    value = hourly_rate,
                    onValueChange = {
                        if(it.isDigitsOnly())
                        hourly_rate = it
                                    },
                    label = { Text(text = "$ Pay") },
                    shape = RoundedCornerShape(2.dp),
                    modifier = Modifier
                        .padding(0.4.dp)
                        .weight(1f)
                )


            }

            OutlinedTextField(
                value = date,
                onValueChange = { date = it },
                label = { Text(text = "Date/Time") },
                shape = RoundedCornerShape(2.dp),
                modifier = Modifier.padding(0.4.dp)
            )
            OutlinedTextField(
                value = address,
                onValueChange = { address = it },
                label = { Text(text = "Address") },
                shape = RoundedCornerShape(2.dp),
                modifier = Modifier.padding(0.4.dp)
            )
            OutlinedTextField(
                value = description,
                onValueChange = { description = it },
                label = { Text(text = "Description") },
                shape = RoundedCornerShape(2.dp),
                modifier = Modifier
                    .padding(0.4.dp)
                    .height(230.dp)
            )
            Spacer(modifier = Modifier.padding(5.dp))
            Button(onClick = {
                            if(catIndex.value !=0) { //Category have = been selected
                                val task: Task = Task(
                                    categories = catIndex.value,
                                    task_name = task_name,
                                    person_name = user_name,
                                    description = description,
                                    hourly_rate = hourly_rate.toInt(),
                                    datetime = date,
                                    imageId = image.value,
                                    address = address,
                                    lat = googleHQ.latitude,
                                    lng = googleHQ.longitude
                                    )
                                vModel.insertTask(task)

                                navController.navigate(NavScreens.TaskBoard.route){
                                //    vModel.fetchCategory(catIndex.value)
                                    popUpTo(NavScreens.TaskBoard.route)
                                    launchSingleTop = true
                                }
                            }
                            else{   //Category have NOT been selected, make toast and do nothing
                                  Toast.makeText(context, "Please fill out the fields",Toast.LENGTH_LONG).show()
                                    Log.d("NO TOAST", "NO TOAST")
                                 }
                           },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red)) {
                Text(text= "Post Task", color=Color.White)

            }

        }
    }
}



@Composable
fun DropDownMenu(expanded: MutableState<Boolean>, image: MutableState<String>, selectedText: MutableState<String>, catIndex:MutableState<Int>,  listOfImages:List<String>){

    DropdownMenu(
        expanded = expanded.value,
        onDismissRequest = { expanded.value = false },
        modifier = Modifier
        //    .fillMaxWidth()
        //  .border(2.dp, Color.Blue),

    ) {
        listOfImages.forEachIndexed() { index, title ->

            DropdownMenuItem(
                modifier = Modifier.height(30.dp),
                onClick = {
                    //   if (index != 0) {
                catIndex.value = index+1
                    image.value =  title
                    Log.d("ImageValue", "${image.value}")
                    selectedText.value = title
                    expanded.value = false
                    //    }
                })
            {
                Text(text = "${title}")
            }
        }
    }

}
