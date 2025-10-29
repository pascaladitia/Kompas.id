package com.pascal.kompasid.ui.screen.bookmark.state

import com.pascal.kompasid.domain.model.CommonArticle

data class BookmarkUIState(
    val isLoading: Boolean = false,
    val error: Pair<Boolean, String> = false to "",
    val articles: List<CommonArticle>? = null
)