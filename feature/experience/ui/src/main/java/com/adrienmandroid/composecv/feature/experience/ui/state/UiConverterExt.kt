package com.adrienmandroid.composecv.feature.experience.ui.state

import androidx.compose.ui.unit.dp
import com.adrienmandroid.composecv.core.ui.getDifferenceInts
import com.adrienmandroid.composecv.core.ui.theme.colorDarkerGreen
import com.adrienmandroid.composecv.core.ui.theme.colorLighterGreen
import com.adrienmandroid.composecv.feature.experience.domain.model.Experience

fun Experience.toUiState() = ExperienceUiState(
    name = name,
    employer = employer,
    logoUrl = logoUrl,
    dateBegin = expDates.begin,
    dateEnd = expDates.end,
    expDuration = expDates.getDifferenceInts(),
    headerColor = if (professional) {
        colorLighterGreen
    } else {
        colorDarkerGreen
    },
    headerElevation = if (professional) {
        6.dp
    } else {
        2.dp
    },
    informations = informations.map { name }
)