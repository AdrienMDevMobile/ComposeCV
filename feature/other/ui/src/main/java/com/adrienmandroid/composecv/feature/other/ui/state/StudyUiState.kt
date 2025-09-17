package com.adrienmandroid.composecv.feature.other.ui.state

import com.adrienmandroid.composecv.model.Dates

data class StudyUiState(
    val logoUrl: String,
    val name: String,
    val diploma: String,
    val dates: Dates,
    //TODO remplacer par la taille du texte
    val isLongString: Boolean = false
)