package com.adrienmandroid.composecv.feature.other.ui.preview.data

import android.content.Context
import com.adrienmandroid.composecv.core.test.R
import com.adrienmandroid.composecv.model.Dates
import com.adrienmandroid.composecv.model.Study
import java.util.Date

class StudyPreviewParameterData(
    context: Context,
) {
    internal val studies = listOf(
        Study(
            R.drawable.ic_test,
            context.getString(R.string.test_1_word),
            context.getString(R.string.test_short_text_1_line),
            Dates(Date(), null)
        ),
        Study(
            R.drawable.ic_test,
            context.getString(R.string.test_1_word),
            context.getString(R.string.test_short_text_1_line),
            Dates(Date(), null)
        ),
        Study(
            R.drawable.ic_test,
            context.getString(R.string.test_1_word),
            context.getString(R.string.test_short_text_1_line),
            Dates(Date(), null)
        )
    )
}
