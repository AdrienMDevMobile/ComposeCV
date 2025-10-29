package com.adrienmandroid.composecv.feature.welcome.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adrienmandroid.composecv.feature.welcome.domain.model.Clickable
import com.adrienmandroid.composecv.feature.welcome.domain.repository.WelcomeElementsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WelcomeViewModel @Inject constructor(
    welcomeElementsRepository: WelcomeElementsRepository
) : ViewModel() {
    private val _welcomePageUiState = MutableLiveData<WelcomePageUiState?>(null)
    val welcomePageUiState: LiveData<WelcomePageUiState?>
        get() = _welcomePageUiState

    private val _webUrl = MutableLiveData<String?>()
    val webUrl: LiveData<String?>
        get() = _webUrl

    private val _mailAddress = MutableLiveData<String?>()
    val mailAddress: LiveData<String?>
        get() = _mailAddress

    init {
        viewModelScope.launch {
            welcomeElementsRepository.get(viewModelScope).collect { response ->
                _welcomePageUiState.value = WelcomePageUiState(
                    response.header,
                    response.page
                )
            }
        }

    }

    fun onClick(action: ClickAction) {
        when (action) {
            is ClickAction.ElementClick -> {
                when (action.clickable) {
                    is Clickable.MailClick -> onMailClick(action.clickable.address)
                    is Clickable.WebClick -> onWebClick(action.clickable.url)
                }
            }
        }
    }

    private fun onWebClick(address: String) {
        _webUrl.postValue(address)
    }

    fun clearWebIntent() {
        _webUrl.postValue(null)
    }

    private fun onMailClick(address: String) {
        _mailAddress.postValue(address)
    }

    fun clearMailIntent() {
        _mailAddress.postValue(null)
    }

    sealed class ClickAction {
        //Elements found in the page, whose design is driven by server.
        //This gives us room for other elements (such as hard coded ones)
        class ElementClick(val clickable: Clickable) : ClickAction()
    }
}
