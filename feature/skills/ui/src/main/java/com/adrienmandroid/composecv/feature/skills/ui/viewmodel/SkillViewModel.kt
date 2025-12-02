package com.adrienmandroid.composecv.feature.skills.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adrienmandroid.composecv.core.ui.states.PageState
import com.adrienmandroid.composecv.feature.skills.domain.repository.SkillRepository
import com.adrienmandroid.composecv.feature.skills.ui.state.SkillUiState
import com.adrienmandroid.composecv.feature.skills.ui.state.toUiState
import com.adrienmandroid.composecv.model.response.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SkillViewModel @Inject constructor(
    skillRepository: SkillRepository
) : ViewModel() {
    private val _skills: MutableLiveData<PageState<List<SkillUiState>>> = MutableLiveData(PageState.Loading)
    val skills: LiveData<PageState<List<SkillUiState>>>
        get() = _skills

    init {
        viewModelScope.launch {
            skillRepository.get().collect { response ->
                if(response is Response.Success){
                    _skills.value = PageState.Content(
                        value = response.page.map { skill ->
                            skill.toUiState()
                        }
                    )
                } else {
                    _skills.value = PageState.Error
                }

            }
        }
    }
}