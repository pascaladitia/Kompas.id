package com.pascal.kompasid.ui.screen.home.state

import com.pascal.kompasid.domain.model.Dashboard

data class HomeUIState(
    val isLoading: Boolean = false,
    val error: Pair<Boolean, String> = false to "",
    val dashboard: Dashboard? = null
)