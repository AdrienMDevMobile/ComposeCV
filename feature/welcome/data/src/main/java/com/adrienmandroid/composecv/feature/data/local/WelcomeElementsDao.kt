package com.adrienmandroid.composecv.feature.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow

@Dao
interface WelcomeElementsDao {
    @Transaction
    @Query("SELECT * FROM welcome_elements")
    fun getAllWelcomeElementsAsFlow(): Flow<List<WelcomeElementEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllWelcomeElements(vararg elements: WelcomeElementEntity)
}