package com.uncannyvalley.tailoredcare

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.uncannyvalley.tailoredcare.presentation.navigation.AppNavHost
import com.uncannyvalley.tailoredcare.presentation.theme.TailoredCareTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
             TailoredCareTheme() {
                 AppNavHost()
            }
        }
    }
}