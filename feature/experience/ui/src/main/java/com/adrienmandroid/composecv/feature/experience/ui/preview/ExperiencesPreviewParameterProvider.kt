package com.adrienmandroid.composecv.feature.experience.ui.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.adrienmandroid.composecv.model.Dates
import com.adrienmandroid.composecv.feature.experience.domain.model.Experience
import com.adrienmandroid.composecv.feature.experience.domain.model.ExperienceInformation
import java.util.Date
import com.adrienmandroid.composecv.core.test.R as TestingR

class ExperiencesPreviewParameterProvider : PreviewParameterProvider<com.adrienmandroid.composecv.feature.experience.domain.model.Experience> {
    override val values: Sequence<com.adrienmandroid.composecv.feature.experience.domain.model.Experience>
        get() = ExperiencesPreviewParameterData.experiences.asSequence()
}

object ExperiencesPreviewParameterData {
    internal val experiences = listOf(
        com.adrienmandroid.composecv.feature.experience.domain.model.Experience(
            name = "Lorem ipsum",
            employer = "Employeur Lorem ipsum",
            logo = TestingR.drawable.ic_test,
            expDates = Dates(begin = Date(1730075200000), end = null),
            professional = true,
            informations = listOf(
                com.adrienmandroid.composecv.feature.experience.domain.model.ExperienceInformation("Lorem <b>ipsum</b>"),
                com.adrienmandroid.composecv.feature.experience.domain.model.ExperienceInformation("Lorem ipsum"),
            )
        ),
        com.adrienmandroid.composecv.feature.experience.domain.model.Experience(
            name = "Lorem ipsum",
            employer = "Employeur Lorem ipsum",
            logo = TestingR.drawable.ic_test,
            expDates = Dates(begin = Date(1730075200000), end = Date(1730075200000)),
            professional = true,
            informations = listOf(
                com.adrienmandroid.composecv.feature.experience.domain.model.ExperienceInformation("Lorem ipsum"),
                com.adrienmandroid.composecv.feature.experience.domain.model.ExperienceInformation("Lorem <b>ipsum</b>"),
            )
        ),
        com.adrienmandroid.composecv.feature.experience.domain.model.Experience(
            name = "Lorem ipsum",
            employer = "Employeur Lorem ipsum",
            logo = TestingR.drawable.ic_test,
            expDates = Dates(begin = Date(1730075200000), end = Date(1730075200000)),
            professional = true,
            informations = listOf(
                com.adrienmandroid.composecv.feature.experience.domain.model.ExperienceInformation("Lorem ipsum"),
                com.adrienmandroid.composecv.feature.experience.domain.model.ExperienceInformation("Lorem ipsum"),
            )
        ),
    )
}