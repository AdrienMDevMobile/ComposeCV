package com.adrienmandroid.composecv.feature.welcome

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.core.content.ContextCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import com.adrienmandroid.composecv.feature.welcome.ui.element.ClickViewModel
import com.adrienmandroid.composecv.feature.welcome.ui.element.MyBottomSheet
import com.adrienmandroid.composecv.feature.welcome.ui.element.bottomsheetBody
import com.adrienmandroid.composecv.model.WelcomeElement


@ExperimentalMaterialApi
@Composable
fun WelcomeFragment(
    welcomeElements: List<WelcomeElement>,
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

    val mailEvent by clickViewModel.mailAddress.observeAsState()
    if (mailEvent != null) {
        ContextCompat.startActivity(
            LocalContext.current,
            Intent(Intent.ACTION_VIEW, Uri.parse("mailto:$mailEvent")),
            null
        )

        clickViewModel.clearMailIntent()
    }

    MyBottomSheet(
        contentCovered = {
            Image(
                //TODO background picture (donner cela depuis data)
                painter = painterResource(R.drawable.picture_test),
                contentDescription = "Background",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth().height(250.dp)
            )
        },
        anchoredContent = {
            Image(
                //TODO profile picture
                painter = painterResource(R.drawable.picture_test),
                contentDescription = "Picture",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(150.dp)
                    .height(150.dp)
                    .padding(5.dp)
                    .zIndex(1f)
                    .clip(CircleShape)
                    .border(4.dp, MaterialTheme.colors.background, CircleShape)
            )
        }) {
        bottomsheetBody(welcomeElements, clickViewModel)
    }
}