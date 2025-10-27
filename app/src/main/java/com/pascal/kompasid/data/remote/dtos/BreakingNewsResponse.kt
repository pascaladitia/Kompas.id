package com.pascal.kompasid.data.remote.dtos

import kotlinx.serialization.Serializable

@Serializable
data class BreakingNewsResponse(
    val image: String? = null,
    val headline: String? = null,
    val subheadline: String? = null,
    val published_time: String? = null,
    val articles: List<BreakingNewsArticle>? = null,
    val source: String? = null
)

@Serializable
data class BreakingNewsArticle(
    val title: String? = null,
    val published_time: String? = null
)
