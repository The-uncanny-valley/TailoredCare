package com.uncannyvalley.tailoredcare.presentation.screen.newPet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.uncannyvalley.tailoredcare.domain.model.PetType
import com.uncannyvalley.tailoredcare.presentation.components.RoundedDropdownField
import com.uncannyvalley.tailoredcare.presentation.components.RoundedTextField
import com.uncannyvalley.tailoredcare.presentation.state.NewPetUiState
import com.uncannyvalley.tailoredcare.presentation.viewmodel.NewPetViewModel

@Composable
fun NewPetStepTwo(
    state: NewPetUiState,
    viewModel: NewPetViewModel,
    onNext: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .padding(36.dp)
    ) {
        Text(
            text = "Weight",
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(modifier = Modifier.height(7.dp))

        RoundedTextField(
            value = state.weight?.toString() ?: "",
            onValueChange = { newValue ->
                val weight = newValue.toDoubleOrNull()
                viewModel.updateWeight(weight)
            },
            placeholder = "Enter weight in kg"
        )

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "Origin",
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(modifier = Modifier.height(7.dp))

        RoundedTextField(
            value = state.origin,
            onValueChange = viewModel::updateOrigin,
            placeholder = "For example, picked up on the street"
        )

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "Chip number",
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(modifier = Modifier.height(7.dp))

        RoundedTextField(
            value = state.chipNumber,
            onValueChange = viewModel::updateChipNumber,
            placeholder = "Enter a chip number"
        )
    }
}
