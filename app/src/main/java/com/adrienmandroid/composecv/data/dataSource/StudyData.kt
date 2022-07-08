package com.adrienmandroid.composecv.data.dataSource

import com.adrienmandroid.composecv.data.Study

interface StudyData {
    fun getData() : List<Study>
}