package com.uncannyvalley.tailoredcare.domain.usecases

import com.uncannyvalley.tailoredcare.domain.model.Vaccination
import com.uncannyvalley.tailoredcare.domain.repository.VaccinationRepository

class AddVaccinationUseCase(
    private val repository: VaccinationRepository
) {
    suspend operator fun invoke(vaccination: Vaccination) {
        repository.addVaccination(vaccination)
    }
}