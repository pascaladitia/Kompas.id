package com.pascal.kompasid.ui.screen.bookmark.state

import androidx.compose.runtime.Stable
import androidx.compose.runtime.compositionLocalOf

val LocalBookmarkEvent = compositionLocalOf { BookmarkEvent() }

@Stable
data class BookmarkEvent(
    val onNavBack: () -> Unit = {}
)