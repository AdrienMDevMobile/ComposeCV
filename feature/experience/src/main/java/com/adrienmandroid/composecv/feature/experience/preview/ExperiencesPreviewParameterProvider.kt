package com.adrienmandroid.composecv.feature.experience.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.adrienmandroid.composecv.model.Dates
import com.adrienmandroid.composecv.model.Experience
import com.adrienmandroid.composecv.model.ExperienceInformation
import java.util.Date
import com.adrienmandroid.composecv.core.test.R as TestingR

class ExperiencesPreviewParameterProvider : PreviewParameterProvider<Experience> {
    override val values: Sequence<Experience>
        get() = ExperiencesPreviewParameterData.experiences.asSequence()
}

object ExperiencesPreviewParameterData {
    internal val experiences = listOf(
        Experience(name = "Lorem ipsum",
            employer = "Lorem ipsum",
            logo = TestingR.drawable.ic_test,
            expDates = Dates(begin = Date(1730075200000), end = null),
            professional = true,
            informations = listOf(
                ExperienceInformation("Lorem ipsum"),
                ExperienceInformation("Lorem ipsum"),
            )
        ),
        Experience(name = "Lorem ipsum",
            employer = "Lorem ipsum",
            logo = TestingR.drawable.ic_test,
            expDates = Dates(begin = Date(1730075200000), end = Date(1730075200000)),
            professional = true,
            informations = listOf(
                ExperienceInformation("Lorem ipsum"),
                ExperienceInformation("Lorem ipsum"),
            )
        ),
        Experience(name = "Lorem ipsum",
            employer = "Lorem ipsum",
            logo = TestingR.drawable.ic_test,
            expDates = Dates(begin = Date(1730075200000), end = Date(1730075200000)),
            professional = true,
            informations = listOf(
                ExperienceInformation("Lorem ipsum"),
                ExperienceInformation("Lorem ipsum"),
            )
        ),
    )
}