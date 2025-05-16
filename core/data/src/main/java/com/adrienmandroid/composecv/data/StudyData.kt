package com.adrienmandroid.composecv.data

import com.adrienmandroid.composecv.data.model.Study

interface StudyData {
    fun getData(): List<Study>
}