package com.pascal.kompasid.data.remote.dtos

import kotlinx.serialization.Serializable

@Serializable
data class KabinetResponse(
    val section: String? = null,
    val articles: List<KabinetArticle>? = null
)

@Serializable
data class KabinetArticle(
    val title: String? = null,
    val description: String? = null,
    val image_description: String? = null,
    val media_count: Int? = null
)
