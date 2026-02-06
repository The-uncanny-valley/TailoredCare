package com.uncannyvalley.tailoredcare.presentation.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun AppNavHost(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route,
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        composable(Screen.HomeScreen.route) {
            HomeRoute(
                onNavigateProfile = { navController.navigate(Screen.ProfileScreen.route) },
                onNavigateChat = { navController.navigate(Screen.ChatScreen.route) },
                onNavigateCalendar = { navController.navigate(Screen.CalendarScreen.route) },
                onNavigateNewPet = { navController.navigate(Screen.NewPetScreen.route) },
                onNavigatePet = { petId ->
                    navController.navigate(Screen.PetInfoScreen.createRoute(petId))
                }
            )
        }
        composable(Screen.CalendarScreen.route) {
            CalendarRoute(
                onBack = { navController.popBackStack() },
                onNavigateHome = { navController.navigate(Screen.HomeScreen.route) },
                onNavigateChat = { navController.navigate(Screen.ChatScreen.route) },
                onNavigateProfile = { navController.navigate(Screen.ProfileScreen.route) }
            )
        }
        composable(Screen.ProfileScreen.route) {
            ProfileRoute(
                onBack = { navController.popBackStack() },
                onNavigateCalendar = { navController.navigate(Screen.CalendarScreen.route) },
                onNavigateHome = { navController.navigate(Screen.HomeScreen.route) },
                onNavigateChat = { navController.navigate(Screen.ChatScreen.route) }
            )
        }

        composable(Screen.ChatScreen.route) {
            ChatRoute(
                onBack = { navController.popBackStack() },
                onNavigateCalendar = { navController.navigate(Screen.CalendarScreen.route) },
                onNavigateHome = { navController.navigate(Screen.HomeScreen.route) },
                onNavigateProfile = { navController.navigate(Screen.ProfileScreen.route) }
            )
        }

        composable(Screen.NewPetScreen.route) {
            NewPetRoute(
                onBack = {},
                onFinish = { navController.popBackStack() }
            )
        }

        composable(
            route = Screen.PetInfoScreen.route,
            arguments = listOf(navArgument("petId") { type = NavType.LongType })
        ) { backStackEntry ->
            val petId = backStackEntry.arguments?.getLong("petId") ?: 0L
            PetInfoRoute(
                petId = petId,
                onBack = { navController.popBackStack() }
            )
        }
    }
}