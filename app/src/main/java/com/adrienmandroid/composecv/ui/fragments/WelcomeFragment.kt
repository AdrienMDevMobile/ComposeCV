package com.adrienmandroid.composecv.ui.fragments

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.adrienmandroid.composecv.R
import com.adrienmandroid.composecv.ui.welcome.*

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
                    BottomsheetHeader()
                    BottomsheetBody()
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