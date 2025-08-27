package com.adrienmandroid.composecv.feature.skills.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adrienmandroid.composecv.feature.skills.domain.repository.SkillRepository
import com.adrienmandroid.composecv.feature.skills.domain.model.Skill
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SkillViewModel @Inject constructor(
    skillRepository: SkillRepository
) : ViewModel() {
    val skills : LiveData<List<Skill>> = skillRepository.get(viewModelScope)
}