package com.example.instatask.ui.app.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.materialIcon
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.instatask.model.interests
import com.example.instatask.ui.theme.graySurface
import com.example.instatask.ui.theme.lightBlue
import com.example.instatask.R
import com.example.instatask.network.ResponseGig
import com.example.instatask.network.ResponseGigType
import com.example.instatask.ui.app.Navigation.NavScreens
import com.example.instatask.viewmodel.TheViewModel
import java.security.AccessController.getContext

/*
var yourInterest = listOf(
    interests(title = "Pets", "$24/hr avg.",  R.drawable.petcategory),
    interests(title = "Gardening", "$27/hr avg.",  R.drawable.farming),
    interests(title = "Home Repairs", "$25/hr avg.",  R.drawable.renovation)
)

val otherInterest = listOf(
    interests(title = "Trades", "$21/hr avg.",  R.drawable.trading),
    interests(title = "Delivery", "$19/hr avg.",  R.drawable.deliveryman),
    interests(title = "Grunt Work", "$30/hr avg.",  R.drawable.workinprogress)
    )
    */
  var yourInterest:List<ResponseGigType>? = null
 var otherInterest:List<ResponseGigType>? = null

var baseInterests:List<ResponseGigType> = listOf(ResponseGigType(imageRes = "workinprogress"), ResponseGigType(imageRes = "workinprogress"), ResponseGigType(imageRes = "workinprogress"))


@Composable
fun GigPage(navController: NavController, vModel:TheViewModel){

    vModel.getGigLists()
    LazyColumn(modifier = Modifier.fillMaxSize()){
        item(){
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(10.dp)
                .background(lightBlue)
            ,contentAlignment = Alignment.Center
            ){
            Text(text="Start your gigs Today", modifier = Modifier,
                textAlign = TextAlign.Center,
                color= graySurface,
                fontSize = 24.sp,
                fontFamily = FontFamily.Serif
                        )}

        }
        //Your interests section
        item(){
            Text(text = "Your Interests",
               modifier = Modifier.padding(5.dp),
            fontSize = 20.sp,
                color = graySurface,
                fontWeight = FontWeight.Normal,
                fontFamily = FontFamily.Serif
                )
        }
        itemsIndexed(yourInterest?: baseInterests){ index,item->
            Card(modifier = Modifier
                .fillMaxWidth()
                .height(130.dp)
                .padding(horizontal = 30.dp, vertical = 15.dp)
               // .border(2.dp, Color.Red)
                ,shape= RoundedCornerShape(8.dp),
                elevation = 5.dp
            ) {
               makeItems(item, navController = navController, vModel = vModel, index = index+1) //make the item cards
            }
        }
        //Other Interests
        item(){
            Text(text = "Other Positions",
                modifier = Modifier.padding(5.dp),
                fontSize = 20.sp,
                color = graySurface,
                fontWeight = FontWeight.Normal,
                fontFamily = FontFamily.Serif
            )
        }
        itemsIndexed(otherInterest ?: baseInterests){index, item->
            Card(modifier = Modifier
                .fillMaxWidth()
                .height(130.dp)
                .padding(horizontal = 30.dp, vertical = 15.dp)
                // .border(2.dp, Color.Red)
                ,shape= RoundedCornerShape(8.dp),
                elevation = 5.dp
            ) {
                makeItems(item,navController = navController, vModel = vModel, index=index+1+ (yourInterest?.count()
                    ?: baseInterests.count())) //make the item cards
            }
        }
    }
}

@Composable
fun makeItems(item:ResponseGigType, navController: NavController, vModel: TheViewModel, index:Int)
{
    val context = LocalContext.current
    Row() {
        //Make pictures
        Surface(            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
            .weight(.5f),
        ){
            Image(painter = painterResource(id = vModel.getImageId(context = context, item.imageRes)), contentDescription = "icon image" )
        }
        //make contents
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
            .weight(1f)
            .clickable {

                        vModel.fetchCategory(index)
                       navController.navigate(NavScreens.TaskBoard.route){
                           popUpTo(NavScreens.TaskBoard.route)
                       }

            },
            contentAlignment = Alignment.CenterStart
        ){
            Column(){
                Text(item.name, fontWeight = FontWeight.Normal, fontSize = 18.sp)
                Text(item.money)
            }
        }

        //make keyboard arrow right

        Box(modifier = Modifier
            .fillMaxSize()
            .weight(0.2f)
            .clickable {

                vModel.fetchCategory(index)
                navController.navigate(NavScreens.TaskBoard.route){
                    popUpTo(NavScreens.TaskBoard.route)
                }

            },
            contentAlignment = Alignment.TopEnd
        ){
            Icon(imageVector = Icons.Outlined.KeyboardArrowRight, contentDescription = "arrow forward")
        }
    }
}