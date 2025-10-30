package com.pascal.kompasid.ui.screen.bookmark.state

import androidx.compose.runtime.Stable
import androidx.compose.runtime.compositionLocalOf
import com.pascal.kompasid.domain.model.CommonArticle

val LocalBookmarkEvent = compositionLocalOf { BookmarkEvent() }

@Stable
data class BookmarkEvent(
    val onNavBack: () -> Unit = {},
    val onDelete: (List<CommonArticle>?) -> Unit = { },
    val onDetail: (CommonArticle?) -> Unit = { },
    val onBookMark: (CommonArticle?, Boolean) -> Unit = { _, _ -> },
    val onAudio: (String?) -> Unit = {},
    val onShare: (String?) -> Unit = {},
)