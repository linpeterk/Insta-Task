

package com.pelp


import android.content.Context
import android.location.Address
import android.location.Geocoder
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
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
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.maps.android.compose.*
import com.pelp.model.data.Location_Restroom
import com.pelp.model.data.*
import com.pelp.ui.theme.Blue300
import com.pelp.ui.theme.lightBlue
import de.charlex.compose.BottomDrawerScaffold
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import java.io.IOException
import java.util.*
/*

var cameraPositionState:CameraPositionState?=null
var addressGlobal: Location_Restroom = Location_Restroom(loc=LatLng(100.0, 100.0))
private const val TAG = "MapSampleActivity"

//val destList = listOf(caliMuseum, toyDistrict, brew,dodgerS,church)  //List of locations name
//val destObject = mutableListOf<Location_Restroom>() //List of location object
//val strName = listOf("Japanese American National Museum " , "Toy District", "Brewery", "Dodger Stadium","Our Lady Queen of Angels" )


//var cardCount:MutableState<Int> = mutableStateOf(dataBase.count())





@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TestScreen(navController: NavController){

    // cardCount =  remember {  mutableStateOf(dataBase.count()) }
    val composableScope = rememberCoroutineScope()
    Log.d(Examples.TAG,"Hello from Main")
    var peekHeight = remember { mutableStateOf(250.dp)}

    BottomDrawerScaffold(
        //scaffoldState = rememberBottomDrawerState(5)
        drawerModifier = Modifier.size(530.dp),
        drawerGesturesEnabled = true,
        drawerPeekHeight = peekHeight.value,
        drawerBackgroundColor = Color.Transparent,  //Transparent drawer for custom Drawer shape
        drawerElevation = 0.dp,

        drawerContent = {
            Surface(                    //To add Padding to Drawer
                modifier = Modifier
                ,
                shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
             //   elevation = 4.dp
            ) {
                Box(modifier = Modifier
                    .fillMaxSize()
                    .fillMaxHeight()
                    .fillMaxWidth()
                ){
                    Column() {
                        Box(modifier = Modifier
                            .weight(0.1f)

                        ){
                            MenuTab(navController)
                        }


                        Box(modifier = Modifier
                            .weight(0.8f)
                            .background(MaterialTheme.colors.primaryVariant)
                        ){
                            MakeScrollComponents(navController)
                        }
                    }



                }
            }
        }
    ){
        MakeGoogleMap(true, modifier = Modifier.fillMaxSize())
    }
          /*
    Box(modifier = Modifier
        .fillMaxSize()
        .fillMaxHeight()
        .fillMaxWidth()
    ){
        Column() {
            Box(modifier = Modifier
                .weight(1f)

            ) {


                MakeGoogleMap(true, modifier = Modifier.fillMaxSize())



            }

            Box(modifier = Modifier
                .weight(0.14f)

            ){
                MenuTab(navController)
            }


            Box(modifier = Modifier
                .weight(0.8f)
                .background(MaterialTheme.colors.primaryVariant)
            ){
                MakeScrollComponents(navController)
            }
        }



    }
    makeAddressButton(navController)
    */


}
//    BottomDrawerScaffold(
//        //scaffoldState = rememberBottomDrawerState(5)
//
//
//        drawerModifier = Modifier,
//        drawerGesturesEnabled = true,
//        drawerPeekHeight = 150.dp,
//        drawerBackgroundColor = Color.Transparent,  //Transparent drawer for custom Drawer shape
//        drawerElevation = 0.dp,
//
//        drawerContent = {
//            Surface(                    //To add Padding to Drawer
//                modifier = Modifier
//                    .padding(
//                        start = 10.dp,
//                        end = 10.dp,
//                        top = 10.dp
//                    ),
//                shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
//                elevation = 4.dp
//            ) {
//
//            }
//        }


/*
    Box(modifier = Modifier
        .weight(0.14f)

    ){
        MenuTab(navController)
    }


    Box(modifier = Modifier
        .weight(0.8f)
        .background(MaterialTheme.colors.primaryVariant)
    ){
        MakeScrollComponents(navController)
    }
    */



  //  makeAddressButton(navController)



@Composable
fun makeAddressButton(navController: NavController){
    Column(modifier = Modifier
        .offset(x = 132.dp)
        .padding(5.dp)
        .wrapContentSize())
    {

        Box(
            modifier = Modifier
                .wrapContentSize()
                .padding(2.dp),
        ) {
            FloatingActionButton(
                onClick = {navController.navigate(route=Screen.Search.route){
                    popUpTo(Screen.Search.route){
                        inclusive=true
                    }}
                },
                modifier = Modifier
                    .size(100.dp, 35.dp),
                backgroundColor = Color.Transparent
            ) {
                Text(text="Address", color=Color.DarkGray ,modifier = Modifier, fontStyle = FontStyle.Normal, fontWeight = FontWeight.Bold)
            }
        }
    }
}
@Preview
@Composable
fun PreviewMainFrame()
{
    Box(modifier = Modifier

        .fillMaxWidth(5f)
    ){

    }
}

@Composable
fun MenuTab(navController: NavController){

    Box(modifier = Modifier

    ) {
        Log.d(TAG, "Hello From ")

        Row(
            modifier = Modifier
                .horizontalScroll(rememberScrollState())

        ) {
            Spacer(modifier = Modifier.width(20.dp))
            //Home button
            Column(modifier = Modifier
                .padding(horizontal = 15.dp)


            ) {
                FloatingActionButton(
                    onClick = {navController.navigate(route=Screen.Main.route){
                        popUpTo(Screen.Main.route){
                            inclusive=true
                        }}
                    },
                    modifier = Modifier.scale(.7F),
                    backgroundColor = MaterialTheme.colors.surface
                ) {
                    Image(
                        painter = painterResource(R.drawable.ic_sea_icon_round),
                        contentDescription = "Home!",
                        modifier = Modifier
                            .background(Color.Transparent)
                            .scale(.8F)
                    )

                }
                //Text(text = "Hello")  WTF IS THIS?
            }

            // SORT BUTTON HERE
            Column(modifier = Modifier
                .padding(horizontal = 15.dp)


            ) {
                FloatingActionButton(
                    onClick = {navController.navigate(route=Screen.Sort.route){
                        popUpTo(Screen.Sort.route){
                            inclusive=true
                        }}
                    },
                    modifier = Modifier.scale(.7F),
                    backgroundColor = MaterialTheme.colors.surface
                ) {
                    Image(
                        painter = painterResource(R.drawable.sort_down),
                        contentDescription = "Sort!",
                        modifier = Modifier
                            .background(Color.Transparent)
                            .scale(.5F)
                    )

                }
                //Text(text = "Hello")
            }

            //  Spacer(modifier = Modifier.width(25.dp))

            // EMERGENCY BUTTON HERE
            Column(modifier = Modifier
                .padding(horizontal = 15.dp)


            ) {

                var test by rememberSaveable { mutableStateOf(0)}

                FloatingActionButton(
                    onClick = {navController.navigate(route=Screen.Emergency.route){
                        popUpTo(Screen.Sort.route){
                            inclusive=true
                        }}
                    },
                    modifier = Modifier.scale(.7F),
                    backgroundColor = MaterialTheme.colors.surface
                ) {
                    Image(
                        painter = painterResource(R.drawable.runer_silhouette_running_fast),
                        contentDescription = "Emergency!",
                        modifier = Modifier
                            .background(Color.Transparent)
                            .scale(.8F)

                    )
                }
                //Text(text = "Hello")
            }



            Column(modifier = Modifier
                .padding(horizontal = 15.dp )

            ) {
                FloatingActionButton(
                    onClick = {/*navController.navigate(route=Screen.Signup.route){
                        popUpTo(Screen.Review.route){
                            inclusive=true
                        }}*/
                    },
                    modifier = Modifier.scale(.7F),
                    backgroundColor = MaterialTheme.colors.surface
                ) {
                    Image(
                        painter = painterResource(R.drawable.check),
                        contentDescription = "Expert Verified!",
                        modifier = Modifier
                            .background(Color.Transparent)
                            .scale(.5F)
                    )
                }
                //Text(text = "Hello")
            }



            Column(modifier = Modifier
                .padding(horizontal = 15.dp )
            ) {
                FloatingActionButton(
                    onClick = {navController.navigate(route=Screen.Search.route){
                        popUpTo(Screen.Search.route){
                            inclusive=true
                        }}
                    },
                    modifier = Modifier.scale(.7F),
                    backgroundColor = MaterialTheme.colors.surface
                ) {
                    Image(
                        painter = painterResource(R.drawable.share),
                        contentDescription = "Share!",
                        modifier = Modifier
                            .background(Color.Transparent)
                            .scale(.5F)
                    )
                }
                //Text(text = "Hello")
            }



            Column(modifier = Modifier
                .padding(horizontal = 15.dp )
            ) {
                FloatingActionButton(
                    onClick = { navController.navigate(route=Screen.Profile.route){
                        popUpTo(Screen.Profile.route){
                            inclusive=true
                        }
                    } },
                    modifier = Modifier.scale(.7F),
                    backgroundColor = MaterialTheme.colors.surface
                ) {
                    Image(
                        painter = painterResource(R.drawable.profile_user),
                        contentDescription = "Profile!",
                        modifier = Modifier
                            .background(Color.Transparent)
                            .scale(.5F)
                    )
                }
                //Text(text = "Hello")
            }

        }
    }
}



//val destObject = mutableListOf<LocationsExample>()
@Composable
//pass in true if you want to make markers
fun MakeGoogleMap(
    makeMarker: Boolean = false,
    obj: HashMap<LatLng, Location_Restroom> = Database.dataBase,
    modifier: Modifier
){

    val coroutineScope = rememberCoroutineScope()


    cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(caliMuseum, 15f)
    }
    val contex=LocalContext.current
    var array=Array<Int>(5, init={i->i } )
    var a= arrayOf<Int>()


    var uiSettings by remember { mutableStateOf(MapUiSettings(compassEnabled = false, myLocationButtonEnabled = true, mapToolbarEnabled = true)) }

    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState!!,
        uiSettings = uiSettings,


        onPOIClick = {
            Log.d(TAG, "POI clicked: ${it.name}")
        },

        onMapLongClick = {
            /*
            Log.d(TAG, "lat is : ${it.latitude}")
            var str:String =  reverseGeocoder(contex, it.latitude, it.longitude)
            var a: Location_Restroom = Location_Restroom( str, LatLng(it.latitude, it.longitude))
            */
            //  destObject.add(a)


            // dataAdd(a.loc, a)

            //  cardCount.value++ //force refresh
            cameraPositionState!!.position =
                CameraPosition.fromLatLngZoom(
                    userCurrentLocation,
                    15f
                )


        }
    ) {
        if(makeMarker)
            makeMarkers(obj)


    }


}


//marketCount not in used, make marker base on size of init destObject
@Composable
fun makeMarkers(obj:HashMap<LatLng, Location_Restroom> = Database.dataBase){
    val context = LocalContext.current

    val markerClick: (Marker) -> Boolean = {
        //address.loc=it.position
        false
    }
    // cardCount.value
    Database.dataBase.forEach(){
        Marker(
            position = it.value.loc,
            title = it.value.name,
            snippet = "Marker in ${it.value.name}",
            onClick = markerClick
        )
    }
    /*
    Marker(
        position = caliMuseum,
        title = "Japanese American National Museum",
        snippet = "Marker in California",
        onClick = markerClick
    )
    Marker(
        position = toyDistrict,
        title = "California",
        snippet = "Marker in California",
        onClick = markerClick
    )

    Marker(
        position = brew,
        title = "California",
        snippet = "Marker in California",
        onClick = markerClick
    )
    Marker(
        position = dodgerS,
        title = "California",
        snippet = "Marker in California",
        onClick = markerClick
    )
    Marker(
        position = church,
        title = "California",
        snippet = "Marker in California",
        onClick = markerClick
    )
    */

}

@Composable
fun updateComposable(context:Context)
{

}

fun anotherFunction(){

}

@Composable
fun MakeScrollComponents(navController: NavController){

    // var scrollState:ScrollState =  rememberScrollState()
    // val context = LocalContext.current
    // var textFieldCount by remember { mutableStateOf (destObject.count()) }

    //val gradient = Brush.verticalGradient(0f to Color.Gray, 1000f to Color.White)
    Box(

        modifier = Modifier
            //  .background(Color.Black)
            .fillMaxWidth()
            .fillMaxHeight(1f)
            // .offset(y=300.dp)
            .verticalScroll(rememberScrollState())
            .background(Blue300)

        ,
        // .offset(y = 500.dp)

    ) {

        Column (
            modifier = Modifier
                //.verticalScroll(rememberScrollState())
                .padding(horizontal = 10.dp)

        ) {
            var  dataBaseIter:Int

            if(Database.dataBase.count()>0){
                dataBaseIter=Database.dataBase.count()-1}else dataBaseIter = 0
            //      var entry = Database.dataBase.iterator().next()


            // cardCount.value // force update components

            //////////////////////MAKING ALL THE CARDS//////////////////////////////////////////
            repeat(
                times= Database.dataBase.count()
            ) {
                var currentRestRoom = Database.dataBase[Database.data.getKeyFromList(dataBaseIter)]
                Spacer(modifier = Modifier.padding(10.dp))
                //FIRST CARDS
                Card(
                    modifier = Modifier
                        .height(40.dp)
                        .clickable(onClick = {
//                            Log.d(TAG, "Name is ${lastLoc?.name}")
                            cameraPositionState!!.position =
                                CameraPosition.fromLatLngZoom(
                                    Database.data.getKeyFromList(Database.dataBase.count() - 1 - (it % 5)),
                                    15f
                                )
                            //destObject[destObjSize - it].loc
                        }),
                    RoundedCornerShape(15.dp),
                    elevation = 10.dp
                    // .fillMaxWidth()

                ) {
                    Text(
                        text=currentRestRoom?.name!!,
                        modifier = Modifier
                            .background(Color.White)
                            .padding(5.dp)
                            .fillMaxWidth()

                        ,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        textAlign = TextAlign.Center


                    )
                }
                //SECOND CARD
                Spacer(modifier = Modifier.padding(1.dp))
                Card(
                    modifier = Modifier
                        .height(133.dp)
                        //Toast.makeText(context, "TestA", Toast.LENGTH_LONG) toast syntax
                        .clickable(onClick = {
                            Log.d(TAG, "B4address = ${Database.dataBase.count() - 1 - (it % 5)}")

                            navController.navigate(Screen.Review.route + "/${Database.dataBase.count() - 1 - (it % 5)}")

                        }

                        ),

                    shape= RoundedCornerShape(15.dp),
                    elevation = 10.dp

                ) {

//////////////////////SECOND CARD COTENTS//////////////////////////////////////////
                    val rndsImage = (0..(currentRestRoom!!.image_URL.count()-1)).random()
                    val rndsComment = (0..(currentRestRoom!!.reviewArray.count()-1)).random()
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(2.dp)

                        ,
                        verticalAlignment = Alignment.CenterVertically,

                        ) {

                        Surface(
                            modifier = Modifier
                                /*.size(50.dp, 50.dp)*/
                                .weight(.6f)
                                .fillMaxHeight()
                            ,

                            /*.border(2.dp, Color.Blue),*/
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Row( modifier=Modifier.horizontalScroll(rememberScrollState())) {
                                repeat(currentRestRoom.image_URL.count()) {
                                    Box() {
                                        Image(
                                            modifier = Modifier
                                                //.size(50.dp, 50.dp),
                                                .fillMaxSize(),
                                            contentScale = ContentScale.Inside,
                                            painter = painterResource(id = currentRestRoom!!.image_URL[it]),
                                            //  painter = painterResource(id = restRoomObj?.userIMG_URL?.get(it)!!),
                                            contentDescription = "Urban Bathroom"
                                            /*contentScale = ContentScale.Fit*/
                                        )
                                    }
                                }
                            }


                        }
                        //  restRoomObj is the current component's location_restroom

                        Box(
                            modifier = Modifier
                                .weight(1.0f)
                                .fillMaxHeight()
                                .padding(4.dp),
                            contentAlignment = Alignment.Center
                            //.border(2.dp, Color.Red),
                        ) {

                            //   Text(text = restRoomObj!!.reviewArray[it].customerName,
                            Text(
                                text = "${currentRestRoom!!.reviewArray[rndsComment].customerName}:\n\n\"${currentRestRoom!!.reviewArray[rndsComment].comments}\"",
                                fontSize= 14.sp,
                                modifier = Modifier.fillMaxWidth()
                            )
                            //Spacer(modifier = Modifier.height(30.dp))
                            //  var str: String = dataBase[addressGlobal.loc]?.reviewArray!!.get(it)

                        }

                    }



////////////////////////////////////////////////////////////////////////////
                }

                if(dataBaseIter>0) {
                    --dataBaseIter
                    //  currentRestRoom= Database.dataBase[Database.data.getKeyFromList(dataBaseIter)]
                }
            }
        }
    }
}

*/