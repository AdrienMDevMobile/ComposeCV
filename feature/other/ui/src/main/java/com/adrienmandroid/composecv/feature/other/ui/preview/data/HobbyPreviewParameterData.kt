package com.adrienmandroid.composecv.feature.other.ui.preview.data

import android.content.Context
import com.adrienmandroid.composecv.core.test.R
import com.adrienmandroid.composecv.feature.other.ui.state.HobbyUiState
import com.adrienmandroid.composecv.feature.other.ui.state.OtherComponentUiState

class HobbyPreviewParameterData(
    context: Context,
) {
    internal val hobbies = OtherComponentUiState.HobbyUiStates(
        listOf(
            HobbyUiState(
                name = context.getString(R.string.test_short_text_1_line),
                pictureUrl = "",
                category = context.getString(R.string.test_1_word),
            ),
            HobbyUiState(
                name = context.getString(R.string.test_short_text_1_line),
                pictureUrl = "",
                category = context.getString(R.string.test_1_word),
            ),
            HobbyUiState(
                name = context.getString(R.string.test_short_text_1_line),
                pictureUrl = "",
                category = context.getString(R.string.test_1_word),
            )
        )
    )
}