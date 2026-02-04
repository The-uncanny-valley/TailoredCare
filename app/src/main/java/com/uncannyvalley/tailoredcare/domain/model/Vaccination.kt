package com.uncannyvalley.tailoredcare.domain.model

import java.time.LocalDate

data class Vaccination(
    val id: Long = 0L,
    val medicalCardId: Long,
    val type: VaccineType,
    val vaccinationDate: LocalDate,
    val nextVaccinationDate: LocalDate?,
    val notes: String?
)
