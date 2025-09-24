package com.adrienmandroid.composecv.feature.other.ui.preview.data

import android.content.Context
import com.adrienmandroid.composecv.feature.other.ui.state.OtherComponentUiState

class OtherPreviewParameterData(
    context: Context,
) {
    internal val others = listOf(
        StudyPreviewParameterData(context).studies,
        HobbyPreviewParameterData(context).hobbies,
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