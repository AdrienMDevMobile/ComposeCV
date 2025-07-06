package com.adrienmandroid.composecv.model

sealed class Clickable {
    class MailClick(val address:String): Clickable()
    class WebClick(val url:String): Clickable()
}