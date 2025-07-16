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
import com.adrienmandroid.composecv.feature.experience.domain.model.Experience

val expHorizontalSpacing = 10.dp
val expVerticalSpacing = 10.dp

@Composable
fun ExperienceCard(experience: com.adrienmandroid.composecv.feature.experience.domain.model.Experience) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(25.dp))
            .padding(expHorizontalSpacing, expVerticalSpacing),
        elevation = if (experience.professional) {
            6.dp
        } else {
            2.dp
        },
        backgroundColor = MaterialTheme.colors.background
    )
    {
        Column(modifier = Modifier.fillMaxWidth()) {
            ExperienceHeader(experience.logo, experience.name, experience.professional)
            ExpAdditionalInfo(experience.expDates, experience.employer, experience.link)
            ExperienceDetailsItem(experience.informations)
            Spacer(modifier = Modifier.height(expVerticalSpacing))
        }
    }
}

@PreviewLightDark
@Composable
fun ExperienceCardPreview(
    @PreviewParameter(ExperiencesPreviewParameterProvider::class) experience: com.adrienmandroid.composecv.feature.experience.domain.model.Experience
) {
    ComposeCVTheme {
        ExperienceCard(experience)
    }
}


