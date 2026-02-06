package com.adrienmandroid.composecv.feature.other.ui.preview.data

import com.adrienmandroid.composecv.feature.other.ui.state.HobbyUiState
import com.adrienmandroid.composecv.feature.other.ui.state.OtherComponentUiState

class HobbyPreviewParameterData {
    internal val hobbies = OtherComponentUiState.HobbyUiStates(
        listOf(
            HobbyUiState(
                name = "Name hobby 1",
                pictureUrl = "",
                category = "Category hobby 1",
            ),
            HobbyUiState(
                name = "Name hobby 2",
                pictureUrl = "",
                category = "Category hobby 2",
            ),
            HobbyUiState(
                name = "Name hobby 3",
                pictureUrl = "",
                category = "Category hobby 3",
            )
        )
    )
}