package com.adrienmandroid.composecv.feature.experience.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adrienmandroid.composecv.feature.experience.domain.model.Experience
import com.adrienmandroid.composecv.feature.experience.domain.repository.ExperienceRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ExperienceViewmodel @Inject constructor(
    experienceRepository: ExperienceRepository
) : ViewModel() {
    //TODO rajotuer une couche pour le chargement
    val experiences: LiveData<List<Experience>> = experienceRepository.get(viewModelScope)
}