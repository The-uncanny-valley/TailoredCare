package com.uncannyvalley.tailoredcare.presentation.screen.newPet

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
import com.uncannyvalley.tailoredcare.domain.model.Gender
import com.uncannyvalley.tailoredcare.domain.model.PetType
import com.uncannyvalley.tailoredcare.presentation.components.RoundedDropdownField
import com.uncannyvalley.tailoredcare.presentation.components.RoundedTextField
import com.uncannyvalley.tailoredcare.presentation.state.NewPetUiState
import com.uncannyvalley.tailoredcare.presentation.viewmodel.NewPetViewModel
import java.time.LocalDate

@Composable
fun NewPetStepThree(
    state: NewPetUiState,
    viewModel: NewPetViewModel
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(36.dp)
    ) {
        Text(
            text = "Complex vaccination",
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(modifier = Modifier.height(7.dp))

        BirthDateField(
            date = state.lastComplexVaccinationDate,
            onClick = {
                // open date picker dialog
            }
        )

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "Rabies vaccination",
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(modifier = Modifier.height(7.dp))

        BirthDateField(
            date = state.lastRabiesVaccinationDate,
            onClick = {
                // open date picker dialog
            }
        )

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "Last appointment",
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(modifier = Modifier.height(7.dp))

        BirthDateField(
            date = state.lastAppointmentDate,
            onClick = {
                // open date picker dialog
            }
        )

        Spacer(modifier = Modifier.height(30.dp))
    }
}
