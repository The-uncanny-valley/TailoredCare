package com.uncannyvalley.tailoredcare.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.uncannyvalley.tailoredcare.data.local.entity.MedicalRecordEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MedicalRecordDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entry: MedicalRecordEntity): Long

    @Update
    suspend fun update(entry: MedicalRecordEntity)

    @Delete
    suspend fun delete(entry: MedicalRecordEntity)

    @Query("""
        SELECT * FROM medical_records
        WHERE medicalCardId = :cardId
        ORDER BY visitDate DESC
    """)
    fun observeByCard(cardId: Long): Flow<List<MedicalRecordEntity>>
}