package com.uncannyvalley.tailoredcare.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.uncannyvalley.tailoredcare.data.local.entity.MedicalCardEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MedicalCardDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(card: MedicalCardEntity): Long

    @Update
    suspend fun update(card: MedicalCardEntity)

    @Delete
    suspend fun delete(card: MedicalCardEntity)

    @Query("SELECT * FROM medical_cards WHERE id = :id")
    suspend fun getById(id: Long): MedicalCardEntity?

    @Query("SELECT * FROM medical_cards ORDER BY petName")
    fun observeALl(): Flow<List<MedicalCardEntity>>

    @Query("SELECT * FROM medical_cards WHERE ownerId = :ownerId")
    fun observerByOwner(ownerId: Long): Flow<List<MedicalCardEntity>>
}