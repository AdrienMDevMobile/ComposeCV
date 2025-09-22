package com.adrienmandroid.composecv.feature.other.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adrienmandroid.composecv.core.ui.states.UiStates
import com.adrienmandroid.composecv.feature.other.domain.repository.VersionNameRepository
import com.adrienmandroid.composecv.feature.other.domain.model.Hobby
import com.adrienmandroid.composecv.feature.other.domain.model.OtherComponent
import com.adrienmandroid.composecv.feature.other.domain.model.Quote
import com.adrienmandroid.composecv.feature.other.domain.model.Study
import com.adrienmandroid.composecv.feature.other.domain.model.VersionName
import com.adrienmandroid.composecv.feature.other.domain.repository.OtherRepository
import com.adrienmandroid.composecv.feature.other.ui.state.OtherComponentUiState
import com.adrienmandroid.composecv.feature.other.ui.state.toUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OtherViewModel @Inject constructor(
    otherRepository: OtherRepository
) : ViewModel() {
    private val _otherComponents: MutableLiveData<UiStates<List<OtherComponentUiState>>> = MutableLiveData(UiStates.Loading)
    val otherComponents: LiveData<UiStates<List<OtherComponentUiState>>>
        get() = _otherComponents

    init {
        viewModelScope.launch {
            otherRepository.get(viewModelScope).collect { data ->
                _otherComponents.value = UiStates.Success(
                    value = data.map { component ->
                        component.toUiState()
                    }
                )
            }
        }
    }
}