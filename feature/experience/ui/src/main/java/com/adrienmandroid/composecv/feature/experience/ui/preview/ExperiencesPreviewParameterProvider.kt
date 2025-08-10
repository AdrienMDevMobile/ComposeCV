package com.adrienmandroid.composecv.feature.experience.ui.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.adrienmandroid.composecv.feature.experience.domain.model.Experience
import com.adrienmandroid.composecv.feature.experience.domain.model.ExperienceInformation
import com.adrienmandroid.composecv.model.Dates
import java.util.Date

class ExperiencesPreviewParameterProvider :
    PreviewParameterProvider<Experience> {
    override val values: Sequence<Experience>
        get() = ExperiencesPreviewParameterData.experiences.asSequence()
}

object ExperiencesPreviewParameterData {
    internal val experiences = listOf(
        Experience(
            name = "Lorem ipsum",
            employer = "Employeur Lorem ipsum",
            logoUrl = "",
            expDates = Dates(begin = Date(1730075200000), end = null),
            professional = true,
            informations = listOf(
                ExperienceInformation("Lorem <b>ipsum</b>"),
                ExperienceInformation("Lorem ipsum"),
            )
        ),
        Experience(
            name = "Lorem ipsum",
            employer = "Employeur Lorem ipsum",
            logoUrl = "",
            expDates = Dates(begin = Date(1730075200000), end = Date(1730075200000)),
            professional = true,
            informations = listOf(
                ExperienceInformation("Lorem ipsum"),
                ExperienceInformation("Lorem <b>ipsum</b>"),
            )
        ),
        Experience(
            name = "Lorem ipsum",
            employer = "Employeur Lorem ipsum",
            logoUrl = "",
            expDates = Dates(begin = Date(1730075200000), end = Date(1730075200000)),
            professional = true,
            informations = listOf(
                ExperienceInformation("Lorem ipsum"),
                ExperienceInformation("Lorem ipsum"),
            )
        ),
    )
}