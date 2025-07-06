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
import androidx.hilt.navigation.compose.hiltViewModel
import com.adrienmandroid.composecv.feature.welcome.ui.element.WelcomeBottomSheet
import com.adrienmandroid.composecv.feature.welcome.viewmodel.WelcomeViewModel
import com.adrienmandroid.composecv.feature.welcome.viewmodel.WelcomeViewModel.ClickAction
import com.adrienmandroid.composecv.model.WelcomePage

@ExperimentalMaterialApi
@Composable
fun WelcomeFragment(
    welcomeViewModel: WelcomeViewModel = hiltViewModel(),
) {
    val welcomePage: WelcomePage? by welcomeViewModel.welcomePage.observeAsState(null)

    val context = LocalContext.current

    val webEvent by welcomeViewModel.webUrl.observeAsState()
    if (webEvent != null) {
        context.startActivity(
            Intent(Intent.ACTION_VIEW, Uri.parse("https://$webEvent")),
            null
        )
        welcomeViewModel.clearWebIntent()
    }

    val mailEvent by welcomeViewModel.mailAddress.observeAsState()
    if (mailEvent != null) {
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            setData(Uri.parse("mailto:$mailEvent"))
        }
        context.startActivity(intent)
        welcomeViewModel.clearMailIntent()
    }

    welcomePage?.let { page ->
        WelcomeBottomSheet(
            contentCovered = {
                Image(
                    painter = painterResource(page.header.backgroundPicture),
                    contentDescription = "Background",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp)
                )
            },
            welcomeBodyElements = page.body,
            anchoredContent = {
                Image(
                    painter = painterResource(page.header.profilePicture),
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
            },
            onClick = { action ->
                welcomeViewModel.onClick(ClickAction.ElementClick(action))
            }
        )
    }
}