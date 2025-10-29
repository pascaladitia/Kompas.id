package com.pascal.kompasid.domain.model

import kotlinx.serialization.Serializable

@Serializable
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

fun getSampleArticles() = CommonArticle(
    isExclusive = false,
    image = null,
    title = "Judul Artikel Contoh",
    label = "Berita Terkini",
    description = "Ini adalah deskripsi singkat artikel yang digunakan untuk preview layout.",
    author = "Redaksi Kompas",
    category = "Nasional",
    imageDescription = "Ilustrasi gambar berita",
    mediaCount = 3,
    publishedTime = "2025-10-29T12:00:00Z",
    audio = null,
    share = "https://kompas.id/example-article",
    isFavorite = false
)
