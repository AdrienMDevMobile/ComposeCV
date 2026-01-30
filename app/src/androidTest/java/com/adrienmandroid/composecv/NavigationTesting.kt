package com.adrienmandroid.composecv

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.test.hasClickAction
import androidx.compose.ui.test.hasContentDescription
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.printToLog
import com.adrienmandroid.composecv.feature.experience.ui.EXPERIENCE_SCREEN_ID
import com.adrienmandroid.composecv.feature.welcome.ui.WELCOME_SCREEN_ID
import com.adrienmandroid.composecv.ui.MainScreen
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class NavigationTesting {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<TestActivity>()

    @OptIn(ExperimentalMaterialApi::class)
    @Test
    fun test_navigation() {
        composeTestRule.setContent {
            MainScreen()
        }

        composeTestRule.onNode(
            hasTestTag(WELCOME_SCREEN_ID)
        ).assertExists()

        composeTestRule.onNode(
            hasTestTag(EXPERIENCE_SCREEN_ID)
        ).assertDoesNotExist()

        composeTestRule.onNode(
            hasContentDescription("EXP.")
                    and hasClickAction()
        ).performClick()

        composeTestRule.onNode(
            hasTestTag(EXPERIENCE_SCREEN_ID)
        ).assertExists()

        composeTestRule.onNode(
            hasTestTag(WELCOME_SCREEN_ID)
        ).assertDoesNotExist()

        composeTestRule.onRoot(useUnmergedTree = true).printToLog("currentLabelExists")
        //Thread.sleep(5000)
    }
}