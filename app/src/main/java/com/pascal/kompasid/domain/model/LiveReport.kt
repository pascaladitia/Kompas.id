package com.pascal.kompasid.domain.model

data class LiveReport(
    val reportType: String,
    val mainArticle: MainArticle?,
    val relatedArticles: List<RelatedArticle>,
    val moreReports: MoreReports?,
    val featuredArticles: List<FeaturedArticle>
)

data class MainArticle(
    val image: String,
    val category: String?,
    val title: String?,
    val publishedTime: String?
)

data class RelatedArticle(
    val title: String?,
    val publishedTime: String?
)

data class MoreReports(
    val label: String?,
    val count: String?
)

data class FeaturedArticle(
    val image: String,
    val title: String?
)
