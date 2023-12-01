package com.example.utaronew.data.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.utaronew.data.room.entities.GoroscopListEntities
import kotlinx.coroutines.flow.Flow

@Dao
interface GoroscopListDao {

    //@Query("SELECT * FROM GoroscopListEntities")
   // fun findAll(): Flow<List<GoroscopListEntities>>



    @Query("SELECT * FROM GoroscopListEntities")
    fun findAll(): Flow<List<GoroscopListEntities>>

    @Query("SELECT `desc` FROM GoroscopListEntities WHERE name=:name")
    suspend fun findDesc(name: String): String

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(goro: GoroscopListEntities);

    @Query("DELETE FROM GoroscopListEntities")
    suspend fun deleteAll()
}