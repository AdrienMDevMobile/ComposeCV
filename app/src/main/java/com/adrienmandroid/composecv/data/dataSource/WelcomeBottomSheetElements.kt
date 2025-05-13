package com.adrienmandroid.composecv.data.dataSource

import com.adrienmandroid.composecv.model.welcome.WelcomeElement

interface WelcomeBottomSheetElements {
    fun listOfItemInBottomSheet(): List<WelcomeElement>
}