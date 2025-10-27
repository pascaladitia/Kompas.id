package com.pascal.kompasid.ui.screen.home.state

import com.pascal.kompasid.domain.model.AdsBanner
import com.pascal.kompasid.domain.model.Article
import com.pascal.kompasid.domain.model.BreakingNews
import com.pascal.kompasid.domain.model.HotTopics
import com.pascal.kompasid.domain.model.IframeCampaign
import com.pascal.kompasid.domain.model.Kabinet
import com.pascal.kompasid.domain.model.LiveReport
import com.pascal.kompasid.domain.model.PonAcehSumut

data class HomeUIState(
    val isLoading: Boolean = false,
    val error: Pair<Boolean, String> = false to "",
    val adsBanner: AdsBanner? = null,
    val articles: List<Article>? = null,
    val breakingNews: BreakingNews? = null,
    val hotTopics: HotTopics? = null,
    val iframeCampaign: IframeCampaign? = null,
    val kabinet: Kabinet? = null,
    val liveReport: LiveReport? = null,
    val ponAcehSumut: PonAcehSumut? = null
)