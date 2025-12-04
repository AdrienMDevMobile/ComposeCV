package com.adrienmandroid.composecv.feature.other.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "studies")
data class StudyLocalEntity(
    @PrimaryKey(autoGenerate = true)
    val studyId: Long = 0,
    @ColumnInfo(name = "logo_url")
    val logoUrl: String,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "diploma")
    val diploma: String,
    @ColumnInfo(name = "date_start")
    val dateStart: String,
    @ColumnInfo(name = "date_end")
    val dateEnd: String?,
)