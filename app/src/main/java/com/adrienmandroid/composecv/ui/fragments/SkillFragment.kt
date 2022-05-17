package com.adrienmandroid.composecv.ui.fragments

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adrienmandroid.composecv.data.Skill
import com.adrienmandroid.composecv.data.dataSource.impl.SkillDataImpl
import com.adrienmandroid.composecv.ui.skill.SkillBox
import com.adrienmandroid.composecv.ui.theme.ComposeCVTheme
import com.adrienmandroid.composecv.ui.theme.composableBackground

@Composable
fun SkillFragment(skills: List<Skill>) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.composableBackground),
        contentAlignment = Alignment.Center,
    ) {
        Column(modifier = Modifier.fillMaxWidth().padding(15.dp)) {
            for (skill in skills) {
                SkillBox(skill.name, skill.targetValue, skill.explanation)
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}

@Composable
@Preview
fun PreviewSkill() {
    ComposeCVTheme() {
        SkillFragment(SkillDataImpl().getSkills())
    }
}