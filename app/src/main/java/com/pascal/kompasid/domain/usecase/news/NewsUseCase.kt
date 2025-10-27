package com.pascal.kompasid.domain.usecase.news

import com.pascal.kompasid.domain.model.AdsBanner
import com.pascal.kompasid.domain.model.BreakingNews
import com.pascal.kompasid.domain.model.CommonSection
import com.pascal.kompasid.domain.model.Dashboard
import com.pascal.kompasid.domain.model.LiveReport
import kotlinx.coroutines.flow.Flow

interface NewsUseCase {
    suspend fun dashboard(): Flow<Dashboard>
    suspend fun getAdsBanner(): Flow<AdsBanner>
    suspend fun getIframeCampaign(): Flow<AdsBanner>
    suspend fun getArticles(): Flow<CommonSection>
    suspend fun getBreakingNews(): Flow<BreakingNews>
    suspend fun getHotTopics(): Flow<CommonSection>
    suspend fun getLiveReport(): Flow<LiveReport>
    suspend fun getKabinet(): Flow<CommonSection>
    suspend fun getPonAcehSumut(): Flow<CommonSection>
}
