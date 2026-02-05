package com.uncannyvalley.tailoredcare.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uncannyvalley.tailoredcare.R
import com.uncannyvalley.tailoredcare.presentation.navigation.Screen
import com.uncannyvalley.tailoredcare.presentation.screen.HomeScreen
import com.uncannyvalley.tailoredcare.presentation.state.HomeUiState
import com.uncannyvalley.tailoredcare.presentation.theme.TailoredCareTheme

@Composable
fun BottomNavBar(
    current: String,
    onHomeClick: () -> Unit,
    onCalendarClick: () -> Unit,
    onChatClick: () -> Unit,
    onProfileClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 42.dp, end = 62.dp, start = 62.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        BottomNavItem(
            iconRes = R.drawable.ic_home,
            selected = current == Screen.HomeScreen.route,
            onClick = onHomeClick
        )

        BottomNavItem(
            iconRes = R.drawable.ic_calendar,
            selected = current == Screen.CalendarScreen.route,
            onClick = onCalendarClick
        )

        BottomNavItem(
            iconRes = R.drawable.ic_chat,
            selected = current == Screen.ChatScreen.route,
            onClick = onChatClick
        )

        BottomNavItem(
            iconRes = R.drawable.ic_profile,
            selected = current == Screen.ProfileScreen.route,
            onClick = onProfileClick
        )
    }
}

@Composable
fun BottomNavItem(
    iconRes: Int,
    selected: Boolean,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .width(32.dp)
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() },
                onClick = onClick
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            painter = painterResource(iconRes),
            contentDescription = null,
            tint = if (selected) MaterialTheme.colorScheme.primary
                    else Color.Unspecified,
            modifier = Modifier.size(32.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview_() {

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