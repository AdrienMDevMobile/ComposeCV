package com.adrienmandroid.composecv.feature.other.ui.elements

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.adrienmandroid.composecv.core.ui.theme.ComposeCVTheme
import com.adrienmandroid.composecv.feature.other.ui.R
import com.adrienmandroid.composecv.core.test.R as TestingR

fun LazyListScope.otherSection(
    composable: @Composable () -> Unit,
    @StringRes title: Int? = null,
    firstElement: Boolean = false
) {
    item {
        Column(modifier = Modifier.fillMaxWidth()) {
            val spacingTop = when (firstElement) {
                true -> 20.dp
                false -> 10.dp
            }
            Spacer(modifier = Modifier.height(spacingTop))
            if (title != null) {
                Text(
                    text = stringResource(title),
                    color = MaterialTheme.colors.onBackground,
                    style = MaterialTheme.typography.body1,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 5.dp)
                )
                Spacer(modifier = Modifier.height(5.dp))
            }
            composable()
        }
    }
}

@Composable
@PreviewLightDark
fun PreviewOtherSection() {
    ComposeCVTheme {
        LazyColumn {
            otherSection(
                { Gratitudes(stringResource(TestingR.string.test_long_text_3_lines)) },
                title = R.string.title_gratitude
            )
        }
    }
}