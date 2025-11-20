package com.adrienmandroid.composecv.feature.other.data.remote

import com.adrienmandroid.composecv.feature.other.data.remote.elements.GratitudeRemoteBody
import com.adrienmandroid.composecv.feature.other.data.remote.elements.HobbyRemoteBody
import com.adrienmandroid.composecv.feature.other.data.remote.elements.QuoteRemoteBody
import com.adrienmandroid.composecv.feature.other.data.remote.elements.StudyRemoteBody
import kotlinx.serialization.Serializable

@Serializable
data class OtherJsonBody(
    val hobbies: List<HobbyRemoteBody>,
    val studies: List<StudyRemoteBody>,
    val quotes: List<QuoteRemoteBody>,
    val gratitudes: List<GratitudeRemoteBody>
)