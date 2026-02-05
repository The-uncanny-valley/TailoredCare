package com.uncannyvalley.tailoredcare.data.repository

import com.uncannyvalley.tailoredcare.data.local.dao.MedicalCardDao
import com.uncannyvalley.tailoredcare.data.mappers.toDomain
import com.uncannyvalley.tailoredcare.data.mappers.toEntity
import com.uncannyvalley.tailoredcare.domain.model.MedicalCard
import com.uncannyvalley.tailoredcare.domain.repository.MedicalCardRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MedicalCardRepositoryImpl @Inject constructor(
    private val medicalCardDao: MedicalCardDao
) : MedicalCardRepository {

    override fun observeMedicalCards(): Flow<List<MedicalCard>> =
        medicalCardDao.observeAll()
            .map { list -> list.map { it.toDomain() } }

    override fun observeMedicalCardByOwner(ownerId: Long): Flow<List<MedicalCard>> =
        medicalCardDao.observeByOwner(ownerId)
            .map { list -> list.map { it.toDomain() } }

    override suspend fun getMedicalCardById(id: Long): MedicalCard? =
        medicalCardDao.getById(id)?.toDomain()

    override suspend fun addMedicalCard(card: MedicalCard) {
        medicalCardDao.insert(card.toEntity())
    }

    override suspend fun updateMedicalCard(card: MedicalCard) {
        medicalCardDao.update(card.toEntity())
    }

    override suspend fun deleteMedicalCard(card: MedicalCard) {
        medicalCardDao.delete(card.toEntity())
    }
}