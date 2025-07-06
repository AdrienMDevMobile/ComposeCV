package com.adrienmandroid.composecv.feature.other.preview.data

import android.content.Context

class OtherPreviewParameterData(
    private val context: Context,
) {
    internal val values: OtherParams
        get() = OtherParams(
            studies = StudyPreviewParameterData(context).studies,
            quotes = QuotePreviewParameterData.quotes,
            hobbies = HobbyPreviewParameterData(context).hobbies,
            gratitude = "Gratitude Lorem ipsum",
            versionName = "1.0.0-test"
        )
}