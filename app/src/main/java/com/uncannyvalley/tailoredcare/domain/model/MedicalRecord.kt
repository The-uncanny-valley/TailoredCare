package com.uncannyvalley.tailoredcare.domain.model

import java.time.LocalDate

data class MedicalRecord(
    val id: Long = 0L,
    val medicalCardId: Long,
    val visitDate: LocalDate,
    val complaints: String?,
    val diagnosis: String?,
    val treatment: String?,
    val recommendations: String?,
    val doctorName: String
)
