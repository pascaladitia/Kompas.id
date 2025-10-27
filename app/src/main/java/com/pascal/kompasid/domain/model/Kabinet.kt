package com.pascal.kompasid.domain.model

data class Kabinet(
    val section: String,
    val articles: List<KabinetArticle>
)

data class KabinetArticle(
    val title: String,
    val description: String?,
    val imageDescription: String?,
    val mediaCount: Int?
)
