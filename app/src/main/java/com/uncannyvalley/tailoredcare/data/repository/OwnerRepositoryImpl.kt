package com.uncannyvalley.tailoredcare.data.repository

import com.uncannyvalley.tailoredcare.data.local.dao.OwnerDao
import com.uncannyvalley.tailoredcare.data.mappers.toDomain
import com.uncannyvalley.tailoredcare.data.mappers.toEntity
import com.uncannyvalley.tailoredcare.domain.model.Owner
import com.uncannyvalley.tailoredcare.domain.repository.OwnerRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class OwnerRepositoryImpl @Inject constructor(
    private val ownerDao: OwnerDao
) : OwnerRepository {

    override fun observeOwners(): Flow<List<Owner>> =
        ownerDao.observeOwners()
            .map { list -> list.map { it.toDomain() } }

    override suspend fun getOwnerById(id: Long): Owner? =
        ownerDao.getById(id)?.toDomain()

    override suspend fun addOwner(owner: Owner): Long =
        ownerDao.insert(owner.toEntity())

    override suspend fun updateOwner(owner: Owner) {
        ownerDao.update(owner.toEntity())
    }

    override suspend fun deleteOwner(owner: Owner) {
        ownerDao.delete(owner.toEntity())
    }
}
