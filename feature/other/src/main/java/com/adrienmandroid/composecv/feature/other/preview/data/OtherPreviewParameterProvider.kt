package com.adrienmandroid.composecv.feature.other.preview.data

import androidx.compose.ui.tooling.preview.PreviewParameterProvider


class OtherPreviewParameterProvider : PreviewParameterProvider<OtherParams> {
    override val values: Sequence<OtherParams>
        get() = sequenceOf(
            OtherParams(
                studies = StudyPreviewParameterData.studies,
                quotes = QuotePreviewParameterData.quotes,
                hobbies = HobbyPreviewParameterData.hobbies,
            )
        )
}