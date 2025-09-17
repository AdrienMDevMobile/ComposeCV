package com.adrienmandroid.composecv.feature.other.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.adrienmandroid.composecv.feature.other.data.local.HobbyLocalEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface HobbyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg hobbies: HobbyLocalEntity)

    @Query("SELECT * FROM hobbies")
    fun getAllAsFlow(): Flow<List<HobbyLocalEntity>>
}