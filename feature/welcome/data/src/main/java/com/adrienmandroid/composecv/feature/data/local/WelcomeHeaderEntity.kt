package com.adrienmandroid.composecv.feature.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "welcome_header")
class WelcomeHeaderEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0, // Auto-incrementing primary key
    val profilePicture: String,
    val backgroundPicture: String
)