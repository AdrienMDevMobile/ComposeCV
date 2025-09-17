package com.adrienmandroid.composecv.feature.other.ui.state

import com.adrienmandroid.composecv.feature.other.domain.model.Hobby
import com.adrienmandroid.composecv.feature.other.domain.model.OtherComponent
import com.adrienmandroid.composecv.feature.other.domain.model.Quote
import com.adrienmandroid.composecv.feature.other.domain.model.Study
import com.adrienmandroid.composecv.feature.other.ui.state.OtherComponentUiState.GratitudeUiState
import com.adrienmandroid.composecv.feature.other.ui.state.OtherComponentUiState.HobbyUiStates
import com.adrienmandroid.composecv.feature.other.ui.state.OtherComponentUiState.QuoteUiStates
import com.adrienmandroid.composecv.feature.other.ui.state.OtherComponentUiState.StudyUiStates
import com.adrienmandroid.composecv.feature.other.ui.state.OtherComponentUiState.VersionUiState

fun OtherComponent.toUiState() =
    when (this) {
        is OtherComponent.Hobbies ->
            HobbyUiStates(
                this.hobbies.map { hobby ->
                    hobby.toUiState()
                }
            )

        is OtherComponent.Gratitude -> GratitudeUiState(this.value)
        is OtherComponent.Quotes -> QuoteUiStates(
            this.quotes.mapIndexed { index, quote -> quote.toUiState(index) }
        )

        is OtherComponent.Studies -> StudyUiStates(
            this.studies.map { study -> study.toUiState() }
        )

        is OtherComponent.Version -> VersionUiState(
            this.version
        )
    }

fun Hobby.toUiState() = HobbyUiState(
    name = name,
    pictureUrl = pictureUrl,
    category = category,
)

fun Quote.toUiState(position: Int) = QuoteUiState(
    text = text,
    author = author,
    imageUrl = imageUrl,
    textPosition = if (position % 2 == 0) TextPosition.LEFT else TextPosition.RIGHT
)

fun Study.toUiState() = StudyUiState(
    logoUrl = logoUrl,
    name = name,
    diploma = diploma,
    dates = dates,
    isLongString = isLongString,
)