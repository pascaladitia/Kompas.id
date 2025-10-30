package com.pascal.kompasid.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.pascal.kompasid.ui.navigation.RouteScreen
import com.pascal.kompasid.ui.screen.profile.ProfileViewModel
import com.pascal.kompasid.ui.screen.profile.ThemeMode
import com.pascal.kompasid.ui.theme.AppTheme
import org.koin.compose.koinInject

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val viewModelSettings: ProfileViewModel = koinInject<ProfileViewModel>()

            val uiState by viewModelSettings.uiState.collectAsState()

            val darkTheme = when (uiState.themeMode) {
                ThemeMode.DARK -> true
                ThemeMode.LIGHT -> false
                ThemeMode.SYSTEM -> isSystemInDarkTheme()
            }

            AppTheme(
                darkTheme = darkTheme,
                dynamicColor = false
            ) {
                RouteScreen()
            }
        }
    }
}