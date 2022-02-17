package com.adrienmandroid.composecv.ui.fragments

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.adrienmandroid.composecv.ui.theme.ComposeCVTheme

@Composable
fun ExperienceFragment() {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Yellow), contentAlignment = Alignment.Center,
    ){
        Text(text="Expérience")
    }
}

@Composable
@Preview
fun previewExp(){
    ComposeCVTheme {
        ExperienceFragment()
    }
}