package com.adrienmandroid.composecv.feature.experience.ui.elements

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.adrienmandroid.composecv.core.ui.theme.ComposeCVTheme
import com.adrienmandroid.composecv.feature.experience.ui.preview.ExperiencesPreviewParameterProvider
import com.adrienmandroid.composecv.feature.experience.ui.state.ExperienceUiState

val expHorizontalSpacing = 10.dp
val expVerticalSpacing = 10.dp

@Composable
fun ExperienceCard(experience: ExperienceUiState) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(25.dp))
            .padding(expHorizontalSpacing, expVerticalSpacing),
        elevation = experience.headerElevation,
        backgroundColor = MaterialTheme.colors.background
    )
    {
        Column(modifier = Modifier.fillMaxWidth()) {
            ExperienceHeader(experience.logoUrl, experience.name, experience.headerColor)
            ExpAdditionalInfo(
                begin = experience.dateBegin,
                end = experience.dateEnd,
                duration = experience.expDuration,
                employer = experience.employer
            )
            ExperienceDetailsItem(experience.informations)
            Spacer(modifier = Modifier.height(expVerticalSpacing))
        }
    }
}

@PreviewLightDark
@Composable
fun ExperienceCardPreview(
    @PreviewParameter(ExperiencesPreviewParameterProvider::class) experience: ExperienceUiState
) {
    ComposeCVTheme {
        ExperienceCard(experience)
    }
}


