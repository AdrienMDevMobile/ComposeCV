package com.adrienmandroid.composecv.feature.experience.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adrienmandroid.composecv.core.ui.states.UiStates
import com.adrienmandroid.composecv.feature.experience.domain.repository.ExperienceRepository
import com.adrienmandroid.composecv.feature.experience.ui.state.ExperienceUiState
import com.adrienmandroid.composecv.feature.experience.ui.state.toUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExperienceViewmodel @Inject constructor(
    experienceRepository: ExperienceRepository
) : ViewModel() {
    val _experiences: MutableLiveData<UiStates<List<ExperienceUiState>>> =
        MutableLiveData(UiStates.Loading)
    val experiences: LiveData<UiStates<List<ExperienceUiState>>>
        get() = _experiences

    init {
        viewModelScope.launch {
            experienceRepository.get(viewModelScope).collect { data ->
                _experiences.value = UiStates.Success(value = data.map { experience ->
                    experience.toUiState()
                })
            }
        }
    }
}