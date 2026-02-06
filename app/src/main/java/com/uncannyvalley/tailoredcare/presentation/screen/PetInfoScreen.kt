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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uncannyvalley.tailoredcare.domain.model.Gender
import com.uncannyvalley.tailoredcare.domain.model.MedicalCard
import com.uncannyvalley.tailoredcare.domain.model.PetType
import com.uncannyvalley.tailoredcare.presentation.theme.TailoredCareTheme
import java.time.LocalDate

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

@Preview(showBackground = true)
@Composable
fun PetInfoScreenPreview() {
    val samplePet = MedicalCard(
        petName = "Buddy",
        petType = PetType.DOG,
        breed = "Golden Retriever",
        gender = Gender.MALE,
        birthDate = LocalDate.of(2020, 6, 15),
        weightKg = 30.5,
        isSterilized = true,
        ownerId = 1L,
        origin = "",
        chipNumber = "",
        createdAt = LocalDate.now(),
    )

    TailoredCareTheme() {
        PetInfoScreen(
            pet = samplePet,
            onBack = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PetInfoScreenEmptyPreview() {
    TailoredCareTheme() {
        PetInfoScreen(
            pet = null,
            onBack = {}
        )
    }
}
