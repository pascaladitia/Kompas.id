package com.pascal.kompasid.domain.mapper

import com.pascal.kompasid.data.remote.dtos.AdsBannerResponse
import com.pascal.kompasid.data.remote.dtos.ArticlesResponse
import com.pascal.kompasid.data.remote.dtos.BreakingNewsResponse
import com.pascal.kompasid.data.remote.dtos.HotTopicsResponse
import com.pascal.kompasid.data.remote.dtos.IframeCampaignResponse
import com.pascal.kompasid.data.remote.dtos.KabinetResponse
import com.pascal.kompasid.data.remote.dtos.LiveReportResponse
import com.pascal.kompasid.data.remote.dtos.PonAcehSumutResponse
import com.pascal.kompasid.data.remote.dtos.dashboard.DashboardResponse
import com.pascal.kompasid.domain.model.AdsBanner
import com.pascal.kompasid.domain.model.Article
import com.pascal.kompasid.domain.model.BreakingNews
import com.pascal.kompasid.domain.model.BreakingNewsArticle
import com.pascal.kompasid.domain.model.Dashboard
import com.pascal.kompasid.domain.model.FeaturedArticle
import com.pascal.kompasid.domain.model.HotTopics
import com.pascal.kompasid.domain.model.IframeCampaign
import com.pascal.kompasid.domain.model.Kabinet
import com.pascal.kompasid.domain.model.KabinetArticle
import com.pascal.kompasid.domain.model.LiveReport
import com.pascal.kompasid.domain.model.MainArticle
import com.pascal.kompasid.domain.model.MoreReports
import com.pascal.kompasid.domain.model.PonAcehSumut
import com.pascal.kompasid.domain.model.PonArticle
import com.pascal.kompasid.domain.model.RelatedArticle
import com.pascal.kompasid.domain.model.Topic

fun DashboardResponse.toDomain(): Dashboard {
    return Dashboard(
        code = this.code ?: 0,
        success = this.success ?: false,
        message = this.message.orEmpty()
    )
}

fun AdsBannerResponse.toDomain() = AdsBanner(
    url = url.orEmpty()
)

fun ArticlesResponse.toDomain() = articles?.map {
    Article(
        title = it.title.orEmpty(),
        description = it.description,
        label = it.label,
        imageDescription = it.image_description
    )
}.orEmpty()

fun BreakingNewsResponse.toDomain() = BreakingNews(
    headline = headline.orEmpty(),
    subheadline = subheadline,
    publishedTime = published_time,
    source = source,
    articles = articles?.map {
        BreakingNewsArticle(
            title = it.title.orEmpty(),
            publishedTime = it.published_time.orEmpty()
        )
    }.orEmpty()
)

fun HotTopicsResponse.toDomain() = HotTopics(
    section = section.orEmpty(),
    topics = topics?.map {
        Topic(
            title = it.title.orEmpty(),
            imageDescription = it.image_description.orEmpty()
        )
    }.orEmpty()
)

fun IframeCampaignResponse.toDomain() = IframeCampaign(
    url = url.orEmpty()
)

fun KabinetResponse.toDomain() = Kabinet(
    section = section.orEmpty(),
    articles = articles?.map {
        KabinetArticle(
            title = it.title.orEmpty(),
            description = it.description,
            imageDescription = it.image_description,
            mediaCount = it.media_count
        )
    }.orEmpty()
)

fun LiveReportResponse.toDomain() = LiveReport(
    reportType = report_type.orEmpty(),
    mainArticle = main_article?.let {
        MainArticle(
            category = it.category,
            title = it.title,
            publishedTime = it.published_time
        )
    },
    relatedArticles = related_articles?.map {
        RelatedArticle(
            title = it.title,
            publishedTime = it.published_time
        )
    }.orEmpty(),
    moreReports = more_reports?.let {
        MoreReports(
            label = it.label,
            count = it.count
        )
    },
    featuredArticles = featured_articles?.map {
        FeaturedArticle(
            title = it.title
        )
    }.orEmpty()
)

fun PonAcehSumutResponse.toDomain() = PonAcehSumut(
    section = section.orEmpty(),
    articles = articles?.map {
        PonArticle(
            title = it.title.orEmpty(),
            label = it.label,
            description = it.description,
            imageDescription = it.image_description
        )
    }.orEmpty()
)