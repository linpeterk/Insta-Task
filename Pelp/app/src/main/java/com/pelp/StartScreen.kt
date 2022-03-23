package com.pelp

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.pelp.ui.theme.lightBlue

import org.intellij.lang.annotations.JdkConstants


@Composable
fun Start(
    navController: NavController
){

    Box(
        modifier = Modifier.fillMaxSize()
            .background(MaterialTheme.colors.background)

       // color = MaterialTheme.colors.background
    ) {
        Column(
            Modifier
                .background(Color.White)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
               // .border(1.dp, Color.Red)
        ) {
            Surface(
                modifier = Modifier.size(70.dp),
                shape = CircleShape
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_sea_icon_round),
                    contentDescription = "piece",
                    modifier = Modifier
                        .size(70.dp)
                        .clip(CircleShape)
                )
            }

            Text(text = "Welcome to Pelp",
                modifier = Modifier
                    .padding(4.dp)
                    .clickable { },
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.body2
            )


            Text(text = "We know just the place", modifier = Modifier,
            fontStyle = FontStyle.Italic)


        }

       /* Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {*/

            Column(
                modifier = Modifier.fillMaxSize()
                    .offset(y=210.dp)
            ) {
                Surface(modifier=Modifier.height(300.dp)) {

                    Box(modifier=Modifier){
                        Image(
                            painter = painterResource(id = R.drawable.pelplogo),
                            contentDescription = "Toilet House",
                            modifier = Modifier
                                //    .paddingFromBaseline(bottom = 150.dp)
                                .fillMaxWidth()
                                .clip(RectangleShape)
                                .scale(1F)
                        )
                    }

                }
                Column(modifier = Modifier.offset(y = 50.dp)) {
                    Text(
                        text = "This product can lead to biological hazards exposure which is known to the State of California to cause cancer",
                        modifier = Modifier
                            .padding(5.dp),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        style = MaterialTheme.typography.subtitle1,
                        textAlign = TextAlign.Center

                    )
                      Spacer(modifier = Modifier.padding(10.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                       // horizontalArrangement = Arrangement.Center y no work
                    ) {

                        Button(

                            onClick = { navController.navigate(route=Screen.Login.route)},
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red),
                            modifier = Modifier
                        ) {
                            Text(text = "Log in", modifier = Modifier.padding(5.dp), color = Color.White)
                        }
                        Button(
                            onClick = {
                                      navController.navigate(Screen.Signup.route)
                                      },
                            colors = ButtonDefaults.buttonColors(backgroundColor = lightBlue)
                        ) {
                            Text(text = "Sign up", modifier = Modifier.padding(5.dp), color = Color.White)
                        }
                    }
                }

            }


      //  }


    }
}



@Composable
fun Test(){

}

@Preview
@Composable
fun Previews()
{

}
