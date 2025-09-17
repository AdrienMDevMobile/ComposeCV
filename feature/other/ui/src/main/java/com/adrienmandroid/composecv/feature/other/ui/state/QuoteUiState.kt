package com.adrienmandroid.composecv.feature.other.ui.state

data class QuoteUiState (
    val text: String,
    val author: String,
    val imageUrl: String,
    val textPosition: TextPosition
)

enum class TextPosition {
    LEFT, RIGHT
}