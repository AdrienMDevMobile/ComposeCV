package com.adrienmandroid.composecv.feature.experience

import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.adrienmandroid.composecv.model.Experience
import com.adrienmandroid.composecv.data.impl.ExperienceRepositoryImpl
import com.adrienmandroid.composecv.core.ui.theme.ComposeCVTheme
import com.adrienmandroid.composecv.feature.experience.ui.elements.ExperienceCard

@Composable
fun ExperienceFragment(experiences: List<Experience>) {
    ExperiencesList(experiences = experiences)
}

@Composable
fun ExperiencesList(experiences: List<Experience>) {
    LazyColumn(modifier = Modifier.background(MaterialTheme.colors.background)) {
        items(items = experiences) {
            ExperienceCard(experience = it)
        }
    }
}

@Composable
@Preview
fun PrevExpFragment() {
    ComposeCVTheme {
        ExperienceFragment(ExperienceRepositoryImpl().getExperiences())
    }
}