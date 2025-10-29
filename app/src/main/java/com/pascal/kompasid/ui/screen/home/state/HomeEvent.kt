package com.pascal.kompasid.ui.screen.home.state

import androidx.compose.runtime.Stable
import androidx.compose.runtime.compositionLocalOf
import com.pascal.kompasid.domain.model.CommonArticle

val LocalHomeEvent = compositionLocalOf { HomeEvent() }

@Stable
data class HomeEvent(
    val onDetail: (CommonArticle?) -> Unit = {},
    val onBookMark: (CommonArticle?) -> Unit = {},
    val onAudio: (String?) -> Unit = {},
    val onShare: (String?) -> Unit = {}
)