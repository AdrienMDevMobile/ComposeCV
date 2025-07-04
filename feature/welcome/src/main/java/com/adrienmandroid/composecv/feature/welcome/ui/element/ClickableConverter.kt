package com.adrienmandroid.composecv.feature.welcome.ui.element

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.adrienmandroid.composecv.feature.welcome.viewmodel.WelcomeViewModel
import com.adrienmandroid.composecv.model.Clickable

@Composable
fun Clickable?.toViewClick() = when (this) {
    is Clickable.WebClick -> WelcomeViewModel.ClickAction.WebClick(stringResource(id = this.address))
    is Clickable.MailClick -> WelcomeViewModel.ClickAction.MailClick(stringResource(id = this.address))
    null -> null
}