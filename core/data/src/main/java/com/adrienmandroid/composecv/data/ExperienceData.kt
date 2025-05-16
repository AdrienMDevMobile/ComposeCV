package com.adrienmandroid.composecv.data

import com.adrienmandroid.composecv.data.model.Experience

interface ExperienceData {
    fun getExperiences(): List<Experience>
}