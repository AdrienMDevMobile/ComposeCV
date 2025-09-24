package com.adrienmandroid.composecv.feature.other.ui.preview.data

import android.content.Context
import com.adrienmandroid.composecv.core.test.R
import com.adrienmandroid.composecv.feature.other.ui.state.OtherComponentUiState
import com.adrienmandroid.composecv.feature.other.ui.state.StudyUiState
import com.adrienmandroid.composecv.model.Dates
import java.util.Date

class StudyPreviewParameterData(
    context: Context,
) {
    internal val studies = OtherComponentUiState.StudyUiStates(
        studies = listOf(
            StudyUiState(
                logoUrl = "",
                name = context.getString(R.string.test_1_word),
                diploma = context.getString(R.string.test_short_text_1_line),
                dates = Dates(Date(), null)
            ),
            StudyUiState(
                logoUrl = "",
                name = context.getString(R.string.test_1_word),
                diploma = context.getString(R.string.test_short_text_1_line),
                dates = Dates(Date(), null)
            ),
            StudyUiState(
                logoUrl = "",
                name = context.getString(R.string.test_1_word),
                diploma = context.getString(R.string.test_short_text_1_line),
                dates = Dates(Date(), null)
            )
        )
    )
}
