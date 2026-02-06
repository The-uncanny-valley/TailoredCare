package com.uncannyvalley.tailoredcare.presentation.screen.newPet

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.uncannyvalley.tailoredcare.presentation.components.ActionButton
import com.uncannyvalley.tailoredcare.presentation.components.Stepper
import com.uncannyvalley.tailoredcare.presentation.viewmodel.NewPetViewModel

@Composable
fun NewPetScreen(
    onBack: () -> Unit,
    viewModel: NewPetViewModel = hiltViewModel(),
    onFinish: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 24.dp, bottom = 24.dp)
    ) {

        Stepper(
            currentStep = uiState.currentStep,
            maxStep = uiState.maxStep,
            modifier = Modifier.padding(16.dp)
        )

        Spacer(Modifier.height(16.dp))

        when (uiState.currentStep) {
            1 -> NewPetStepOne(
                state = uiState,
                viewModel = viewModel,
                onNext = viewModel::nextStep
            )
            2 -> NewPetStepTwo(
                state = uiState,
                viewModel = viewModel,
                onNext = viewModel::nextStep
            )
            3 -> NewPetStepThree(
                state = uiState,
                viewModel = viewModel
            )
        }

        Spacer(Modifier.weight(1f))

        ActionButton(
            state = uiState,
            onNext = viewModel::nextStep,
            onSave = {
                viewModel.savePet()
                onFinish()
            }
        )
    }
}