package com.adrienmandroid.composecv.feature.other.domain.model

sealed interface OtherComponent {
    class Hobbies(val hobbies: List<Hobby>) : OtherComponent
    class Quotes(val quotes: List<Quote>) : OtherComponent
    class Studies(val studies: List<Study>) : OtherComponent
    class Version(val version: VersionName) : OtherComponent
    class Gratitude(val value: String) : OtherComponent
}