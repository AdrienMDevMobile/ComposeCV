package com.adrienmandroid.composecv.feature.skills.domain.repository

import androidx.lifecycle.LiveData
import com.adrienmandroid.composecv.feature.skills.domain.model.Skill
import kotlinx.coroutines.CoroutineScope

interface SkillRepository {
    fun get(coroutineScope: CoroutineScope): LiveData<List<Skill>>
}