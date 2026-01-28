package com.adrienmandroid.composecv.experiences.ui

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
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
    fun test_experience_exists() {
        val viewmodel = ExperienceViewmodel(FakeExperienceRepository())
        // Start the app
        composeTestRule.setContent {
            ComposeCVTheme {
                ExperienceScreen(experienceViewmodel = viewmodel)
            }
        }
        //Thread.sleep(5000)

        composeTestRule.onNodeWithText("Experience 3").assertExists()
    }
}