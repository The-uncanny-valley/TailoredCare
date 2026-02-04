package com.uncannyvalley.tailoredcare.domain.repository

import com.uncannyvalley.tailoredcare.domain.model.MedicalCard
import kotlinx.coroutines.flow.Flow

interface MedicalCardRepository {

    fun observeMedicalCards(): Flow<List<MedicalCard>>

    fun observeMedicalCardByOwner(ownerId: Long): Flow<List<MedicalCard>>

    suspend fun getMedicalCardById(id: Long): MedicalCard?

    suspend fun addMedicalCard(card: MedicalCard)

    suspend fun updateMedicalCard(card: MedicalCard)

    suspend fun deleteMedicalCard(card: MedicalCard)
}