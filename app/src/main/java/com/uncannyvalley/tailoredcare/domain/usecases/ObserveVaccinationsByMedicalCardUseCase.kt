package com.uncannyvalley.tailoredcare.domain.usecases

import com.uncannyvalley.tailoredcare.domain.model.Vaccination
import com.uncannyvalley.tailoredcare.domain.repository.VaccinationRepository
import kotlinx.coroutines.flow.Flow

class ObserveVaccinationsByMedicalCardUseCase(
    private val repository: VaccinationRepository
) {
    operator fun invoke(cardId: Long): Flow<List<Vaccination>> =
        repository.observeByCard(cardId)
}