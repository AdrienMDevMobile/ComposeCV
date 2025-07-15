package com.adrienmandroid.composecv.feature.welcome.ui.element

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.adrienmandroid.composecv.core.ui.theme.ComposeCVTheme
import com.adrienmandroid.composecv.core.test.R as TestingR

@Composable
fun ImageDraw(source: Int, description: String, tint: Boolean = false) {
    Image(
        painter = painterResource(source),
        contentDescription = description,
        modifier = Modifier.size(80.dp, 80.dp),
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
            TestingR.drawable.img_test, context.getString(TestingR.string.test_1_word)
        )
    }
}