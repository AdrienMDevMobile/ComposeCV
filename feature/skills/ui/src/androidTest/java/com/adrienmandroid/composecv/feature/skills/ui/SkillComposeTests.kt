package com.adrienmandroid.composecv.feature.skills.ui

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.printToLog
import com.adrienmandroid.composecv.core.ui.theme.ComposeCVTheme
import com.adrienmandroid.composecv.feature.skills.ui.di.FakeSkillRepository
import com.adrienmandroid.composecv.feature.skills.ui.element.showMoreTestTag
import com.adrienmandroid.composecv.feature.skills.ui.viewmodel.SkillViewModel
import org.junit.Rule
import org.junit.Test

class SkillComposeTests {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun test_skill_exists() {
        val viewmodel = SkillViewModel(FakeSkillRepository())

        composeTestRule.setContent {
            ComposeCVTheme {
                SkillScreen(skillViewModel = viewmodel)
            }
        }
        // composeTestRule.onRoot(useUnmergedTree = true).printToLog("currentLabelExists")

        composeTestRule.onNodeWithText("Skill 1 value").assertExists()
        composeTestRule.onNodeWithText("Skill 2 subskills").assertExists()
    }

    @Test
    fun test_skill_extend_button() {
        val viewmodel = SkillViewModel(FakeSkillRepository(showAll = false))

        composeTestRule.setContent {
            ComposeCVTheme {
                SkillScreen(skillViewModel = viewmodel)
            }
        }

        composeTestRule.onRoot(useUnmergedTree = true).printToLog("currentLabelExists")

        composeTestRule.onNodeWithText("Explanation 1").assertDoesNotExist()
        //Utiliser string ressource et AndroidComposeRule
        composeTestRule.onNodeWithTag(showMoreTestTag, useUnmergedTree = true).performClick()
        composeTestRule.onNodeWithText("Explanation 1").assertExists()
        composeTestRule.onNodeWithTag(showMoreTestTag, useUnmergedTree = true).performClick()
        composeTestRule.onNodeWithText("Explanation 1").assertDoesNotExist()
    }
}