package com.adrienmandroid.composecv.feature.other.preview.data

import android.content.Context


class OtherPreviewParameterData(
    private val context: Context,
) {
    internal val values: OtherParams
        get() = OtherParams(
            studies = StudyPreviewParameterData.studies,
            quotes = QuotePreviewParameterData.quotes,
            hobbies = HobbyPreviewParameterData(context).hobbies,
            gratitude = "Gratitude Lorem ipsum"
        )

}