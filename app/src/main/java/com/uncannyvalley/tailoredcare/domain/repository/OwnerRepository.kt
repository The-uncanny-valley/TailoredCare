package com.uncannyvalley.tailoredcare.domain.repository

import com.uncannyvalley.tailoredcare.domain.model.Owner
import kotlinx.coroutines.flow.Flow

interface OwnerRepository {

    fun observeOwners(): Flow<List<Owner>>

    suspend fun getOwnerById(id: Long): Owner?

    suspend fun addOwner(owner: Owner)

    suspend fun updateOwner(owner: Owner)

    suspend fun deleteOwner(owner: Owner)
}