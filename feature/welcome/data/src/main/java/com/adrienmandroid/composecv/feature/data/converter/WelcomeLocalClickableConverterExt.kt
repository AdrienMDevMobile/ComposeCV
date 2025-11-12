package com.adrienmandroid.composecv.feature.data.converter

import com.adrienmandroid.composecv.feature.welcome.domain.model.Clickable

fun getClickableFromLocalEntity(clickableType: String?, clickableValue: String?): Clickable? =
    if (clickableType != null && clickableValue != null) {
        when (clickableType) {
            ClickableLocalTypes.WEB -> Clickable.WebClick(clickableValue)
            ClickableLocalTypes.MAIL -> Clickable.MailClick(clickableValue)
            else -> null
        }
    } else null

fun Clickable.getClickableType() =
    when(this){
        is Clickable.MailClick -> ClickableLocalTypes.MAIL
        is Clickable.WebClick -> ClickableLocalTypes.WEB
    }

fun Clickable.getValue() =
    when(this){
        is Clickable.MailClick -> address
        is Clickable.WebClick -> url
    }

private object ClickableLocalTypes{
    const val WEB = "WEB"
    const val MAIL = "MAIL"
}