package com.adrienmandroid.composecv.feature.experience.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adrienmandroid.composecv.core.ui.states.PageState
import com.adrienmandroid.composecv.feature.experience.domain.repository.ExperienceRepository
import com.adrienmandroid.composecv.feature.experience.ui.state.ExperienceUiState
import com.adrienmandroid.composecv.feature.experience.ui.state.toUiState
import com.adrienmandroid.composecv.model.response.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExperienceViewmodel @Inject constructor(
    experienceRepository: ExperienceRepository
) : ViewModel() {
    private val _experiences: MutableLiveData<PageState<List<ExperienceUiState>>> =
        MutableLiveData(PageState.Loading)
    val experiences: LiveData<PageState<List<ExperienceUiState>>>
        get() = _experiences

    init {
        viewModelScope.launch {
            experienceRepository.get().collect { response ->
                if(response is Response.Success){
                    _experiences.value = PageState.Content(value = response.page.map { experience ->
                        experience.toUiState()
                    })
                } else {
                    _experiences.value = PageState.Error
                }
            }
        }
    }
}