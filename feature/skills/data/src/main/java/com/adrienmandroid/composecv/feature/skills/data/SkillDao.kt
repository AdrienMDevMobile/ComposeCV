package com.adrienmandroid.composecv.feature.skills.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface SkillDao {
    //Comment savoir si la BDD a été initialisée ?
    @Query("SELECT * FROM skills")
    fun getAll(): LiveData<List<SkillData>>


    @Insert(onConflict = OnConflictStrategy.Companion.REPLACE)
    fun insertAll(vararg users: SkillData)
/*
    @Delete
    fun delete(user: SkillData)*/
}