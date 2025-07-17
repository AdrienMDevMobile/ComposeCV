package com.adrienmandroid.composecv.feature.welcome.ui

import android.content.Intent
import android.net.Uri
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.adrienmandroid.composecv.feature.welcome.domain.model.WelcomePage
import com.adrienmandroid.composecv.feature.welcome.ui.element.WelcomeBackgroundPicture
import com.adrienmandroid.composecv.feature.welcome.ui.element.WelcomeBottomSheet
import com.adrienmandroid.composecv.feature.welcome.ui.element.WelcomeProfilePicture
import com.adrienmandroid.composecv.feature.welcome.ui.viewmodel.WelcomeViewModel
import com.adrienmandroid.composecv.feature.welcome.ui.viewmodel.WelcomeViewModel.ClickAction

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
                WelcomeBackgroundPicture(
                    welcomeImageUrl = page.header.backgroundPictureUrl
                )
            },
            welcomeBodyElements = page.body,
            anchoredContent = {
                WelcomeProfilePicture(page.header.profilePictureUrl)
            },
            onClick = { action ->
                welcomeViewModel.onClick(ClickAction.ElementClick(action))
            }
        )
    }
}