package com.example.instatask.ui.Components.utilities

import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.instatask.ui.app.screens.Screens
import com.example.instatask.ui.theme.graySurface
import com.example.instatask.viewmodel.TheViewModel

@Composable
fun LazyScrollTemplateBoards(vModel: TheViewModel, navcontroller:NavController, mode:Int){
                                                        //MODE 1 = when job click
                                                        //MODE 2 = when skill click

    LazyColumn(
        modifier = Modifier
            .background(graySurface)
            .padding(5.dp)
            .fillMaxSize()

    ){

        items(vModel.currentSkillList){ item->
            Spacer(modifier = Modifier.padding(3.dp))
            Card(
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)



                //.border(2.dp, Color.Red)
                ,

                elevation = 7.dp

            ){
                Row(){
                    Log.d("ImageRES", item.imageRes)
                    Log.d("ImageRES", item.name)
                    Image(painter = painterResource(id = vModel.getImageId(context = LocalContext.current,item.imageRes) ), contentDescription = null,
                        modifier = Modifier
                         //    .border(2.dp, Color.Red)
                            .padding(20.dp)
                            .size(70.dp)

                    )
                    Column(modifier = Modifier.padding(8.dp)
                        .verticalScroll(rememberScrollState())
                        .clickable(onClick = {
                        //    navController.navigate(Screen.Review.route + "/${Database.dataBase.count() - 1 - (it % 5)}")
                            if(mode == 1) {
                                navcontroller.navigate(Screens.WhenJob.route + "/${item.id - 1}")
                            }
                            else if(mode==2){

                                vModel.getReviews(2, 2)
                               

                                navcontroller.navigate(Screens.WhenSkill.route + "/${item.id - 1}")


                            }
                            else {
                         //       navcontroller.navigate(Screens.WhenJob.route + "/${item.id - 1}")
                            }

                        })
                    ){

                        Text(text = "${item.name}", fontSize = 16.sp, modifier = Modifier.fillMaxWidth())
                        Text(text = "Hourly $${item.hourlyRate}", fontSize = 12.sp,  modifier = Modifier.fillMaxWidth())
                        Text(text = "Areas served: ${item.workLocation}, CA", fontSize = 12.sp,  modifier = Modifier.fillMaxWidth())
                        Text(text = "Hours: ${item.available}", fontSize = 12.sp,  modifier = Modifier.fillMaxWidth())
                        Spacer(modifier = Modifier.padding(5.dp))

                        Text(text = "Review: \n\"${item.description} \"",
                            overflow = TextOverflow.Visible,
                            fontSize = 16.sp,
                            fontFamily = FontFamily.Cursive
                        )

                    }


                }

            }

        }

    }
}