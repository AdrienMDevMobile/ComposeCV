package com.adrienmandroid.composecv.feature.other.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quotes")
data class QuoteLocalEntity(
    @PrimaryKey(autoGenerate = true)
    val quoteId: Long = 0,
    @ColumnInfo(name = "text")
    val text: String,
    @ColumnInfo(name = "author")
    val author: String,
    @ColumnInfo(name = "image_url")
    val imageUrl: String
)