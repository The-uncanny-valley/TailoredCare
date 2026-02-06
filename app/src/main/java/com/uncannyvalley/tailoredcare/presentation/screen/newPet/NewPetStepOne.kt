package com.uncannyvalley.tailoredcare.presentation.screen.newPet

import android.app.DatePickerDialog
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uncannyvalley.tailoredcare.R
import com.uncannyvalley.tailoredcare.domain.model.Gender
import com.uncannyvalley.tailoredcare.domain.model.PetType
import com.uncannyvalley.tailoredcare.presentation.components.RoundedDropdownField
import com.uncannyvalley.tailoredcare.presentation.components.RoundedTextField
import com.uncannyvalley.tailoredcare.presentation.state.NewPetUiState
import com.uncannyvalley.tailoredcare.presentation.viewmodel.NewPetViewModel
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun NewPetStepOne(
    state: NewPetUiState,
    viewModel: NewPetViewModel,
    onNext: () -> Unit
) {
    val context = LocalContext.current

    var showDatePicker by remember { mutableStateOf(false) }

    if (showDatePicker) {
        // Create and show the dialog safely
        val today = LocalDate.now()
        DatePickerDialog(
            context,
            { _, year, month, dayOfMonth ->
                viewModel.updateBirthDate(LocalDate.of(year, month + 1, dayOfMonth))
                showDatePicker = false
            },
            today.year,
            today.monthValue - 1,
            today.dayOfMonth
        ).show()
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(36.dp)
    ) {
        Text(
            text = "Name",
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(modifier = Modifier.height(7.dp))

        RoundedTextField(
            value = state.petName,
            onValueChange = viewModel::updatePetName,
            placeholder = "Pet name"
        )

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "Type",
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(modifier = Modifier.height(7.dp))

        RoundedDropdownField(
            value = state.petType,
            onValueChange = viewModel::updatePetType,
            placeholder = "Select pet type",
            options = PetType.entries,
            toText = { it.name.lowercase().replaceFirstChar { c -> c.uppercase() } }
        )

        Spacer(modifier = Modifier.height(30.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top
        ) {

            GenderColumn(
                selected = state.gender,
                onSelect = viewModel::updateGender,
                modifier = Modifier.weight(1f)
            )

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "Birth date",
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.onBackground
                )

                Spacer(Modifier.height(8.dp))

                BirthDateField(
                    date = state.birthDate,
                    onClick = {
                        showDatePicker = true
                    }
                )
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "Breed",
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(modifier = Modifier.height(7.dp))

        RoundedTextField(
            value = state.breed,
            onValueChange = viewModel::updateBreed,
            placeholder = "Enter breed"
        )

        Spacer(modifier = Modifier.height(30.dp))
    }
}

@Composable
fun GenderColumn(
    selected: Gender,
    onSelect: (Gender) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = "Gender",
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(Modifier.height(7.dp))

        Gender.entries.forEach { gender ->
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = selected == gender,
                    onClick = { onSelect(gender) }
                )
                Text(
                    text = gender.name.lowercase()
                        .replaceFirstChar { it.uppercase() },
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
        }
    }
}

@Composable
fun BirthDateField(
    date: LocalDate?,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val formatter = DateTimeFormatter.ofPattern("dd MMM yyyy")
    val text = date?.format(formatter) ?: ""

    OutlinedTextField(
        value = text,
        onValueChange = {}, // read-only
        readOnly = true,
        singleLine = true,
        placeholder = { Text("Birth date") },
        leadingIcon = {
            Icon(
                painter = painterResource(R.drawable.ic_calendar),
                contentDescription = "Pick date",
                tint = Color.Unspecified
            )
        },
        shape = RoundedCornerShape(12.dp),
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color.Transparent,
            focusedContainerColor = Color.Transparent,
            cursorColor = MaterialTheme.colorScheme.outlineVariant,
            unfocusedIndicatorColor = MaterialTheme.colorScheme.outline,
            focusedIndicatorColor = MaterialTheme.colorScheme.outlineVariant
        ),
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick() } // attach click directly
    )
}


//@Composable
//fun BirthDateField(
//    date: LocalDate?,
//    onClick: () -> Unit,
//    modifier: Modifier = Modifier
//) {
//    val formatter = DateTimeFormatter.ofPattern("dd MMM yyyy")
//    val text = date?.format(formatter) ?: ""
//
//    Box(
//        modifier = modifier
//            .fillMaxWidth()
//            .clickable { onClick() }
//    ) {
//
//        OutlinedTextField(
//            value = text,
//            onValueChange = {},
//            readOnly = true,
//            enabled = true,
//            singleLine = true,
//            placeholder = { Text("Birth date") },
//            leadingIcon = {
//                Icon(
//                    painter = painterResource(R.drawable.ic_calendar),
//                    contentDescription = null,
//                    tint = Color.Unspecified
//                )
//            },
//            shape = RoundedCornerShape(12.dp),
//            colors = TextFieldDefaults.colors(
//                unfocusedContainerColor = Color.Transparent,
//                disabledContainerColor = Color.Transparent,
//                disabledIndicatorColor = MaterialTheme.colorScheme.outline
//            ),
//            modifier = Modifier.fillMaxWidth()
//        )
//    }
//}



@Preview(showBackground = true)
@Composable
fun BirthDatePickerPreview() {
    MaterialTheme {
        BirthDateField(
            date = LocalDate.of(2020, 5, 12),
            onClick = {}
        )
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
    }
}

@Preview(showBackground = true)
@Composable
fun GenderColumnPreview() {
    MaterialTheme {
        var selectedGender by remember { mutableStateOf(Gender.FEMALE) }

        GenderColumn(
            selected = selectedGender,
            onSelect = { selectedGender = it },
            modifier = Modifier.padding(16.dp)
        )
    }
}
