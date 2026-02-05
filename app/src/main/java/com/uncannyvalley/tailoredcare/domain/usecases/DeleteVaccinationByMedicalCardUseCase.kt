package com.uncannyvalley.tailoredcare.domain.usecases

import com.uncannyvalley.tailoredcare.domain.model.Vaccination
import com.uncannyvalley.tailoredcare.domain.repository.VaccinationRepository
import javax.inject.Inject

class DeleteVaccinationByMedicalCardUseCase @Inject constructor(
    private val repository: VaccinationRepository
) {
    suspend fun invoke(vaccination: Vaccination) =
        repository.deleteVaccination(vaccination)
}
