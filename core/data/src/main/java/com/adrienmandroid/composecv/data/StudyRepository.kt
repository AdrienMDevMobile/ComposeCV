package com.adrienmandroid.composecv.data

import com.adrienmandroid.composecv.model.Study

interface StudyRepository {
    fun getData(): List<Study>
}