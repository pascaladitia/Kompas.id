package com.pascal.kompasid.ui.screen.detail.event

import androidx.compose.runtime.Stable
import androidx.compose.runtime.compositionLocalOf
import com.pascal.kompasid.domain.model.CommonArticle

val LocalDetailEvent = compositionLocalOf { DetailEvent() }

@Stable
data class DetailEvent(
    val onNavBack: () -> Unit = {},
    val onBookMark: (CommonArticle?, Boolean) -> Unit = { _, _ -> },
    val onAudio: (String?) -> Unit = {},
    val onShare: (String?) -> Unit = {}
)