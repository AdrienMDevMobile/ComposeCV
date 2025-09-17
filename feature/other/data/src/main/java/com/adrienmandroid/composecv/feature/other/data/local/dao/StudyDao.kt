package com.adrienmandroid.composecv.feature.other.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.adrienmandroid.composecv.feature.other.data.local.StudyLocalEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface StudyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg studies: StudyLocalEntity)

    @Query("SELECT * FROM studies")
    fun getAllAsFlow(): Flow<List<StudyLocalEntity>>
}