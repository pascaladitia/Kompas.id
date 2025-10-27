package com.pascal.kompasid.domain.model

data class CommonSection(
    val section: String,
    val articles: List<CommonArticle>
)

data class CommonArticle(
    val image: String,
    val title: String,
    val label: String?,
    val description: String?,
    val imageDescription: String?,
    val mediaCount: Int?,
    val publishedTime: String?
)
