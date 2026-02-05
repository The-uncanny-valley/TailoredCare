package com.uncannyvalley.tailoredcare.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.uncannyvalley.tailoredcare.data.local.entity.OwnerEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface OwnerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(owner: OwnerEntity): Long

    @Update
    suspend fun update(owner: OwnerEntity)

    @Delete
    suspend fun delete(owner: OwnerEntity)

    @Query("SELECT * FROM owners WHERE id = :id")
    suspend fun getById(id: Long): OwnerEntity?

    @Query("SELECT * FROM owners ORDER BY fullName")
    fun observeOwners(): Flow<List<OwnerEntity>>
}