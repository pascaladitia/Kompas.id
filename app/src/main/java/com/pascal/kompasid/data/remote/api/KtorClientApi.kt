package com.pascal.kompasid.data.remote.api

import android.content.Context
import com.pascal.kompasid.data.remote.client
import com.pascal.kompasid.data.remote.dtos.AdsBannerResponse
import com.pascal.kompasid.data.remote.dtos.BreakingNewsResponse
import com.pascal.kompasid.data.remote.dtos.CommonSectionResponse
import com.pascal.kompasid.data.remote.dtos.LiveReportResponse
import com.pascal.kompasid.data.remote.dtos.dashboard.DashboardResponse
import com.pascal.kompasid.utils.base.JsonReader
import io.ktor.client.call.body
import io.ktor.client.request.get
import org.koin.core.annotation.Single

@Single
class KtorClientApi(private val context: Context) {
    suspend fun dashboard(): DashboardResponse {
        return client.get("http:///dashboard").body()
    }

    suspend fun getAdsBanner(): AdsBannerResponse =
        JsonReader.load(context, "ads_banner.json")

    suspend fun getArticles(): CommonSectionResponse =
        JsonReader.load(context, "articles.json")

    suspend fun getBreakingNews(): BreakingNewsResponse =
        JsonReader.load(context, "breaking_news.json")

    suspend fun getHotTopics(): CommonSectionResponse =
        JsonReader.load(context, "hot_topics.json")

    suspend fun getIframeCampaign(): AdsBannerResponse =
        JsonReader.load(context, "iframe_campaign.json")

    suspend fun getKabinet(): CommonSectionResponse =
        JsonReader.load(context, "kabinet.json")

    suspend fun getLiveReport(): LiveReportResponse =
        JsonReader.load(context, "live_report.json")

    suspend fun getPonAcehSumut(): CommonSectionResponse =
        JsonReader.load(context, "pon_aceh_sumut.json")
}