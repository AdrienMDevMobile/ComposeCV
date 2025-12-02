package com.adrienmandroid.composecv.feature.other.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adrienmandroid.composecv.core.ui.states.UiStates
import com.adrienmandroid.composecv.feature.other.domain.repository.OtherRepository
import com.adrienmandroid.composecv.feature.other.ui.state.OtherComponentUiState
import com.adrienmandroid.composecv.feature.other.ui.state.toUiState
import com.adrienmandroid.composecv.model.response.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OtherViewModel @Inject constructor(
    otherRepository: OtherRepository
) : ViewModel() {
    private val _otherComponents: MutableLiveData<UiStates<List<OtherComponentUiState>>> =
        MutableLiveData(UiStates.Loading)
    val otherComponents: LiveData<UiStates<List<OtherComponentUiState>>>
        get() = _otherComponents

    init {
        viewModelScope.launch {
            otherRepository.get().collect { response ->
                if(response is Response.Success){
                    _otherComponents.value = UiStates.Success(
                        value = response.page.map { component ->
                            component.toUiState()
                        }
                    )
                } else {
                    _otherComponents.value = UiStates.Error
                }
            }
        }
    }
}