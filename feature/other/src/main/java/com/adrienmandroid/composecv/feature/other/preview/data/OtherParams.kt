package com.adrienmandroid.composecv.feature.other.preview.data

import com.adrienmandroid.composecv.model.Hobby
import com.adrienmandroid.composecv.model.Quote
import com.adrienmandroid.composecv.model.Study
import com.adrienmandroid.composecv.model.VersionName

class OtherParams(
    val studies: List<Study>,
    val quotes: List<Quote>,
    val hobbies: List<Hobby>,
    val gratitude: String,
    val versionName: VersionName,
)