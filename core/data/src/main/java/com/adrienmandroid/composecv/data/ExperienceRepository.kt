package com.adrienmandroid.composecv.data

import com.adrienmandroid.composecv.model.Experience

interface ExperienceRepository {
    fun getExperiences(): List<Experience>
}