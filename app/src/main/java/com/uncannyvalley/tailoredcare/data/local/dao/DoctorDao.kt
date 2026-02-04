package com.uncannyvalley.tailoredcare.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.uncannyvalley.tailoredcare.data.local.entity.DoctorEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DoctorDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(doctor: DoctorEntity): Long // ? why Long

    @Update
    suspend fun update(doctor: DoctorEntity)

    @Delete
    suspend fun delete(doctor: DoctorEntity)

    @Query("SELECT * FROM doctors ORDER BY fullName")
    fun observeDoctors(): Flow<List<DoctorEntity>>
}