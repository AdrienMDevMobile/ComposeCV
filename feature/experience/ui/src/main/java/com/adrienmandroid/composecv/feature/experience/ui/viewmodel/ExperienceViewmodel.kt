package com.adrienmandroid.composecv.feature.experience.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.adrienmandroid.composecv.feature.experience.domain.model.Experience
import com.adrienmandroid.composecv.feature.experience.domain.repository.ExperienceRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ExperienceViewmodel @Inject constructor(
    experienceRepository: ExperienceRepository
) : ViewModel() {
    private val _experiences: MutableLiveData<List<Experience>> = MutableLiveData(emptyList())
    val experiences: LiveData<List<Experience>>
        get() = _experiences

    init {
        _experiences.value = experienceRepository.getExperiences()
    }
}