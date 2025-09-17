package com.adrienmandroid.composecv.feature.other.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.adrienmandroid.composecv.feature.other.data.local.QuoteLocalEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface QuoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg quotes: QuoteLocalEntity)

    @Query("SELECT * FROM quotes")
    fun getAllAsFlow(): Flow<List<QuoteLocalEntity>>
}