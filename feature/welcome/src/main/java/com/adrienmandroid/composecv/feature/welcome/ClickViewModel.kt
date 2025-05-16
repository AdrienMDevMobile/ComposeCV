package com.adrienmandroid.composecv.feature.welcome

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ClickViewModel() : ViewModel() {
    private val _webUrl = MutableLiveData<String>()
    val webUrl: LiveData<String>
        get() = _webUrl

    private val _mailAddress = MutableLiveData<String>()
    val mailAddress: LiveData<String>
        get() = _mailAddress

    fun onClick(action: ClickAction) {
        when (action) {
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
        _mailAddress.postValue(address)
    }

    fun clearMailIntent() {
        _mailAddress.postValue(null)
    }

    sealed class ClickAction {
        class MailClick(val address: String) : ClickAction()
        class WebClick(val address: String) : ClickAction()
    }
}
