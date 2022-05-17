package com.adrienmandroid.composecv.ui.skill

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.material.ProgressIndicatorDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
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

    Column(horizontalAlignment = Alignment.CenterHorizontally) {

        Text("Name of the skill")
        SegmentedProgressIndicator(progress = animatedProgress, color = getSkillColor(targetValue))
    }

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
    targetValue >= 0.9f -> colorSkillHigh
    targetValue >= 0.7f -> colorSkillMedium
    else -> colorSkillLow
}


@Composable
@Preview
fun PreviewSkillBar() {
    SkillLinearProgressIndicator(1f)
}

//https://blog.stylingandroid.com/compose-ui-snapshot-testing/ testing animations frames
//https://foso.github.io/Jetpack-Compose-Playground/material/linearprogressindicator/