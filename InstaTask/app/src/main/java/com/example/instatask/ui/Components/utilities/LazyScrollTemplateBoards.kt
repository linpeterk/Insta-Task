package com.example.instatask.ui.Components.utilities

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
import com.example.instatask.R
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

        items(vModel.currentList){ item->
            Spacer(modifier = Modifier.padding(3.dp))
            Card(
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp)



                //.border(2.dp, Color.Red)
                ,

                elevation = 7.dp

            ){
                Row(){
                    Image(painter = painterResource(id = vModel.getImageId(context = LocalContext.current,item.imageRes) ), contentDescription = null,
                        modifier = Modifier
                            // .border(2.dp, Color.Red)
                            .padding(40.dp)

                    )
                    Column(modifier = Modifier.padding(8.dp)
                        .verticalScroll(rememberScrollState())
                        .clickable(onClick = {
                        //    navController.navigate(Screen.Review.route + "/${Database.dataBase.count() - 1 - (it % 5)}")
                            if(mode == 1) {
                                navcontroller.navigate(Screens.WhenJob.route + "/${item.id - 1}")
                            }
                            else if(mode==2){
                        //        navcontroller.navigate(Screens.WhenSkill.route)
                            }
                            else {
                         //       navcontroller.navigate(Screens.WhenJob.route + "/${item.id - 1}")
                            }

                        })
                    ){

                        Text(text = "${item.name}: ")
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