package com.uncannyvalley.tailoredcare.domain.model

import java.time.LocalDateTime

data class Appointment(
    val id: Long = 0L,
    val medicalCardId: Long,
    val doctorId: Long,
    val appointmentDateTime: LocalDateTime,
    val reason: String?,
    val status: AppointmentStatus
)
