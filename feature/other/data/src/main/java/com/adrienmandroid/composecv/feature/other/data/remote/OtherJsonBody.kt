package com.adrienmandroid.composecv.feature.other.data.remote

data class OtherJsonBody(
    val hobbies: List<HobbyRemoteBody>,
    val studies: List<StudyRemoteBody>,
    val quotes: List<QuoteRemoteBody>,
    //val gratitude: String
)