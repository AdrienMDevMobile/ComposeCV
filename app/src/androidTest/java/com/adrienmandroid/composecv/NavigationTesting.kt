package com.adrienmandroid.composecv

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.adrienmandroid.composecv.TestActivity
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
        Thread.sleep(5000)
    }
}