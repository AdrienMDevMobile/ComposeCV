package com.adrienmandroid.composecv.feature.other.preview.data

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.adrienmandroid.composecv.core.test.R
import com.adrienmandroid.composecv.model.Hobby

class HobbyPreviewParameterProvider : PreviewParameterProvider<List<Hobby>> {
    override val values: Sequence<List<Hobby>>
        get() = sequenceOf(
            HobbyPreviewParameterData.hobbies
        )
}

object HobbyPreviewParameterData {
    internal val hobbies = listOf(
        Hobby(
            R.string.test_short_text_1_line,
            R.drawable.img_test,
            R.string.test_1_word,
        ),
        Hobby(
            R.string.test_short_text_1_line,
            R.drawable.img_test,
            R.string.test_1_word,
        ),
        Hobby(
            R.string.test_short_text_1_line,
            R.drawable.img_test,
            R.string.test_1_word,
        )
    )
}