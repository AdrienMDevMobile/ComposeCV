package com.adrienmandroid.composecv.feature.other.ui.preview.data

import android.content.Context
import com.adrienmandroid.composecv.core.test.R
import com.adrienmandroid.composecv.feature.other.domain.model.Hobby

class HobbyPreviewParameterData(
    context: Context,
) {
    internal val hobbies = listOf(
        Hobby(
            name = context.getString(R.string.test_short_text_1_line),
            pictureUrl = "",
            category = context.getString(R.string.test_1_word),
        ),
        Hobby(
            name = context.getString(R.string.test_short_text_1_line),
            pictureUrl = "",
            category = context.getString(R.string.test_1_word),
        ),
        Hobby(
            name = context.getString(R.string.test_short_text_1_line),
            pictureUrl = "",
            category = context.getString(R.string.test_1_word),
        )
    )
}