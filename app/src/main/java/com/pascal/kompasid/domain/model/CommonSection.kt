package com.pascal.kompasid.domain.model

data class CommonSection(
    val headline: String?,
    val section: String,
    val category: String?,
    val isExclusive: Boolean,
    val moreLink: String?,
    val articles: List<CommonArticle>,
    val topics: List<CommonArticle>
)

data class CommonArticle(
    val isExclusive: Boolean,
    val image: String?,
    val title: String,
    val label: String?,
    val description: String?,
    val author: String?,
    val imageDescription: String?,
    val mediaCount: Int?,
    val publishedTime: String?,
    val audio: String?,
    val share: String?
)
