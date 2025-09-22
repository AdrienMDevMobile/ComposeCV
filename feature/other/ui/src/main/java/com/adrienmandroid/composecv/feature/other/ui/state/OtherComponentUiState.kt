package com.adrienmandroid.composecv.feature.other.ui.state

import com.adrienmandroid.composecv.feature.other.domain.model.VersionName

sealed interface OtherComponentUiState {
    class HobbyUiStates(val hobbies: List<HobbyUiState>) : OtherComponentUiState
    class QuoteUiStates(val quotes: List<QuoteUiState>) : OtherComponentUiState
    class StudyUiStates(val studies: List<StudyUiState>) : OtherComponentUiState
    class VersionUiState(val version: VersionName) : OtherComponentUiState
    class GratitudeUiState(val values: List<String>) : OtherComponentUiState
}