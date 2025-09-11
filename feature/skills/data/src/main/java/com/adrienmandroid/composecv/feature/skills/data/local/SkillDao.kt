package com.adrienmandroid.composecv.feature.skills.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface SkillDao {
    @Insert(onConflict = OnConflictStrategy.Companion.REPLACE)
    fun insertAll(vararg users: Skill)

    @Query("SELECT * FROM skills")
    fun getAllAsFlow(): Flow<List<Skill>>
    /*
        @Delete
        fun delete(user: SkillData)*/
}