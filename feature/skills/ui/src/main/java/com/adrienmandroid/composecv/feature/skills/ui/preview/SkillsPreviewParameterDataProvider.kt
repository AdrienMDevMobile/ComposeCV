package com.adrienmandroid.composecv.feature.skills.ui.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import com.adrienmandroid.composecv.core.ui.theme.colorSkillHigh
import com.adrienmandroid.composecv.core.ui.theme.colorSkillLow
import com.adrienmandroid.composecv.feature.skills.ui.state.SkillUiState

class SkillsPreviewParameterDataProvider : PreviewParameterProvider<SkillUiState> {
    override val values: Sequence<SkillUiState>
        get() = SkillsPreviewParameterData.skills.asSequence()
}

object SkillsPreviewParameterData {
    internal val skills = listOf(
        SkillUiState(
            name = "Lorem ipsum",
            targetValue = 0.8f,
            targetValueColor = colorSkillHigh,
            explanation = LoremIpsum(words = 50).values.toList().joinToString(separator = " "),
        ),
        SkillUiState(
            name = "Lorem ipsum",
            targetValue = 0.7f,
            targetValueColor = colorSkillHigh,
            explanation = LoremIpsum(words = 50).values.toList().joinToString(separator = " "),
        ),
        SkillUiState(
            name = "Lorem ipsum",
            targetValue = 0.1f,
            targetValueColor = colorSkillLow,
            explanation = LoremIpsum(words = 50).values.toList().joinToString(separator = " "),
        ),
        SkillUiState(
            name = "Lorem ipsum",
            subSkills = Pair("Lorem ipsum", "Lorem ipsum"),
            explanation = LoremIpsum(words = 50).values.toList().joinToString(separator = " "),
        ),
    )
}