package com.adrienmandroid.composecv.feature.other

import android.content.Context
import com.adrienmandroid.composecv.feature.other.data.R
import com.adrienmandroid.composecv.feature.other.domain.repository.StudyRepository
import com.adrienmandroid.composecv.model.Dates
import com.adrienmandroid.composecv.feature.other.domain.model.Study
import dagger.hilt.android.qualifiers.ApplicationContext
import java.util.Date
import javax.inject.Inject

class StudyRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : StudyRepository {
    override fun getData(): List<Study> = listOf(
        Study(
            logo = R.drawable.image_ece,
            name = context.getString(R.string.study_ece),
            diploma = context.getString(R.string.diploma_ece),
            studyDates = Dates(
                begin = Date(1593554400000), end = Date(1641596400000)
            )
        ),
        Study(
            logo = R.drawable.image_brighton,
            name = context.getString(R.string.study_brighton),
            diploma = context.getString(R.string.diploma_brighton),
            studyDates = Dates(
                begin = Date(1593554400000), end = Date(1641596400000)
            ),
            longString = true
        ),
        Study(
            logo = R.drawable.image_descartes,
            name = context.getString(R.string.study_descartes),
            diploma = context.getString(R.string.diploma_descartes),
            studyDates = Dates(
                begin = Date(1593554400000), end = Date(1641596400000)
            )
        )
    )

}