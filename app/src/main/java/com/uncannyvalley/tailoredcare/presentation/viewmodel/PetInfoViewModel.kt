package com.uncannyvalley.tailoredcare.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uncannyvalley.tailoredcare.domain.model.MedicalCard
import com.uncannyvalley.tailoredcare.domain.repository.MedicalCardRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class PetInfoViewModel @Inject constructor(
    private val medicalCardRepository: MedicalCardRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(PetInfoUiState())
    val uiState: StateFlow<PetInfoUiState> = _uiState.asStateFlow()

    fun loadPet(id: Long) {
        viewModelScope.launch {
            medicalCardRepository.getMedicalCardById(id)?.let { card ->
                _uiState.update { it.copy(pet = card) }
            }
        }
    }
}

data class PetInfoUiState(
    val pet: MedicalCard? = null
)
