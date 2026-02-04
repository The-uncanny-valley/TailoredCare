package com.uncannyvalley.tailoredcare.data.repository

import com.uncannyvalley.tailoredcare.data.local.dao.VaccinationDao
import com.uncannyvalley.tailoredcare.data.mappers.toDomain
import com.uncannyvalley.tailoredcare.data.mappers.toEntity
import com.uncannyvalley.tailoredcare.domain.model.Vaccination
import com.uncannyvalley.tailoredcare.domain.model.VaccineType
import com.uncannyvalley.tailoredcare.domain.repository.VaccinationRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class VaccinationRepositoryImpl(
    private val vaccinationDao: VaccinationDao
) : VaccinationRepository {
    override fun observeByCard(cardId: Long): Flow<List<Vaccination>> =
        vaccinationDao.observeByCard(cardId)
            .map { list -> list.map { it.toDomain() } }


    override suspend fun getLastByType(
        cardId: Long,
        type: VaccineType
    ): Vaccination? = vaccinationDao.getLastByType(cardId, type.name)?.toDomain()


    override suspend fun addVaccination(vaccination: Vaccination) {
        vaccinationDao.insert(vaccination.toEntity())
    }

    override suspend fun updateVaccination(vaccination: Vaccination) {
        vaccinationDao.update(vaccination.toEntity())
    }

    override suspend fun deleteVaccination(vaccination: Vaccination) {
        vaccinationDao.delete(vaccination.toEntity())
    }

}
