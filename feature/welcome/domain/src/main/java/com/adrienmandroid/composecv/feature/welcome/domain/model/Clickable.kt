package com.adrienmandroid.composecv.feature.welcome.domain.model

sealed class Clickable {
    class MailClick(val address:String): Clickable()
    class WebClick(val url:String): Clickable()
}