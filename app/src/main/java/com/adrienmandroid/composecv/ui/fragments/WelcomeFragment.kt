package com.adrienmandroid.composecv.ui.fragments

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.adrienmandroid.composecv.R

@ExperimentalMaterialApi
@Composable
fun WelcomeFragment() {

    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberBottomSheetState(BottomSheetValue.Collapsed)
    )
    BottomSheetScaffold(
        scaffoldState = bottomSheetScaffoldState,
        sheetBackgroundColor = Color.Transparent,
        sheetElevation = 0.dp,
        sheetContent = {
            Box(
                Modifier
                    .fillMaxWidth()
                    .fillMaxHeight().background(Color.Transparent)
            ) {
                //, verticalArrangement = Arrangement.spacedBy((-32).dp)
                LazyColumn(Modifier.fillMaxWidth(1f)) {
                    item{
                        Column(modifier = Modifier.fillMaxWidth(1f), verticalArrangement = Arrangement.spacedBy((-16).dp)){
                            Image(
                                painter = painterResource(R.drawable.profile_picture),
                                contentDescription = "Picture",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.width(150.dp).height(150.dp).zIndex(1f)
                            )
                            Spacer(modifier = Modifier.height(16.dp).fillMaxWidth(1f).background(Color.Blue))
                        }

                    }
                    val listDistance = listOf(100.dp, 80.dp, 60.dp, 90.dp, 130.dp, 150.dp)
                    items(items=listDistance){
                        Box(modifier = Modifier.background(Color.Blue).fillMaxWidth(1f)){
                            Spacer(modifier = Modifier.height(it))
                            Text(text="test")
                        }
                    }
                }

            }

        }, sheetPeekHeight = 600.dp
    ) {
        //Under the bottom sheet
        Image(
            painter = painterResource(R.drawable.background_picture),
            contentDescription = "Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth()
        )

    }
}