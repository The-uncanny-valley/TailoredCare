package com.uncannyvalley.tailoredcare.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.uncannyvalley.tailoredcare.presentation.components.BottomNavBar
import com.uncannyvalley.tailoredcare.presentation.navigation.Screen

@Composable
fun CalendarScreen(
    onBack: () -> Unit,
    onNavigateHome: () -> Unit,
    onNavigateChat: () -> Unit,
    onNavigateProfile: () -> Unit
) {
    Scaffold(
        bottomBar = {
            BottomNavBar(
                current = Screen.CalendarScreen.route,
                onHomeClick = onNavigateHome,
                onChatClick = onNavigateChat,
                onProfileClick = onNavigateProfile,
                onCalendarClick = {}
            )
        },
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) { padding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Calendar Screen"
            )
        }
    }
}