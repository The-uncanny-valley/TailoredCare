package com.uncannyvalley.tailoredcare.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uncannyvalley.tailoredcare.R
import com.uncannyvalley.tailoredcare.presentation.components.BottomNavBar
import com.uncannyvalley.tailoredcare.presentation.components.ButtonNewPetCard
import com.uncannyvalley.tailoredcare.presentation.components.PetCard
import com.uncannyvalley.tailoredcare.presentation.model.PetCardUiModel
import com.uncannyvalley.tailoredcare.presentation.navigation.Screen
import com.uncannyvalley.tailoredcare.presentation.state.HomeUiState
import com.uncannyvalley.tailoredcare.presentation.theme.TailoredCareTheme
import androidx.compose.foundation.lazy.items

@Composable
fun HomeScreen(
    uiState: HomeUiState,
    onNavigateCalendar: () -> Unit,
    onNavigateChat: () -> Unit,
    onNavigateProfile: () -> Unit
) {

    Scaffold(
        bottomBar = {
            BottomNavBar(
                current = Screen.HomeScreen.route,
                onHomeClick = {},
                onChatClick = onNavigateChat,
                onProfileClick = onNavigateProfile,
                onCalendarClick = onNavigateCalendar
            )
        },
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            Text(
                text = "My pets",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.secondary
            )

            Spacer(modifier = Modifier.height(16.dp))

            if (uiState.petCards.isEmpty() || uiState.showAddButtonOnly) {
                ButtonNewPetCard(
                    modifier = Modifier.align(Alignment.Start),
                    onClick = { /* handle click */ }
                )
            } else {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(uiState.petCards) { pet ->
                        PetCard(pet = pet, onClick = { /* handle click */ })
                    }
                    item {
                        ButtonNewPetCard(onClick = { /* handle click */ })
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview_pets() {
    val sampleUiStateWithPets = HomeUiState(
        petCards = listOf(
            PetCardUiModel(
                id = 1L,
                name = "Fluffy",
                imageUri = null,
                iconResId = R.drawable.ic_cat
            ),
            PetCardUiModel(
                id = 2L,
                name = "Bobby",
                imageUri = null,
                iconResId = R.drawable.ic_dog
            )
        ),
        showAddButtonOnly = false
    )

    TailoredCareTheme(
        darkTheme = false
    ) {
        HomeScreen(
            uiState = sampleUiStateWithPets,
            onNavigateCalendar = {},
            onNavigateChat = {},
            onNavigateProfile = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview_no_pets() {

    val sampleUiStateNoPets = HomeUiState(
        petCards = emptyList(),
        showAddButtonOnly = true
    )

    TailoredCareTheme(
        darkTheme = false
    ) {
        HomeScreen(
            uiState = sampleUiStateNoPets,
            onNavigateCalendar = {},
            onNavigateChat = {},
            onNavigateProfile = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview_pet() {
    val sampleUiStateWithPets = HomeUiState(
        petCards = listOf(
            PetCardUiModel(
                id = 1L,
                name = "Fluffy",
                imageUri = null,
                iconResId = R.drawable.ic_cat
            )
        ),
        showAddButtonOnly = false
    )

    TailoredCareTheme(
        darkTheme = false
    ) {
        HomeScreen(
            uiState = sampleUiStateWithPets,
            onNavigateCalendar = {},
            onNavigateChat = {},
            onNavigateProfile = {}
        )
    }
}
