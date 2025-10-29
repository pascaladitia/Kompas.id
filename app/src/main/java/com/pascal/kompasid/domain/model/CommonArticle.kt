package com.pascal.kompasid.domain.model

data class CommonArticle(
    val isExclusive: Boolean,
    val image: String?,
    val title: String,
    val label: String?,
    val description: String?,
    val author: String?,
    val category: String?,
    val imageDescription: String?,
    val mediaCount: Int?,
    val publishedTime: String?,
    val audio: String?,
    val share: String?,
    val isFavorite: Boolean = false
)
