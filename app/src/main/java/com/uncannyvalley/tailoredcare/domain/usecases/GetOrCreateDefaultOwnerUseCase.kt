package com.uncannyvalley.tailoredcare.domain.usecases

import com.uncannyvalley.tailoredcare.domain.model.Owner
import com.uncannyvalley.tailoredcare.domain.repository.OwnerRepository
import javax.inject.Inject

class GetOrCreateDefaultOwnerUseCase @Inject constructor(
    private val ownerRepository: OwnerRepository
) {
    suspend operator fun invoke(): Owner {
        val defaultOwnerId = 1L
        val existingOwner = ownerRepository.getOwnerById(defaultOwnerId)

        return existingOwner ?: run {
            val newOwner = Owner(fullName = "Me", phone = null, email = null)
            val id = ownerRepository.addOwner(newOwner)
            ownerRepository.getOwnerById(id)!!
        }
    }
}
