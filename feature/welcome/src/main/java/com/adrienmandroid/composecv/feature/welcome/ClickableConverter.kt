package com.adrienmandroid.composecv.feature.welcome

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.adrienmandroid.composecv.model.Clickable

@Composable
fun Clickable?.toViewClick() = when (this) {
    is Clickable.WebClick -> ClickViewModel.ClickAction.WebClick(stringResource(id = this.address))
    is Clickable.MailClick -> ClickViewModel.ClickAction.MailClick(stringResource(id = this.address))
    null -> null
}