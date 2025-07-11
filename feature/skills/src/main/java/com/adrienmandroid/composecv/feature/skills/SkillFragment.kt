package com.adrienmandroid.composecv.feature.skills

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.hilt.navigation.compose.hiltViewModel
import com.adrienmandroid.composecv.core.ui.theme.ComposeCVTheme
import com.adrienmandroid.composecv.feature.skills.preview.SkillsPreviewParameterData
import com.adrienmandroid.composecv.feature.skills.ui.element.SkillCard
import com.adrienmandroid.composecv.feature.skills.viewmodel.SkillViewModel
import com.adrienmandroid.composecv.model.Skill

@Composable
fun SkillFragment(
    modifier: Modifier = Modifier,
    skillViewModel: SkillViewModel = hiltViewModel(),
) {
    val skills: List<Skill> by skillViewModel.skills.observeAsState(emptyList())

    SkillPage(skills, modifier)
}

@Composable
fun SkillPage(
    skills: List<Skill>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxWidth(),
        contentPadding = WindowInsets.statusBars.asPaddingValues(),
    ) {
        items(items = skills) {
            SkillCard(it)
        }
    }
}

@PreviewLightDark
@Composable
fun PreviewSkill() {
    ComposeCVTheme {
        SkillPage(SkillsPreviewParameterData.skills)
    }
}