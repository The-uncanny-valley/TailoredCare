package com.uncannyvalley.tailoredcare.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.uncannyvalley.tailoredcare.data.local.entity.VaccinationEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface VaccinationDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vaccination: VaccinationEntity): Long

    @Update
    suspend fun update(vaccination: VaccinationEntity)

    @Delete
    suspend fun delete(vaccination: VaccinationEntity)

    @Query("""
        SELECT * FROM vaccinations
        WHERE medicalCardId = :cardId
        ORDER BY vaccinationDate DESC
        """)
    fun observeByCard(cardId: Long): Flow<List<VaccinationEntity>>

    @Query("""
        SELECT * FROM vaccinations
        WHERE medicalCardId = :cardId AND type = :type
        ORDER BY vaccinationDate DESC
        LIMIT 1
    """)
    suspend fun getLastByType(
        cardId: Long,
        type: String
    ): VaccinationEntity?

}