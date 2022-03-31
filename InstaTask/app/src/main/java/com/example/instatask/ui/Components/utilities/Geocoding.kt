package com.example.instatask.ui.Components.utilities

import android.content.Context
import android.location.Address
import android.location.Geocoder
import android.widget.Toast
import java.io.IOException
import java.util.*

fun reverseGeocoder(context: Context, lat:Double, lng:Double):String{

    val mGeocoder = Geocoder(context, Locale.getDefault())
    var addressString= ""

    // Reverse-Geocoding starts
    try {
        val addressList: List<Address> = mGeocoder.getFromLocation(lat, lng, 1)

        // use your lat, long value here
        if (addressList != null && addressList.isNotEmpty()) {
            val address = addressList[0]

            return address.getAddressLine(0)


        }
    } catch (e: IOException) {
        Toast.makeText(context,"Unable connect to Geocoder ${e.message}", Toast.LENGTH_LONG).show()
    }

    // Finally, the address string is posted in the textView with LatLng.
    return addressString

}




/*

/*
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
                    vModel.insertTask(
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
=======
*/
 */