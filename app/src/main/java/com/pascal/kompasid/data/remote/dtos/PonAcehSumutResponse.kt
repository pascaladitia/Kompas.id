package com.pascal.kompasid.data.remote.dtos

import kotlinx.serialization.Serializable

@Serializable
data class PonAcehSumutResponse(
    val section: String? = null,
    val articles: List<PonArticle>? = null
)

@Serializable
data class PonArticle(
    val title: String? = null,
    val label: String? = null,
    val description: String? = null,
    val image_description: String? = null
)
