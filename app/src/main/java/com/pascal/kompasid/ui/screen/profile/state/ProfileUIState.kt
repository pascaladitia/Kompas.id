package com.pascal.kompasid.ui.screen.profile.state

import com.pascal.kompasid.domain.model.CommonArticle

data class ProfileUIState(
    val isLoading: Boolean = false,
    val error: Pair<Boolean, String> = false to "",
    val articles: CommonArticle? = null
)