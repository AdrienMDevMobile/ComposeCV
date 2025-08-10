package com.adrienmandroid.composecv.feature.experience.ui.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.adrienmandroid.composecv.core.ui.SelfLoadingPicture
import com.adrienmandroid.composecv.core.ui.theme.ComposeCVTheme
import com.adrienmandroid.composecv.core.ui.theme.onSurfaceTitle
import com.adrienmandroid.composecv.core.test.R as TestingR

@Composable
fun ExperienceHeader(logoUrl: String, name: String, professional: Boolean) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                if (professional) {
                    MaterialTheme.colors.primary
                } else {
                    MaterialTheme.colors.primaryVariant
                }
            ),
        contentAlignment = Alignment.CenterStart,
    ) {
        Row {
            SelfLoadingPicture(
                pictureUrl = logoUrl,
                contentDescription = name,
                modifier = Modifier
                    .size(50.dp)
                    .padding(expHorizontalSpacing, 0.dp),
                colorFilter = ColorFilter.tint(MaterialTheme.colors.onSurfaceTitle)
            )
            Spacer(modifier = Modifier.width(expHorizontalSpacing))
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = name,
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.onSurfaceTitle,
                textAlign = TextAlign.Center
            )
        }

    }

}

@PreviewLightDark
@Composable
fun PreviewExperienceHeader() {
    val context = LocalContext.current
    ComposeCVTheme {
        Column {
            ExperienceHeader(
                logoUrl = "",
                name = context.getString(TestingR.string.test_1_word),
                true
            )
            ExperienceHeader(
                logoUrl = "",
                name = context.getString(TestingR.string.test_1_word),
                false
            )
        }

    }
}