package com.adrienmandroid.composecv.data.impl

import com.adrienmandroid.composecv.data.R
import com.adrienmandroid.composecv.data.model.Dates
import com.adrienmandroid.composecv.data.model.Study
import com.adrienmandroid.composecv.data.StudyData
import java.util.*

class StudyDataImpl : StudyData {
    override fun getData(): List<Study> = listOf(
        Study(
            logo = R.drawable.image_ece,
            name = R.string.study_ece,
            diploma = R.string.diploma_ece,
            studyDates = Dates(
                begin = Date(1593554400000), end = Date(1641596400000)
            )
        ),
        Study(
            logo = R.drawable.image_brighton,
            name = R.string.study_brighton,
            diploma = R.string.diploma_brighton,
            studyDates = Dates(
                begin = Date(1593554400000), end = Date(1641596400000)
            ),
            longString = true
        ),
        Study(
            logo = R.drawable.image_descartes,
            name = R.string.study_descartes,
            diploma = R.string.diploma_descartes,
            studyDates = Dates(
                begin = Date(1593554400000), end = Date(1641596400000)
            )
        )
    )

}