package com.pascal.kompasid.ui.screen.home.state

import androidx.compose.runtime.Stable
import androidx.compose.runtime.compositionLocalOf

val LocalHomeEvent = compositionLocalOf { HomeEvent() }

@Stable
data class HomeEvent(
    val onDetail: () -> Unit = {},
    val onAudio: (String) -> Unit = {},
    val onBookMark: (String) -> Unit = {},
    val onShare: (String) -> Unit = {}
)