package com.adrienmandroid.composecv.feature.experience.ui.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adrienmandroid.composecv.core.ui.theme.ComposeCVTheme
import com.adrienmandroid.composecv.core.ui.toAnnotatedString
import com.adrienmandroid.composecv.model.ExperienceInformation

@Composable
fun ExperienceDetailsItem(informations: List<ExperienceInformation>) {
    Column {
        informations.forEach { information ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colors.background)
                    .padding(expHorizontalSpacing, 0.dp)
            ) {
                Text(
                    information.name.toAnnotatedString(),
                    style = MaterialTheme.typography.body1
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewExperienceDetailsItem() {
    ComposeCVTheme {
        Column {
            ExperienceDetailsItem(
                listOf(
                    ExperienceInformation("Lorem <b>ipsum</b>"),
                    ExperienceInformation("Lorem ipsum"),
                )
            )
        }
    }
}