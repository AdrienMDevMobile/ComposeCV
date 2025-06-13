package com.adrienmandroid.composecv.data

import com.adrienmandroid.composecv.model.Study

interface StudyData {
    fun getData(): List<Study>
}