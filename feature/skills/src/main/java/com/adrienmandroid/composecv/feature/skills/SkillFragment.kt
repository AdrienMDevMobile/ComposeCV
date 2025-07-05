package com.adrienmandroid.composecv.feature.skills

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background),
        contentAlignment = Alignment.Center,
    ) {
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(items = skills) {
                SkillCard(it)
            }
        }
    }
}

@Composable
@Preview
fun PreviewSkill() {
    ComposeCVTheme {
        SkillPage(SkillsPreviewParameterData.skills)
    }
}