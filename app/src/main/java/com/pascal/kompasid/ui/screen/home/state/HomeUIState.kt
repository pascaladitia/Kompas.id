package com.pascal.kompasid.ui.screen.home.state

import com.pascal.kompasid.domain.model.AdsBanner
import com.pascal.kompasid.domain.model.BreakingNews
import com.pascal.kompasid.domain.model.CommonSection
import com.pascal.kompasid.domain.model.LiveReport

data class HomeUIState(
    val isLoading: Boolean = false,
    val error: Pair<Boolean, String> = false to "",
    val adsBanner: AdsBanner? = null,
    val iframeCampaign: AdsBanner? = null,
    val articles: CommonSection? = null,
    val breakingNews: BreakingNews? = null,
    val hotTopics: CommonSection? = null,
    val liveReport: LiveReport? = null,
    val articleList: List<CommonSection> = emptyList()
)