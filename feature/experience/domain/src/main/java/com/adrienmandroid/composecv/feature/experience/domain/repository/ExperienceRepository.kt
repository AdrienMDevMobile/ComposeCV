package com.adrienmandroid.composecv.feature.experience.domain.repository

import com.adrienmandroid.composecv.feature.experience.domain.model.Experience

interface ExperienceRepository {
    fun getExperiences(): List<Experience>
}