package com.adrienmandroid.composecv.ui.skill

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.delay

@Composable
fun SkillLinearProgressIndicator(targetValue : Float) {
    var progress by remember { mutableStateOf(0f) }
    val animatedProgress = animateFloatAsState(
        targetValue = progress,
        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
    ).value

    Column(horizontalAlignment = Alignment.CenterHorizontally) {

        Text("Name of the skill")
        LinearProgressIndicator(progress = animatedProgress, color = getSkillColor(targetValue),
            backgroundColor = MaterialTheme.colors.background)
    }

    LaunchedEffect(key1 = Unit, block = {
        while (progress < targetValue) progress += targetValue/10
    })

}

fun getSkillColor(targetValue: Float) = when{
    targetValue >= 0.9f -> Color.Green
    targetValue >= 0.7f -> Color.Yellow
    else -> Color.Red
    }


@Composable
@Preview
fun previewSkillBar(){
    SkillLinearProgressIndicator(1f)
}

//https://blog.stylingandroid.com/compose-ui-snapshot-testing/ testing animations frames
//https://foso.github.io/Jetpack-Compose-Playground/material/linearprogressindicator/