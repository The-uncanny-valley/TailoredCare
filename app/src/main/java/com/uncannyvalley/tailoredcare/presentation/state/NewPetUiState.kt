package com.uncannyvalley.tailoredcare.presentation.state

import com.uncannyvalley.tailoredcare.domain.model.Gender
import com.uncannyvalley.tailoredcare.domain.model.PetType
import java.time.LocalDate

data class NewPetUiState(
    val currentStep: Int = 1,
    val maxStep: Int = 3,

    // step 1
    val imageUri: String? = null,
    val petName: String = "",
    val petType: PetType = PetType.CAT,
    val gender: Gender = Gender.FEMALE,
    val birthDate: LocalDate? = null,
    val breed: String = "",

    // step 2
    val isSterilized: Boolean = false,
    val weight: Double? = null,
    val origin: String = "",
    val chipNumber: String = "",

    // step 3
    val lastComplexVaccinationDate: LocalDate? = null,
    val lastRabiesVaccinationDate: LocalDate? = null,
    val lastAppointmentDate: LocalDate? = null,

    val isSaving: Boolean = false,
    val error: String? = null,
) {

    val isStepValid: Boolean
        get() = when (currentStep) {
            1 -> petName.isNotBlank()
            2 -> true
            3 -> true
            else -> false
        }
}
