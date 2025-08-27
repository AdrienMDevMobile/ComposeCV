package com.adrienmandroid.composecv.feature.skills.domain.repository

import javax.inject.Inject

class SkillRepository @Inject constructor (
    val remoteRepository: SkillRemoteRepository,
) {
    fun getSkills() = remoteRepository.getSkills()
}