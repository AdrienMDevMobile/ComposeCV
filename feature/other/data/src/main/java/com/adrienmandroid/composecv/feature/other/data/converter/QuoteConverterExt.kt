package com.adrienmandroid.composecv.feature.other.data.converter

import com.adrienmandroid.composecv.feature.other.data.local.QuoteLocalEntity
import com.adrienmandroid.composecv.feature.other.data.remote.QuoteRemoteBody
import com.adrienmandroid.composecv.feature.other.domain.model.Quote

fun QuoteLocalEntity.toDomain() = Quote(
    text = this.text,
    author = this.author,
    imageUrl = this.imageUrl
)

fun Quote.toLocalEntity() = QuoteLocalEntity(
    text = this.text,
    author = this.author,
    imageUrl = this.imageUrl
)

fun QuoteRemoteBody.toDomain() = Quote(
    text = text,
    author = author,
    imageUrl = imageUrl,
)