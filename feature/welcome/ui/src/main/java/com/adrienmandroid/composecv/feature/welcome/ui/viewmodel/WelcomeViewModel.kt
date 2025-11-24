package com.adrienmandroid.composecv.feature.welcome.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adrienmandroid.composecv.core.ui.states.UiStates
import com.adrienmandroid.composecv.feature.welcome.domain.model.Clickable
import com.adrienmandroid.composecv.feature.welcome.domain.model.WelcomeHeader
import com.adrienmandroid.composecv.feature.welcome.domain.repository.WelcomeElementsRepository
import com.adrienmandroid.composecv.model.response.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WelcomeViewModel @Inject constructor(
    welcomeElementsRepository: WelcomeElementsRepository
) : ViewModel() {
    private val _welcomePageUiState = MutableLiveData<UiStates<WelcomePageUiState?>>(null)
    val welcomePageUiState: LiveData<UiStates<WelcomePageUiState?>>
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
                if (response is Response.Success) {
                    _welcomePageUiState.value = UiStates.Success(
                        WelcomePageUiState(
                            response.header ?: WelcomeHeader("", ""),
                            response.page
                        )
                    )
                } else {
                    _welcomePageUiState.value = UiStates.Error
                }
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
