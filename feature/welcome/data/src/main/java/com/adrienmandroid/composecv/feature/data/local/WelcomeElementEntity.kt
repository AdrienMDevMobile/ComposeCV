package com.adrienmandroid.composecv.feature.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "welcome_elements")
data class WelcomeElementEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0, // Auto-incrementing primary key

    val type: String,

    // Fields for WelcomeText, BirthdayText, WelcomeQuote
    val value: String? = null,
    val style: TypographyLocalEntity? = null,
    val iconId: Int? = null,

    val clickableType: String? = null,
    val clickableValue: String? = null,

    // Fields for WelcomeImage
    val imageResId: Int? = null,
    val imageDescription: String? = null,
    val tint: Boolean = false,
)
