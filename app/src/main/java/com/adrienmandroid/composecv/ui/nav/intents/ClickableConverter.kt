package com.adrienmandroid.composecv.ui.nav.intents

import com.adrienmandroid.composecv.data.Clickable

fun Clickable?.toViewClick() = when (this) {
    is Clickable.WebClick -> ClickViewModel.ClickAction.WebClick(this.address)
    is Clickable.MailClick -> ClickViewModel.ClickAction.MailClick(this.address)
    null -> null
}