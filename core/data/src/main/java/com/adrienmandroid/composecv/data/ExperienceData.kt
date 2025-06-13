package com.adrienmandroid.composecv.data

import com.adrienmandroid.composecv.model.Experience

interface ExperienceData {
    fun getExperiences(): List<Experience>
}