package com.uncannyvalley.tailoredcare.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.uncannyvalley.tailoredcare.data.local.entity.AppointmentEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AppointmentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(appointment: AppointmentEntity): Long

    @Update
    suspend fun update(appointment: AppointmentEntity)

    @Delete
    suspend fun delete(appointment: AppointmentEntity)

    @Query("""
        SELECT * FROM appointments
        WHERE medicalCardId = :cardId
        ORDER BY appointmentDateTime DESC
    """)
    fun observeByCard(cardId: Long): Flow<List<AppointmentEntity>>

    @Query("""
        SELECT * FROM appointments
        WHERE doctorId = :doctorId
        ORDER BY appointmentDateTime
    """)
    fun observeByDoctor(doctorId: Long): Flow<List<AppointmentEntity>>
}