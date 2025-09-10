package com.adrienmandroid.composecv.feature.skills.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adrienmandroid.composecv.core.ui.states.UiStates
import com.adrienmandroid.composecv.feature.skills.domain.repository.SkillRepository
import com.adrienmandroid.composecv.feature.skills.ui.state.SkillUiState
import com.adrienmandroid.composecv.feature.skills.ui.state.toUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SkillViewModel @Inject constructor(
    skillRepository: SkillRepository
) : ViewModel() {
    val _skills: MutableLiveData<UiStates<List<SkillUiState>>> = MutableLiveData(UiStates.Loading)
    val skills: LiveData<UiStates<List<SkillUiState>>>
        get() = _skills

    init {
        viewModelScope.launch {
            skillRepository.get(viewModelScope).collect { data ->
                _skills.value = UiStates.Success(value = data.map { skill ->
                    skill.toUiState()
                }
                )
            }
        }
    }
}