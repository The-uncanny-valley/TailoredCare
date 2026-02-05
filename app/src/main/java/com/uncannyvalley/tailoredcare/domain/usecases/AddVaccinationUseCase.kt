package com.uncannyvalley.tailoredcare.domain.usecases

import com.uncannyvalley.tailoredcare.domain.model.Vaccination
import com.uncannyvalley.tailoredcare.domain.repository.VaccinationRepository
import javax.inject.Inject

class AddVaccinationUseCase @Inject constructor(
    private val repository: VaccinationRepository
) {
    suspend operator fun invoke(vaccination: Vaccination) {
        repository.addVaccination(vaccination)
    }
}