package com.pascal.kompasid.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.pascal.kompasid.ui.navigation.RouteScreen
import com.pascal.kompasid.ui.theme.MovieTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MovieTheme(
                dynamicColor = false
            ) {
                RouteScreen()
            }
        }
    }
}