package com.uncannyvalley.tailoredcare.domain.model

import java.time.LocalDate

data class MedicalCard(
    val id: Long = 0L,
    val ownerId: Long,
    val petName: String,
    val petType: PetType,
    val breed: String?,
    val gender: Gender,
    val birthDate: LocalDate?,
    val weightKg: Double?,
    val isSterilized: Boolean,
    val origin: String?,
    val chipNumber: String?,
    val createdAt: LocalDate,
    val imageUri: String? = null
)
