package com.adrienmandroid.composecv.ui.skill

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ProgressIndicatorDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adrienmandroid.composecv.ui.theme.colorSkillHigh
import com.adrienmandroid.composecv.ui.theme.colorSkillLow
import com.adrienmandroid.composecv.ui.theme.colorSkillMedium

@Composable
fun SkillLinearProgressIndicator(targetValue: Float) {
    var progress by remember { mutableStateOf(0f) }
    val animatedProgress = animateFloatAsState(
        targetValue = progress,
        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
    ).value

    SegmentedProgressIndicator(
        progress = animatedProgress,
        color = getSkillColor(targetValue),
        modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(10.dp)),
        progressHeight = 20.dp
    )

    LaunchedEffect(key1 = Unit, block = {
        while (progress < targetValue) {
            val addition = progress + targetValue / 10
            progress = if (addition > 1f) {
                1f
            } else {
                addition
            }
        }
    })
}

fun getSkillColor(targetValue: Float) = when {
    targetValue >= 0.8f -> colorSkillHigh
    targetValue >= 0.6f -> colorSkillMedium
    else -> colorSkillLow
}


@Composable
@Preview
fun PreviewSkillBar() {
    SkillLinearProgressIndicator(1f)
}

//https://blog.stylingandroid.com/compose-ui-snapshot-testing/ testing animations frames
//https://foso.github.io/Jetpack-Compose-Playground/material/linearprogressindicator/