package com.uncannyvalley.tailoredcare.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.uncannyvalley.tailoredcare.domain.model.MedicalCard

@Composable
fun PetInfoScreen(
    pet: MedicalCard?,
    onBack: () -> Unit
) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(pet?.petName ?: "Pet Info")

        Spacer(Modifier.height(16.dp))

        if (pet != null) {
            Text("Type: ${pet.petType}")
            Text("Breed: ${pet.breed ?: "-"}")
            Text("Gender: ${pet.gender}")
            Text("Birth date: ${pet.birthDate}")
            Text("Weight: ${pet.weightKg ?: "-"} kg")
            Text("Sterilized: ${if (pet.isSterilized) "Yes" else "No"}")
            Text("Origin: ${pet.origin ?: "-"}")
            Text("Chip number: ${pet.chipNumber ?: "-"}")
        } else {
            Text(
                text = "Pet not found",
                modifier = Modifier.fillMaxSize(),
                textAlign = TextAlign.Center
            )
        }
    }
}
