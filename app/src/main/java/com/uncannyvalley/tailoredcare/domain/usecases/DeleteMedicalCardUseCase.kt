package com.uncannyvalley.tailoredcare.domain.usecases

import com.uncannyvalley.tailoredcare.domain.model.MedicalCard
import com.uncannyvalley.tailoredcare.domain.repository.MedicalCardRepository
import javax.inject.Inject

class DeleteMedicalCardUseCase @Inject constructor(
    private val repository: MedicalCardRepository
) {
    suspend operator fun invoke(card: MedicalCard) =
        repository.deleteMedicalCard(card)
}