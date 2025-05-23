package com.adrienmandroid.composecv.feature.other.ui.elements

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.adrienmandroid.composecv.feature.other.R

@Composable
fun Version() {
    Text(
        text = stringResource(R.string.version, "TODO"/*TODO BuildConfig.VERSION_NAME*/),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 5.dp),
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.body2
    )
}