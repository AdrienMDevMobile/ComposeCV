package com.adrienmandroid.composecv.feature.other.ui.preview.data

import com.adrienmandroid.composecv.feature.other.ui.state.OtherComponentUiState
import com.adrienmandroid.composecv.feature.other.ui.state.StudyUiState
import com.adrienmandroid.composecv.model.Dates
import java.util.Date

class StudyPreviewParameterData {
    internal val studies = OtherComponentUiState.StudyUiStates(
        studies = listOf(
            StudyUiState(
                logoUrl = "",
                name = "Name study 1",
                diploma = "Name diploma 1",
                dates = Dates(Date(), null)
            ),
            StudyUiState(
                logoUrl = "",
                name = "Name study 2",
                diploma = "Name diploma 2",
                dates = Dates(Date(), null)
            ),
            StudyUiState(
                logoUrl = "",
                name = "Name study 3",
                diploma = "Name diploma 3",
                dates = Dates(Date(), null)
            )
        )
    )
}
