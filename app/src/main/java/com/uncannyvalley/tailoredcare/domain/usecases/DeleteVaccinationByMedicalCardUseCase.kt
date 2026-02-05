package com.uncannyvalley.tailoredcare.domain.usecases

import com.uncannyvalley.tailoredcare.domain.model.Vaccination
import com.uncannyvalley.tailoredcare.domain.repository.VaccinationRepository

class DeleteVaccinationByMedicalCardUseCase(
    private val repository: VaccinationRepository
) {
    suspend fun invoke(vaccination: Vaccination) =
        repository.deleteVaccination(vaccination)
}
