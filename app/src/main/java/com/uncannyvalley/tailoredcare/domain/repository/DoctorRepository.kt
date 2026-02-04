package com.uncannyvalley.tailoredcare.domain.repository

import com.uncannyvalley.tailoredcare.domain.model.Doctor
import kotlinx.coroutines.flow.Flow

interface DoctorRepository {

    fun observeDoctors(): Flow<List<Doctor>>

    suspend fun getDoctorById(id: Long): Doctor?

    suspend fun addDoctor(doctor: Doctor)

    suspend fun updateDoctor(doctor: Doctor)

    suspend fun deleteDoctor(doctor: Doctor)
}