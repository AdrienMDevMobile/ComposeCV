package com.adrienmandroid.composecv.feature.other.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "hobbies")
data class HobbyLocalEntity(
    @PrimaryKey(autoGenerate = true)
    val hobbyId: Long = 0, // Primary key for the experience
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "picture_url")
    val pictureUrl: String,
    @ColumnInfo(name = "category")
    val category: String
)