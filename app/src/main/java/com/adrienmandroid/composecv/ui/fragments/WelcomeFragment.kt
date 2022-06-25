package com.adrienmandroid.composecv.ui.fragments

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import com.adrienmandroid.composecv.R
import com.adrienmandroid.composecv.ui.nav.intents.ClickViewModel
import com.adrienmandroid.composecv.ui.welcome.BottomsheetBody
import com.adrienmandroid.composecv.ui.welcome.BottomsheetHeader
import com.adrienmandroid.composecv.ui.welcome.SimpleDraw


@ExperimentalMaterialApi
@Composable
fun WelcomeFragment(
    welcomeElements: List<SimpleDraw>,
    clickViewModel: ClickViewModel = viewModel()
) {

    val webEvent by clickViewModel.webUrl.observeAsState()
    if (webEvent != null) {
        ContextCompat.startActivity(
            LocalContext.current,
            Intent(Intent.ACTION_VIEW, Uri.parse("https://$webEvent")),
            null
        )
        clickViewModel.clearWebIntent()
    }

    val mailEvent by clickViewModel.mailAdress.observeAsState()
    if (mailEvent != null) {
        ContextCompat.startActivity(
            LocalContext.current,
            Intent(Intent.ACTION_VIEW, Uri.parse("mailto:$mailEvent")),
            null
        )

        clickViewModel.clearMailIntent()
    }

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
                    BottomsheetBody(welcomeElements, clickViewModel)
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