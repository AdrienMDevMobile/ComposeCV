package com.adrienmandroid.composecv.feature.skills.domain.repository

import com.adrienmandroid.composecv.feature.skills.domain.model.Skill
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

interface SkillRepository {
    fun get(coroutineScope: CoroutineScope): Flow<List<Skill>>
}