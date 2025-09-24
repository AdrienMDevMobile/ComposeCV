package com.adrienmandroid.composecv.feature.other.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "gratitudes")
data class GratitudeLocalEntity(
    @PrimaryKey(autoGenerate = true)
    val gratitudeId: Long = 0,
    @ColumnInfo(name = "text")
    val text: String,
)