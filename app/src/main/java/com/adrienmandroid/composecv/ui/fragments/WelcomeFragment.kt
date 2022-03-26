package com.adrienmandroid.composecv.ui.fragments

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
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
import androidx.compose.ui.res.stringResource
import com.adrienmandroid.composecv.ui.welcome.ImageDraw
import com.adrienmandroid.composecv.ui.welcome.SimpleDrawable
import com.adrienmandroid.composecv.ui.welcome.TextDraw

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
                    .fillMaxHeight()
                    .background(Color.Transparent)
            ) {
                //, verticalArrangement = Arrangement.spacedBy((-32).dp)
                LazyColumn(Modifier.fillMaxWidth(1f)) {
                    item {
                        Column(
                            modifier = Modifier.fillMaxWidth(1f),
                            verticalArrangement = Arrangement.spacedBy((-16).dp)
                        ) {
                            Image(
                                painter = painterResource(R.drawable.profile_picture),
                                contentDescription = "Picture",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .width(150.dp)
                                    .height(150.dp)
                                    .zIndex(1f)
                            )
                            Spacer(
                                modifier = Modifier
                                    .height(16.dp)
                                    .fillMaxWidth(1f)
                                    .background(Color.Blue)
                            )
                        }

                    }
                    items(items = listOfItemInBottomSheet()){
                        Box(modifier = Modifier.background(Color.Green).fillMaxWidth()){
                            Spacer(modifier = Modifier.height(10.dp))
                            it.draw()
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

fun listOfItemInBottomSheet() : List<SimpleDrawable> {
    return listOf(
        TextDraw(id = R.string.names),
        TextDraw(id = R.string.title),
        TextDraw(id = R.string.age, arrayOf(26)),
        TextDraw(id = R.string.emailAdress),
        TextDraw(id = R.string.selfPresentation),
        ImageDraw(R.drawable.auboulotavelo, "Au boult à velo")

    )
}
