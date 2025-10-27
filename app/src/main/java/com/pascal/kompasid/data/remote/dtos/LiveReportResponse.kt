package com.pascal.kompasid.data.remote.dtos

import kotlinx.serialization.Serializable

@Serializable
data class LiveReportResponse(
    val report_type: String? = null,
    val main_article: MainArticle? = null,
    val related_articles: List<RelatedArticle>? = null,
    val more_reports: MoreReports? = null,
    val featured_articles: List<FeaturedArticle>? = null
)

@Serializable
data class MainArticle(
    val category: String? = null,
    val title: String? = null,
    val published_time: String? = null
)

@Serializable
data class RelatedArticle(
    val title: String? = null,
    val published_time: String? = null
)

@Serializable
data class MoreReports(
    val label: String? = null,
    val count: String? = null
)

@Serializable
data class FeaturedArticle(
    val title: String? = null
)
