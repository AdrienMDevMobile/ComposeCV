package com.adrienmandroid.composecv.feature.welcome.ui.element

import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.adrienmandroid.composecv.core.ui.SelfLoadingPicture
import com.adrienmandroid.composecv.core.ui.theme.ComposeCVTheme
import com.adrienmandroid.composecv.core.test.R as TestingR

@Composable
fun ImageDraw(source: String, description: String, tint: Boolean = false) {
    SelfLoadingPicture(
        pictureUrl = source,
        contentDescription = description,
        modifier = Modifier.size(80.dp, 80.dp),
        contentScale = ContentScale.Fit,
        colorFilter = if (tint) {
            ColorFilter.tint(MaterialTheme.colors.onBackground)
        } else {
            null
        }
    )
}

@Composable
@PreviewLightDark
fun PreviewImageDraw() {
    val context = LocalContext.current
    ComposeCVTheme {
        ImageDraw(
            "", context.getString(TestingR.string.test_1_word)
        )
    }
}
