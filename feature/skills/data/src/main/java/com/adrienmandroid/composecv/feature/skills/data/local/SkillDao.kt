package com.adrienmandroid.composecv.feature.skills.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface SkillDao {
    //Comment savoir si la BDD a été initialisée ?
    @Query("SELECT * FROM skills")
    fun getAll(): LiveData<List<Skill>>


    @Insert(onConflict = OnConflictStrategy.Companion.REPLACE)
    fun insertAll(vararg users: Skill)
/*
    @Delete
    fun delete(user: SkillData)*/
}