package com.adrienmandroid.composecv.feature.other.ui.preview.data

import com.adrienmandroid.composecv.feature.other.ui.state.OtherComponentUiState

class OtherPreviewParameterData {
    internal val others = listOf(
        StudyPreviewParameterData().studies,
        HobbyPreviewParameterData().hobbies,
        QuotePreviewParameterData.quotes,
        OtherComponentUiState.GratitudeUiState(
            listOf(
                "Gratitude Lorem ipsum 1",
                "Gratitude Lorem ipsum 2"
            )
        ),
        OtherComponentUiState.VersionUiState("X.X.X-test")
    )
}