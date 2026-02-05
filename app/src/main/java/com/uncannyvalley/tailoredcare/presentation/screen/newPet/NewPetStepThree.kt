package com.uncannyvalley.tailoredcare.presentation.screen.newPet

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import com.uncannyvalley.tailoredcare.presentation.state.NewPetUiState
import com.uncannyvalley.tailoredcare.presentation.viewmodel.NewPetViewModel

@Composable
fun NewPetStepThree(
    state: NewPetUiState,
    viewModel: NewPetViewModel
) {
    Column {
        TextField(
            value = state.petName,
            onValueChange = viewModel::updatePetName,
            label = { Text("Pet name") }
        )

        // Pet type selector
        // Gender selector
        // Date picker
    }
}
