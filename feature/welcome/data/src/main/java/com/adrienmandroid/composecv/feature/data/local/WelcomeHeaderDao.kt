package com.adrienmandroid.composecv.feature.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface WelcomeHeaderDao {
    @Query("SELECT * FROM welcome_header LIMIT 1")
    fun getAllWelcomeHeaderAsFlow(): Flow<WelcomeHeaderEntity?>
    //TODO v3 delete all before inserting new
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWelcomeHeader(element: WelcomeHeaderEntity)
}