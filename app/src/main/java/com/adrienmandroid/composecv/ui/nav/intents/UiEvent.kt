package com.adrienmandroid.composecv.ui.nav.intents

sealed class UiEvent {
    class MailEvent(val adress: String) : UiEvent()
    class WebEvent(val adress: String) : UiEvent()
}
