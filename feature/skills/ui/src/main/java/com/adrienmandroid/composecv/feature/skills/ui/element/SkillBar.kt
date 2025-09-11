package com.adrienmandroid.composecv.feature.skills.ui.element

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ProgressIndicatorDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.adrienmandroid.composecv.core.ui.theme.colorSkillHigh
import com.adrienmandroid.composecv.core.ui.theme.colorSkillLow
import com.adrienmandroid.composecv.core.ui.theme.colorSkillMedium

@Composable
fun SkillLinearProgressIndicator(
    targetValue: Float,
    targetValueColor: Color
) {
    var progress by remember { mutableStateOf(0f) }
    val animatedProgress = animateFloatAsState(
        targetValue = progress,
        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
    ).value

    SegmentedProgressIndicator(
        progress = animatedProgress,
        color = targetValueColor,
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp)),
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

//TODO : PreviewParameter for only 1 test function
@Composable
@PreviewLightDark
fun PreviewSkillBarHigh() {
    SkillLinearProgressIndicator(1f, colorSkillHigh)
}

@Composable
@PreviewLightDark
fun PreviewSkillBarMid() {
    SkillLinearProgressIndicator(0.7f, colorSkillMedium)
}

@Composable
@PreviewLightDark
fun PreviewSkillBarLow() {
    SkillLinearProgressIndicator(0.1f, colorSkillLow)
}
//https://blog.stylingandroid.com/compose-ui-snapshot-testing/ testing animations frames
//https://foso.github.io/Jetpack-Compose-Playground/material/linearprogressindicator/