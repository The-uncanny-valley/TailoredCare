package com.uncannyvalley.tailoredcare.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.uncannyvalley.tailoredcare.presentation.screen.CalendarScreen
import com.uncannyvalley.tailoredcare.presentation.screen.ChatScreen
import com.uncannyvalley.tailoredcare.presentation.screen.HomeScreen
import com.uncannyvalley.tailoredcare.presentation.screen.ProfileScreen
import com.uncannyvalley.tailoredcare.presentation.screen.newPet.NewPetScreen

import com.uncannyvalley.tailoredcare.presentation.viewmodel.HomeViewModel
import com.uncannyvalley.tailoredcare.presentation.viewmodel.NewPetViewModel

sealed class Screen(val route: String) {
    object HomeScreen : Screen("home")
    object CalendarScreen : Screen("calendar")
    object ChatScreen : Screen("chat")
    object ProfileScreen : Screen("profile")
    object NewPetScreen : Screen("new_pet")
}

@Composable
fun ProfileRoute(
    onBack: () -> Unit,
    onNavigateHome: () -> Unit,
    onNavigateCalendar: () -> Unit,
    onNavigateChat: () -> Unit
) {
    ProfileScreen(
        onBack = onBack,
        onNavigateHome = onNavigateHome,
        onNavigateCalendar = onNavigateCalendar,
        onNavigateChat = onNavigateChat
    )
}

@Composable
fun HomeRoute(
    onNavigateProfile: () -> Unit,
    onNavigateCalendar: () -> Unit,
    onNavigateChat: () -> Unit,
    onNavigateNewPet: () -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    HomeScreen(
        onNavigateCalendar = onNavigateCalendar,
        onNavigateChat = onNavigateChat,
        onNavigateProfile = onNavigateProfile,
        uiState = uiState,
        onNavigateNewPet = onNavigateNewPet
    )
}

@Composable
fun CalendarRoute(
    onBack: () -> Unit,
    onNavigateHome: () -> Unit,
    onNavigateChat: () -> Unit,
    onNavigateProfile: () -> Unit
) {
    CalendarScreen(
        onNavigateHome = onNavigateHome,
        onNavigateChat = onNavigateChat,
        onNavigateProfile = onNavigateProfile,
        onBack = onBack
    )
}

@Composable
fun ChatRoute(
    onBack: () -> Unit,
    onNavigateHome: () -> Unit,
    onNavigateCalendar: () -> Unit,
    onNavigateProfile: () -> Unit
) {
    ChatScreen(
        onNavigateHome = onNavigateHome,
        onNavigateCalendar = onNavigateCalendar,
        onNavigateProfile = onNavigateProfile,
        onBack = onBack
    )
}

@Composable
fun NewPetRoute(
    onBack: () -> Unit,
    onFinish: () -> Unit,
    viewModel: NewPetViewModel = hiltViewModel()
) {
    NewPetScreen(
        onBack = onBack,
        viewModel = viewModel,
        onFinish = onFinish
    )
}