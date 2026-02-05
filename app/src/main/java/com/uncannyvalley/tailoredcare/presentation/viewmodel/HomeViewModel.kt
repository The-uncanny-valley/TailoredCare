package com.uncannyvalley.tailoredcare.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uncannyvalley.tailoredcare.domain.usecases.ObserveMedicalCardsUseCase
import com.uncannyvalley.tailoredcare.presentation.mapper.toUiModel
import com.uncannyvalley.tailoredcare.presentation.state.HomeUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach

import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val observeMedicalCardsUseCase: ObserveMedicalCardsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        observeMedicalCards()
    }

    private fun observeMedicalCards() {
        observeMedicalCardsUseCase()
            .map { cards ->
                val petCardUiModels = cards.map { it.toUiModel() }
                HomeUiState(
                    petCards = petCardUiModels,
                    showAddButtonOnly = petCardUiModels.isEmpty()
                )
            }
            .onEach { state ->
                _uiState.value = state
            }
            .launchIn(viewModelScope)
    }
}