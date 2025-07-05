package com.adrienmandroid.composecv.feature.experience.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.adrienmandroid.composecv.data.R
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
        Experience(name = R.string.exp_off_name,
            employer = R.string.exp_astek_employer,
            logo = R.drawable.ic_exp_astek,
            expDates = Dates(begin = Date(1730075200000), end = null),
            professional = true,
            informations = listOf(
                ExperienceInformation(R.string.exp_info_off),
                ExperienceInformation(R.string.exp_info_off_autonomous),
            )
        ),
        Experience(name = R.string.exp_off_name,
            employer = R.string.exp_astek_employer,
            logo = R.drawable.ic_exp_astek,
            expDates = Dates(begin = Date(1730075200000), end = null),
            professional = true,
            informations = listOf(
                ExperienceInformation(R.string.exp_info_off),
                ExperienceInformation(R.string.exp_info_off_autonomous),
            )
        ),
        Experience(name = R.string.exp_off_name,
            employer = R.string.exp_astek_employer,
            logo = R.drawable.ic_exp_astek,
            expDates = Dates(begin = Date(1730075200000), end = null),
            professional = true,
            informations = listOf(
                ExperienceInformation(R.string.exp_info_off),
                ExperienceInformation(R.string.exp_info_off_autonomous),
            )
        ),
    )
}