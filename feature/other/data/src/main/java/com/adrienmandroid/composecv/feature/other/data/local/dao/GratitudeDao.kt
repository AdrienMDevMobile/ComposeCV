package com.adrienmandroid.composecv.feature.other.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.adrienmandroid.composecv.feature.other.data.local.GratitudeLocalEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GratitudeDao {
    //TODO mark my functions as suspend : https://www.reddit.com/r/androiddev/comments/14gr3zo/what_are_the_purpose_of_having_suspend_keyword_on/
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg gratitudes: GratitudeLocalEntity)

    @Query("SELECT * FROM gratitudes")
    fun getAllAsFlow(): Flow<List<GratitudeLocalEntity>>
}