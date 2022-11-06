package com.adrienmandroid.composecv.data

sealed class Clickable {
    class MailClick(val address:String): Clickable()
    class WebClick(val address:String): Clickable()
}