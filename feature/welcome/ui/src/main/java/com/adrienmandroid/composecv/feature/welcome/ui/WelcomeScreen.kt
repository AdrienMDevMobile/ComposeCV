package com.adrienmandroid.composecv.feature.welcome.ui

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Box
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.adrienmandroid.composecv.core.ui.ErrorPage
import com.adrienmandroid.composecv.core.ui.LoadingPage
import com.adrienmandroid.composecv.core.ui.states.PageState
import com.adrienmandroid.composecv.feature.welcome.domain.model.Clickable
import com.adrienmandroid.composecv.feature.welcome.ui.element.WelcomeBackgroundPicture
import com.adrienmandroid.composecv.feature.welcome.ui.element.WelcomeBottomSheet
import com.adrienmandroid.composecv.feature.welcome.ui.element.WelcomeProfilePicture
import com.adrienmandroid.composecv.feature.welcome.ui.viewmodel.WelcomePageUiState
import com.adrienmandroid.composecv.feature.welcome.ui.viewmodel.WelcomeViewModel
import com.adrienmandroid.composecv.feature.welcome.ui.viewmodel.WelcomeViewModel.ClickAction

@ExperimentalMaterialApi
@Composable
fun WelcomeScreen(
    welcomeViewModel: WelcomeViewModel = hiltViewModel(),
    modifier: Modifier = Modifier,
) {
    val welcomePageUiState: PageState<WelcomePageUiState> by welcomeViewModel.welcomePageUiState.observeAsState(
        PageState.Loading
    )

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
            data = Uri.parse("mailto:$mailEvent")
        }
        context.startActivity(intent)
        welcomeViewModel.clearMailIntent()
    }

    Box(modifier = Modifier.testTag(WELCOME_SCREEN_ID)) {
        when (welcomePageUiState) {
            PageState.Loading -> LoadingPage()
            PageState.Error -> ErrorPage()
            is PageState.Content<WelcomePageUiState?> -> WelcomeScreen(
                components = (welcomePageUiState as PageState.Content<WelcomePageUiState>).value,
                onClick = { clickable ->
                    welcomeViewModel.onClick(ClickAction.ElementClick(clickable))
                },
                modifier = modifier,
            )
        }
    }
}

const val WELCOME_SCREEN_ID = "WELCOME_SCREEN_ID"

@Composable
fun WelcomeScreen(
    components: WelcomePageUiState,
    onClick: (Clickable) -> Unit,
    modifier: Modifier = Modifier,
) {
    components.let { page ->
        WelcomeBottomSheet(
            contentCovered = {
                WelcomeBackgroundPicture(
                    welcomeImageUrl = page.header.backgroundPictureUrl
                )
            },
            welcomeBodyElements = page.body,
            anchoredContent = {
                WelcomeProfilePicture(
                    welcomeImageUrl = page.header.profilePictureUrl
                )
            },
            onClick = { clickable ->
                onClick(clickable)
            },
            modifier = modifier,
        )
    }
}