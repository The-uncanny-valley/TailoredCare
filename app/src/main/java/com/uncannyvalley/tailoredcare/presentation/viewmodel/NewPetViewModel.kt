package com.uncannyvalley.tailoredcare.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uncannyvalley.tailoredcare.domain.model.Gender
import com.uncannyvalley.tailoredcare.domain.model.MedicalCard
import com.uncannyvalley.tailoredcare.domain.model.PetType
import com.uncannyvalley.tailoredcare.domain.usecases.AddMedicalCardUseCase
import com.uncannyvalley.tailoredcare.domain.usecases.GetOrCreateDefaultOwnerUseCase
import com.uncannyvalley.tailoredcare.presentation.state.NewPetUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

//@HiltViewModel
//class NewPetViewModel @Inject constructor(
//    private val addMedicalCardUseCase: AddMedicalCardUseCase
//) : ViewModel() {
//
//    var currentStep by mutableIntStateOf(1)
//        private set
//
//    val maxStep = 3
//
//    var petName by mutableStateOf("")
//    var petType by mutableStateOf(PetType.CAT)
//    var gender by mutableStateOf(Gender.FEMALE)
//    var birthDate by mutableStateOf<LocalDate?>(null)
//    var breed by mutableStateOf("")
//    var weight by mutableStateOf<Double?>(null)
//    var isSterilized by mutableStateOf(false)
//    var origin by mutableStateOf("") // change later
//    var chipNumber by mutableStateOf("")
//    var imageUri by mutableStateOf<String?>(null)
//
//    var lastComplexVaccinationDate by mutableStateOf<LocalDate?>(null)
//    var lastRabiesVaccinationDate by mutableStateOf<LocalDate?>(null)
//    var lastAppointmentDate by mutableStateOf<LocalDate?>(null)
//
//    fun nextStep() {
//        if (currentStep < maxStep) currentStep++
//    }
//
//    fun prevStep() {
//        if (currentStep > 1) currentStep--
//    }
//
//    suspend fun savePet() {
//        val medicalCard = MedicalCard(
//            id = 0L,
//            ownerId = 0L,
//            petName = petName,
//            petType = petType,
//            breed = breed.takeIf { it.isNotBlank() },
//            gender = gender,
//            birthDate = birthDate,
//            weightKg = weight,
//            isSterilized = isSterilized,
//            origin = origin.takeIf { it.isNotBlank() },
//            chipNumber = chipNumber.takeIf { it.isNotBlank() },
//            createdAt = LocalDate.now(),
//            imageUri = imageUri,
//        )
//
//        addMedicalCardUseCase(medicalCard)
//    }
//}

@HiltViewModel
class NewPetViewModel @Inject constructor(
    private val addMedicalCardUseCase: AddMedicalCardUseCase,
    private val getOrCreateDefaultOwnerUseCase: GetOrCreateDefaultOwnerUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(NewPetUiState())
    val uiState: StateFlow<NewPetUiState> = _uiState.asStateFlow()

    fun nextStep() {
        _uiState.update {
            if (it.currentStep < it.maxStep) it.copy(currentStep = it.currentStep + 1)
            else it
        }
    }

    fun prevStep() {
        _uiState.update {
            if (it.currentStep > 1) it.copy(currentStep = it.currentStep - 1)
            else it
        }
    }

    fun updateImageUri(value: String?) =
        _uiState.update { it.copy(imageUri = value) }

    fun updatePetName(value: String) =
        _uiState.update { it.copy(petName = value) }

    fun updatePetType(value: PetType) =
        _uiState.update { it.copy(petType = value) }

    fun updateGender(value: Gender) =
        _uiState.update { it.copy(gender = value) }

    fun updateBirthDate(value: LocalDate?) =
        _uiState.update { it.copy(birthDate = value) }

    fun updateBreed(value: String) =
        _uiState.update { it.copy(breed = value) }

    fun updateWeight(value: Double?) =
        _uiState.update { it.copy(weight = value) }

    fun updateSterilized(value: Boolean) =
        _uiState.update { it.copy(isSterilized = value) }

    fun updateOrigin(value: String) =
        _uiState.update { it.copy(origin = value) }

    fun updateChipNumber(value: String) =
        _uiState.update { it.copy(chipNumber = value) }

    fun updateLastComplexVaccinationDate(value: LocalDate?) =
        _uiState.update { it.copy(lastComplexVaccinationDate = value) }

    fun updateLastRabiesVaccinationDate(value: LocalDate?) =
        _uiState.update { it.copy(lastRabiesVaccinationDate = value) }

    fun updateLastAppointmentDate(value: LocalDate?) =
        _uiState.update { it.copy(lastAppointmentDate = value) }

    fun savePet() {
        viewModelScope.launch {
            _uiState.update { it.copy(isSaving = true, error = null) }

            val state = uiState.value

            val owner = getOrCreateDefaultOwnerUseCase()

            val medicalCard = MedicalCard(
                id = 0L,
                ownerId = owner.id,
                petName = state.petName,
                petType = state.petType,
                breed = state.breed.takeIf { it.isNotBlank() },
                gender = state.gender,
                birthDate = state.birthDate,
                weightKg = state.weight,
                isSterilized = state.isSterilized,
                origin = state.origin.takeIf { it.isNotBlank() },
                chipNumber = state.chipNumber.takeIf { it.isNotBlank() },
                createdAt = LocalDate.now(),
                imageUri = state.imageUri
            )

            addMedicalCardUseCase(medicalCard)

            _uiState.update { it.copy(isSaving = false) }
        }
    }
}
