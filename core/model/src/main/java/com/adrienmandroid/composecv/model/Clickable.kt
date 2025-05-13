package com.adrienmandroid.composecv.model

import androidx.annotation.StringRes

sealed class Clickable {
    class MailClick(@StringRes val address:Int): Clickable()
    class WebClick(@StringRes val address:Int): Clickable()
}