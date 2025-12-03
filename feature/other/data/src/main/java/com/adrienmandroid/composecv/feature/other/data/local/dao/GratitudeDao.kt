package com.adrienmandroid.composecv.feature.other.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.adrienmandroid.composecv.feature.other.data.local.GratitudeLocalEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GratitudeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg gratitudes: GratitudeLocalEntity)

    @Query("SELECT * FROM gratitudes")
    fun getAllAsFlow(): Flow<List<GratitudeLocalEntity>>
}