package com.adrienmandroid.composecv.feature.other.preview.data

import android.content.Context
import com.adrienmandroid.composecv.core.test.R
import com.adrienmandroid.composecv.model.Hobby

class HobbyPreviewParameterData(
    context: Context,
) {
    internal val hobbies = listOf(
        Hobby(
            context.getString(R.string.test_short_text_1_line),
            R.drawable.img_test,
            context.getString(R.string.test_1_word),
        ),
        Hobby(
            context.getString(R.string.test_short_text_1_line),
            R.drawable.img_test,
            context.getString(R.string.test_1_word),
        ),
        Hobby(
            context.getString(R.string.test_short_text_1_line),
            R.drawable.img_test,
            context.getString(R.string.test_1_word),
        )
    )
}