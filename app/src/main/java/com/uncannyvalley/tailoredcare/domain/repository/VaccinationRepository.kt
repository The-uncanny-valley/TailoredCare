package com.uncannyvalley.tailoredcare.domain.repository

import com.uncannyvalley.tailoredcare.domain.model.Vaccination
import com.uncannyvalley.tailoredcare.domain.model.VaccineType
import kotlinx.coroutines.flow.Flow

interface VaccinationRepository {

    fun observeByCard(cardId: Long): Flow<List<Vaccination>>

    suspend fun getLastByType(cardId: Long, type: VaccineType): Vaccination?

    suspend fun addVaccination(vaccination: Vaccination)

    suspend fun updateVaccination(vaccination: Vaccination)

    suspend fun deleteVaccination(vaccination: Vaccination)
}