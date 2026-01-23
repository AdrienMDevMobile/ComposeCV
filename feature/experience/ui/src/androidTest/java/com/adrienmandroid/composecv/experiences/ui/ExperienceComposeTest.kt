package com.adrienmandroid.composecv.experiences.ui

import androidx.compose.ui.test.junit4.createComposeRule
import com.adrienmandroid.composecv.core.ui.theme.ComposeCVTheme
import com.adrienmandroid.composecv.feature.experience.ui.ExperienceScreen
import com.adrienmandroid.composecv.feature.experience.ui.viewmodel.ExperienceViewmodel
import org.junit.Rule
import org.junit.Test

//https://developer.android.com/develop/ui/compose/testing
class ExperienceComposeTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    @Test
    fun myTest() {
        // Start the app
        composeTestRule.setContent {
            ComposeCVTheme {
                ExperienceScreen(experienceViewmodel = ExperienceViewmodel(FakeExperienceRepository()))
            }
            Thread.sleep(500)
        }

        //composeTestRule.onNodeWithText("Continue").performClick()

        //composeTestRule.onNodeWithText("Welcome").assertIsDisplayed()
    }
}