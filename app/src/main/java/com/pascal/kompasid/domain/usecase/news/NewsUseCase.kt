package com.pascal.kompasid.domain.usecase.news

import com.pascal.kompasid.domain.model.AdsBanner
import com.pascal.kompasid.domain.model.Article
import com.pascal.kompasid.domain.model.BreakingNews
import com.pascal.kompasid.domain.model.Dashboard
import com.pascal.kompasid.domain.model.HotTopics
import com.pascal.kompasid.domain.model.IframeCampaign
import com.pascal.kompasid.domain.model.Kabinet
import com.pascal.kompasid.domain.model.LiveReport
import com.pascal.kompasid.domain.model.PonAcehSumut
import kotlinx.coroutines.flow.Flow

interface NewsUseCase {
    suspend fun dashboard(): Flow<Dashboard>
    suspend fun getAdsBanner(): Flow<AdsBanner>
    suspend fun getArticles(): Flow<List<Article>>
    suspend fun getBreakingNews(): Flow<BreakingNews>
    suspend fun getHotTopics(): Flow<HotTopics>
    suspend fun getIframeCampaign(): Flow<IframeCampaign>
    suspend fun getKabinet(): Flow<Kabinet>
    suspend fun getLiveReport(): Flow<LiveReport>
    suspend fun getPonAcehSumut(): Flow<PonAcehSumut>
}
