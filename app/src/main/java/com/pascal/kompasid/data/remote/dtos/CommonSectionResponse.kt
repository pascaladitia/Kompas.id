package com.pascal.kompasid.data.remote.dtos

import kotlinx.serialization.Serializable

@Serializable
data class CommonSectionResponse(
    val section: String? = null,
    val articles: List<CommonArticle>? = null
)

@Serializable
data class CommonArticle(
    val image: String? = null,
    val title: String? = null,
    val label: String? = null,
    val description: String? = null,
    val image_description: String? = null,
    val media_count: Int? = null,
    val published_time: String? = null
)
