package com.pascal.kompasid.data.repository

import com.pascal.kompasid.data.remote.api.KtorClientApi
import com.pascal.kompasid.data.remote.dtos.AdsBannerResponse
import com.pascal.kompasid.data.remote.dtos.ArticlesResponse
import com.pascal.kompasid.data.remote.dtos.BreakingNewsResponse
import com.pascal.kompasid.data.remote.dtos.HotTopicsResponse
import com.pascal.kompasid.data.remote.dtos.IframeCampaignResponse
import com.pascal.kompasid.data.remote.dtos.KabinetResponse
import com.pascal.kompasid.data.remote.dtos.LiveReportResponse
import com.pascal.kompasid.data.remote.dtos.PonAcehSumutResponse
import com.pascal.kompasid.data.remote.dtos.dashboard.DashboardResponse
import org.koin.core.annotation.Single

@Single
class NewsRepositoryImpl(
    private val api: KtorClientApi
) : NewsRepository {

    override suspend fun dashboard(): DashboardResponse {
        return api.dashboard()
    }

    override suspend fun getAdsBanner(): AdsBannerResponse {
        return api.getAdsBanner()
    }

    override suspend fun getArticles(): ArticlesResponse {
        return api.getArticles()
    }

    override suspend fun getBreakingNews(): BreakingNewsResponse {
        return api.getBreakingNews()
    }

    override suspend fun getHotTopics(): HotTopicsResponse {
        return api.getHotTopics()
    }

    override suspend fun getIframeCampaign(): IframeCampaignResponse {
        return api.getIframeCampaign()
    }

    override suspend fun getKabinet(): KabinetResponse {
        return api.getKabinet()
    }

    override suspend fun getLiveReport(): LiveReportResponse {
        return api.getLiveReport()
    }

    override suspend fun getPonAcehSumut(): PonAcehSumutResponse {
        return api.getPonAcehSumut()
    }
}