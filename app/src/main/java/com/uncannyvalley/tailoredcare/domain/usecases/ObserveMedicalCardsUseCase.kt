package com.uncannyvalley.tailoredcare.domain.usecases

import com.uncannyvalley.tailoredcare.domain.model.MedicalCard
import com.uncannyvalley.tailoredcare.domain.repository.MedicalCardRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ObserveMedicalCardsUseCase @Inject constructor(
    private val repository: MedicalCardRepository
) {
    operator fun invoke(): Flow<List<MedicalCard>> =
        repository.observeMedicalCards()
}

/*
This logic is for vet clinic staff. However, it's used in client's app
for now for simplicity. Later ObserveMedicalCardsByOwnerUseCase will be
introduced.
*/