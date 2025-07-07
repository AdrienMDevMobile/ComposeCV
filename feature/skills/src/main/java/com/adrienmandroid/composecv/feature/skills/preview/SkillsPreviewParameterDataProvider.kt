package com.adrienmandroid.composecv.feature.skills.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import com.adrienmandroid.composecv.model.Skill

class SkillsPreviewParameterDataProvider : PreviewParameterProvider<Skill> {
    override val values: Sequence<Skill>
        get() = SkillsPreviewParameterData.skills.asSequence()
}

object SkillsPreviewParameterData {
    internal val skills = listOf(
        Skill(
            name = "Lorem ipsum",
            targetValue = 0.8f,
            explanation = LoremIpsum(words = 50).values.toList().joinToString(separator = " "),
        ),
        Skill(
            name = "Lorem ipsum",
            targetValue = 0.7f,
            explanation = LoremIpsum(words = 50).values.toList().joinToString(separator = " "),
        ),
        Skill(
            name = "Lorem ipsum",
            targetValue = 0.1f,
            explanation = LoremIpsum(words = 50).values.toList().joinToString(separator = " "),
        ),
        Skill(
            name = "Lorem ipsum",
            subSkills = Pair("Lorem ipsum", "Lorem ipsum"),
            explanation = LoremIpsum(words = 50).values.toList().joinToString(separator = " "),
        ),
    )
}