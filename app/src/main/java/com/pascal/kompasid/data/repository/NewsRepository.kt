package com.pascal.kompasid.data.repository

import com.pascal.kompasid.data.remote.dtos.AdsBannerResponse
import com.pascal.kompasid.data.remote.dtos.ArticlesResponse
import com.pascal.kompasid.data.remote.dtos.BreakingNewsResponse
import com.pascal.kompasid.data.remote.dtos.CommonSectionResponse
import com.pascal.kompasid.data.remote.dtos.HotTopicsResponse
import com.pascal.kompasid.data.remote.dtos.LiveReportResponse
import com.pascal.kompasid.data.remote.dtos.dashboard.DashboardResponse

interface NewsRepository {
    suspend fun dashboard() : DashboardResponse
    suspend fun getAdsBanner(): AdsBannerResponse
    suspend fun getIframeCampaign(): AdsBannerResponse
    suspend fun getArticles(): ArticlesResponse
    suspend fun getBreakingNews(): BreakingNewsResponse
    suspend fun getHotTopics(): HotTopicsResponse
    suspend fun getLiveReport(): LiveReportResponse
    suspend fun getKabinet(): CommonSectionResponse
    suspend fun getPonAcehSumut(): CommonSectionResponse
}