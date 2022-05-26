package com.adrienmandroid.composecv.ui.fragments

import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.adrienmandroid.composecv.data.Experience
import com.adrienmandroid.composecv.data.dataSource.impl.ExperienceDataImpl
import com.adrienmandroid.composecv.ui.experience.ExperienceCard
import com.adrienmandroid.composecv.ui.theme.ComposeCVTheme

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
        ExperienceFragment(ExperienceDataImpl().getExperiences())
    }
}