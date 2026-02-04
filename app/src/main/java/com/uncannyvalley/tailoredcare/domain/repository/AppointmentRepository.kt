package com.uncannyvalley.tailoredcare.domain.repository

import com.uncannyvalley.tailoredcare.domain.model.Appointment
import kotlinx.coroutines.flow.Flow

interface AppointmentRepository {

    fun observeByCard(cardId: Long): Flow<List<Appointment>>

    fun observeByDoctor(doctorId: Long): Flow<List<Appointment>>

    suspend fun getAppointmentById(id: Long): Appointment?

    suspend fun addAppointment(appointment: Appointment)

    suspend fun updateAppointment(appointment: Appointment)

    suspend fun deleteAppointment(appointment: Appointment)
}