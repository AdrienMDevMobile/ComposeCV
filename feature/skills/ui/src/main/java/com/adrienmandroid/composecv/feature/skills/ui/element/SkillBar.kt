package com.adrienmandroid.composecv.feature.skills.ui.element

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ProgressIndicatorDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.text
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.adrienmandroid.composecv.core.ui.theme.colorSkillHigh
import com.adrienmandroid.composecv.core.ui.theme.colorSkillLow
import com.adrienmandroid.composecv.core.ui.theme.colorSkillMedium

@Composable
fun SkillBar(
    percentageString: String,
    targetValue: Float,
    targetValueColor: Color
) {
    Box(
        modifier = Modifier
            .semantics(mergeDescendants = true) {
            }
            .clearAndSetSemantics {
                text = AnnotatedString(percentageString)
            }
    ) {
        SkillLinearProgressIndicator(targetValue, targetValueColor)
        Text(text = percentageString, modifier = Modifier.align(Alignment.CenterEnd))
    }
}

@Composable
private fun SkillLinearProgressIndicator(
    targetValue: Float,
    targetValueColor: Color
) {
    var progress by remember { mutableFloatStateOf(0f) }
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

@Composable
@PreviewLightDark
fun PreviewSkillBarHigh() {
    SkillBar("100%", 1f, colorSkillHigh)
}

@Composable
@PreviewLightDark
fun PreviewSkillBarMid() {
    SkillBar("70%", 0.7f, colorSkillMedium)
}

@Composable
@PreviewLightDark
fun PreviewSkillBarLow() {
    SkillBar("10%", 0.1f, colorSkillLow)
}

@Composable
@Preview
fun PreviewBarProgressOnly() {
    SkillLinearProgressIndicator(1f, colorSkillHigh)
}
//https://blog.stylingandroid.com/compose-ui-snapshot-testing/ testing animations frames
//https://foso.github.io/Jetpack-Compose-Playground/material/linearprogressindicator/