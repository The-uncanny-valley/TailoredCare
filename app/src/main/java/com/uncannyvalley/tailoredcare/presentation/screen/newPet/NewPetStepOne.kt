package com.uncannyvalley.tailoredcare.presentation.screen.newPet

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.uncannyvalley.tailoredcare.presentation.state.NewPetUiState
import com.uncannyvalley.tailoredcare.presentation.theme.TailoredCareTheme
import com.uncannyvalley.tailoredcare.presentation.viewmodel.NewPetViewModel

@Composable
fun NewPetStepOne(
    state: NewPetUiState,
    viewModel: NewPetViewModel,
    onNext: () -> Unit
) {
    Column {
        TextField(
            value = state.petName,
            onValueChange = viewModel::updatePetName,
            label = { Text("Pet name") }
        )

        Button(
            enabled = state.isStepValid,
            onClick = onNext
        ) { Text("Continue") }


        // Pet type selector
        // Gender selector
        // Date picker
    }
}


@Composable
fun NewPetStepOneContent(
    state: NewPetUiState,
    onPetNameChange: (String) -> Unit,
    onNext: () -> Unit
) {
    Column {
        TextField(
            value = state.petName,
            onValueChange = onPetNameChange,
            label = { Text("Pet name") }
        )

        Button(
            enabled = state.isStepValid,
            onClick = onNext
        ) {
            Text("Continue")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun NewPetStepOnePreview() {
    TailoredCareTheme(darkTheme = false) {
        NewPetStepOneContent(
            state = NewPetUiState(
                petName = "Milo",
                currentStep = 1
            ),
            onPetNameChange = {},
            onNext = {}
        )
    }
}
