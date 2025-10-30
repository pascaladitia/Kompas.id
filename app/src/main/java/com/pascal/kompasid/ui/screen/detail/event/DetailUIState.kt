@file:OptIn(ExperimentalSharedTransitionApi::class)

package com.pascal.kompasid.ui.screen.detail.event

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import com.pascal.kompasid.domain.model.CommonArticle

data class DetailUIState(
    val isLoading: Boolean = false,
    val error: Pair<Boolean, String> = false to "",
    val articles: CommonArticle? = null,
    val sharedTransitionScope: SharedTransitionScope? = null,
    val animatedVisibilityScope: AnimatedVisibilityScope? = null
)