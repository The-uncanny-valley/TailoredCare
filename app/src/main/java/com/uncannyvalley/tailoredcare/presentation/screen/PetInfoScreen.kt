package com.uncannyvalley.tailoredcare.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(32.dp)) {
        Text(
            text = pet?.petName ?: "Pet Info",
            style = MaterialTheme.typography.labelLarge.copy(
                fontSize = 32.sp
            ),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth(),
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(Modifier.height(16.dp))

        if (pet != null) {
            PetInfoField("Breed", pet.breed)
            PetInfoField("Gender", pet.gender.name)
            PetInfoField("Birth date", pet.birthDate.toString())
            PetInfoField("Weight", pet.weightKg?.toString())
            PetInfoField("Sterilized", if (pet.isSterilized) "Yes" else "No")
            PetInfoField("Origin", pet.origin)
            PetInfoField("Chip number", pet.chipNumber)
        } else {
            Text(
                text = "Pet not found",
                modifier = Modifier.fillMaxSize(),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onBackground
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

@Composable
fun PetInfoField(label: String, value: String?) {
    Text(
        text = "$label: ${value ?: "-"}",
        style = MaterialTheme.typography.bodyLarge.copy(
            fontSize = 18.sp
        ),
        color = MaterialTheme.colorScheme.onBackground,
        modifier = Modifier
            .padding(vertical = 4.dp)
    )
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
