package com.uncannyvalley.tailoredcare.presentation.state

import com.uncannyvalley.tailoredcare.presentation.model.PetCardUiModel

data class HomeUiState(
    val petCards: List<PetCardUiModel> = emptyList(),
    val showAddButtonOnly: Boolean = true
)
