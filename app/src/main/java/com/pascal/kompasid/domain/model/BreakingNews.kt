package com.pascal.kompasid.domain.model

data class BreakingNews(
    val headline: String,
    val subheadline: String?,
    val publishedTime: String?,
    val source: String?,
    val articles: List<BreakingNewsArticle>
)

data class BreakingNewsArticle(
    val title: String,
    val publishedTime: String
)
