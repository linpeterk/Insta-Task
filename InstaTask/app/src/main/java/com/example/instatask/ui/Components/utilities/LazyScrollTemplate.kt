package com.example.instatask.ui.Components.utilities

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instatask.ui.theme.graySurface
import com.example.instatask.viewmodel.TheViewModel

@Composable
fun LazyScrollTemplate(viewModel: TheViewModel){


    LazyColumn(
        modifier = Modifier
            .background(graySurface)
            .padding(5.dp)
            .fillMaxSize()

    ){

        items(viewModel.getFakeTasklist()){ item->
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
                    Image(painter = painterResource(id = item.imageRes ), contentDescription = null,
                        modifier = Modifier
                            // .border(2.dp, Color.Red)
                            .padding(40.dp)

                    )
                    Column(modifier = Modifier.padding(8.dp)
                        .verticalScroll(rememberScrollState())){

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