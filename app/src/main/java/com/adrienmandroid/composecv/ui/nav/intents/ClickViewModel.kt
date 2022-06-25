package com.adrienmandroid.composecv.ui.nav.intents

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ClickViewModel : ViewModel() {
    val _webUrl = MutableLiveData<String>()
    val webUrl: LiveData<String>
        get() = _webUrl

    fun onWebClick(address: String) {
        _webUrl.postValue(address)
    }

    fun clearWebIntent() {
        _webUrl.postValue(null)
    }
}
