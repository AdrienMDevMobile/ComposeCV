package com.adrienmandroid.composecv.feature.other.preview.data

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.adrienmandroid.composecv.core.test.R
import com.adrienmandroid.composecv.model.Dates
import com.adrienmandroid.composecv.model.Study
import java.util.Date

class StudyPreviewParameterProvider : PreviewParameterProvider<List<Study>> {
    override val values: Sequence<List<Study>>
        get() = sequenceOf(StudyPreviewParameterData.studies)
}

object StudyPreviewParameterData {
    internal val studies = listOf(
        Study(
            R.drawable.ic_test,
            R.string.test_1_word,
            R.string.test_short_text_1_line,
            Dates(Date(), null)
        ),
        Study(
            R.drawable.ic_test,
            R.string.test_1_word,
            R.string.test_short_text_1_line,
            Dates(Date(), null)
        ),
        Study(
            R.drawable.ic_test,
            R.string.test_1_word,
            R.string.test_short_text_1_line,
            Dates(Date(), null)
        )
    )
}
