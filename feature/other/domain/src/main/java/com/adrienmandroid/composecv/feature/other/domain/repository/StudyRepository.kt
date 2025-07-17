package com.adrienmandroid.composecv.feature.other.domain.repository

import com.adrienmandroid.composecv.feature.other.domain.model.Study

interface StudyRepository {
    fun getData(): List<Study>
}