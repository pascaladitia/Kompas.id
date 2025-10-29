package com.pascal.kompasid.domain.model

data class BreakingNews(
    val image: String,
    val headline: String,
    val subheadline: String?,
    val publishedTime: String?,
    val source: String?,
    val articles: List<CommonArticle>
)