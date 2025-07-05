package com.adrienmandroid.composecv.feature.skills.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.adrienmandroid.composecv.data.SkillRepository
import com.adrienmandroid.composecv.model.Skill
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SkillViewModel @Inject constructor(
    skillRepository: SkillRepository
) : ViewModel() {
    private val _skills = MutableLiveData<List<Skill>>()
    val skills : LiveData<List<Skill>>
        get() = _skills

    init {
        _skills.value = skillRepository.getSkills()
    }
}