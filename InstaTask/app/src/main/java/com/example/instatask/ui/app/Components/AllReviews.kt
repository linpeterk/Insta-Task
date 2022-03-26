package com.example.instatask.ui.app.Components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun AllReviews(creatorList:List<JobCreator>) //add parameters here
{

    Scaffold(

//        topBar = {          //Reviews title
//
//            TopAppBar(backgroundColor = MaterialTheme.colors.primary,
//                title = { Text(text = "Reviews") })
//
//        }
    )
    {

        LazyColumn(     //lazyColumn of review cards

            Modifier.fillMaxWidth(),
            contentPadding= PaddingValues(16.dp)

        )
        {

            item {

                Row(
                    modifier= Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(vertical = 25.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically

                ) {

                    Text(text = "Reviews",
                        style= MaterialTheme.typography.h5 )
                }

            }// end of item

            items(creatorList)
            { creator->

                JobCreatorCard(creator.name, creator.description,creator.imageRes)

            }



        }

    }
}