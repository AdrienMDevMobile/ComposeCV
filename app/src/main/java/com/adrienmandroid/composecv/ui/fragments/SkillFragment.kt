package com.adrienmandroid.composecv.ui.fragments

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.adrienmandroid.composecv.ui.skill.SkillLinearProgressIndicator
import com.adrienmandroid.composecv.ui.theme.ComposeCVTheme

@Composable
fun SkillFragment() {
    Box(modifier = Modifier.fillMaxSize().background(Color.White), contentAlignment = Alignment.Center,
    ){
        Column(){
            SkillLinearProgressIndicator(0.9f)
            SkillLinearProgressIndicator(0.7f)
            SkillLinearProgressIndicator(0.5f)
        }

    }
}

@Composable
@Preview
fun previewSkill(){
    ComposeCVTheme {
        SkillFragment()
    }
}