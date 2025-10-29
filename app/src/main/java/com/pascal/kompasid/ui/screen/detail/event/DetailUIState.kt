package com.pascal.kompasid.ui.screen.detail.event

import com.pascal.kompasid.domain.model.CommonArticle

data class DetailUIState(
    val isLoading: Boolean = false,
    val error: Pair<Boolean, String> = false to "",
    val articles: CommonArticle? = null
)