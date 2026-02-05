package com.uncannyvalley.tailoredcare.domain.usecases

import com.uncannyvalley.tailoredcare.domain.model.MedicalCard
import com.uncannyvalley.tailoredcare.domain.repository.MedicalCardRepository

class DeleteMedicalCardUseCase(
    private val repository: MedicalCardRepository
) {
    suspend operator fun invoke(card: MedicalCard) =
        repository.deleteMedicalCard(card)
}