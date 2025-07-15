package com.adrienmandroid.composecv.feature.other.ui.elements

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.adrienmandroid.composecv.core.ui.theme.ComposeCVTheme
import com.adrienmandroid.composecv.feature.other.ui.R
import com.adrienmandroid.composecv.model.VersionName

@Composable
fun Version(versionName: VersionName) {
    Text(
        text = stringResource(R.string.version, versionName),
        color = MaterialTheme.colors.onBackground,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 5.dp),
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.body2
    )
}

@PreviewLightDark
@Composable
fun PreviewVersion() {
    ComposeCVTheme {
        Version("1.0.0-Test")
    }
}