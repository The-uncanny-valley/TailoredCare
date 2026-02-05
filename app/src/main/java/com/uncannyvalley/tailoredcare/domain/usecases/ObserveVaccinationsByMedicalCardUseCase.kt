package com.uncannyvalley.tailoredcare.domain.usecases

import com.uncannyvalley.tailoredcare.domain.model.Vaccination
import com.uncannyvalley.tailoredcare.domain.repository.VaccinationRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ObserveVaccinationsByMedicalCardUseCase @Inject constructor(
    private val repository: VaccinationRepository
) {
    operator fun invoke(cardId: Long): Flow<List<Vaccination>> =
        repository.observeByCard(cardId)
}