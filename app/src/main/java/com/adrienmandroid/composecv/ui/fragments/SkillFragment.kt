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
import com.adrienmandroid.composecv.data.Skill
import com.adrienmandroid.composecv.ui.skill.SkillBox
import com.adrienmandroid.composecv.data.SkillData
import com.adrienmandroid.composecv.ui.theme.ComposeCVTheme

@Composable
fun SkillFragment(skills : List<Skill>) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black), contentAlignment = Alignment.Center,
    ){
        Column() {
            for (skill in skills) {
                SkillBox(skill.name, skill.targetValue, skill.explanation)
            }
        }
    }

}

@Composable
@Preview
fun PreviewSkill(){
    ComposeCVTheme() {
        SkillFragment(SkillData.skills)
    }
}