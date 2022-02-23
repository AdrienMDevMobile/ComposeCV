package com.adrienmandroid.composecv.ui.fragments

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
                Column(Modifier.background(Color.Transparent), verticalArrangement = Arrangement.spacedBy((-32).dp)) {
                    Image(
                        painter = painterResource(R.drawable.profile_picture),
                        contentDescription = "Picture",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.width(150.dp).height(150.dp).zIndex(1f)
                    )
                    Column(
                        Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .background(Color.Blue)
                    ){
                        Spacer(modifier = Modifier.height(32.dp))
                        Text(text = "Hello from sheet")
                    }
                }

            }

        }, sheetPeekHeight = 600.dp
        , modifier = Modifier.background(Color.Green)
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