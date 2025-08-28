package com.adrienmandroid.composecv.feature.skills.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "skills")
data class SkillData(
    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "target_value")
    val targetValue: Float? = null,
    @ColumnInfo(name = "sub_skill_one")
    val subSkillOne: String? = "",
    @ColumnInfo(name = "sub_skill_two")
    val subSkillTwo: String? = "",
    @ColumnInfo(name = "explanation")
    val explanation: String
)