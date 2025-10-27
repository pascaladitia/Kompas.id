package com.pascal.kompasid.data.remote.dtos

import kotlinx.serialization.Serializable

@Serializable
data class ArticlesResponse(
    val articles: List<ArticleItem>? = null
)

@Serializable
data class ArticleItem(
    val title: String? = null,
    val description: String? = null,
    val label: String? = null,
    val image_description: String? = null
)
