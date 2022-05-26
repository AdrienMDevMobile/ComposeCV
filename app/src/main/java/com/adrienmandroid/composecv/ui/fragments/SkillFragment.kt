package com.adrienmandroid.composecv.ui.fragments

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.adrienmandroid.composecv.data.Skill
import com.adrienmandroid.composecv.data.dataSource.impl.SkillDataImpl
import com.adrienmandroid.composecv.ui.skill.SkillCard
import com.adrienmandroid.composecv.ui.theme.ComposeCVTheme

@Composable
fun SkillFragment(skills: List<Skill>) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background),
        contentAlignment = Alignment.Center,
    ) {
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(items = skills) {
                SkillCard(it.name, it.targetValue, it.explanation)
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