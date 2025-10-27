package com.pascal.kompasid.domain.model

data class PonAcehSumut(
    val section: String,
    val articles: List<PonArticle>
)

data class PonArticle(
    val title: String,
    val label: String?,
    val description: String?,
    val imageDescription: String?
)
