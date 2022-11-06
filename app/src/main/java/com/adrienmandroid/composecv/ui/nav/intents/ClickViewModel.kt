package com.adrienmandroid.composecv.ui.nav.intents

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ClickViewModel : ViewModel() {
    private val _webUrl = MutableLiveData<String>()
    val webUrl: LiveData<String>
        get() = _webUrl

    private val _mailAdress = MutableLiveData<String>()
    val mailAdress: LiveData<String>
        get() = _mailAdress

    fun onClick(action:ClickAction){
        when(action){
            is ClickAction.MailClick -> onMailClick(action.address)
            is ClickAction.WebClick -> onWebClick(action.address)
        }
    }

    fun onWebClick(address: String) {
        _webUrl.postValue(address)
    }

    fun clearWebIntent() {
        _webUrl.postValue(null)
    }

    fun onMailClick(address: String) {
        _mailAdress.postValue(address)
    }

    fun clearMailIntent() {
        _mailAdress.postValue(null)
    }

    sealed class ClickAction {
        class MailClick(val address:String): ClickAction()
        class WebClick(val address:String): ClickAction()
    }
}
