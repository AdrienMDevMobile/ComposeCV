package com.adrienmandroid.composecv.data.dataSource

import com.adrienmandroid.composecv.data.Experience

interface ExperienceData {
    fun getExperiences(): List<Experience>
}