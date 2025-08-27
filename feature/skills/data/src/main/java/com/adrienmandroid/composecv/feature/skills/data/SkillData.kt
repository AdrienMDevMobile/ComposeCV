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
    //UTILISER UN TYPE CONVERTER https://github.com/AdrienMDevMobile/SpendingTracker/blob/master/app/src/main/java/com/micheldr/spendingtracker/data/DateConverter.kt
    @ColumnInfo(name = "sub_skill_one")
    val subSkill_one: String? = "",
    @ColumnInfo(name = "sub_skill_two")
    val subSkill_two: String? = "",
    @ColumnInfo(name = "explanation")
    val explanation: String
)