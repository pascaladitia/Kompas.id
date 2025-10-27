package com.pascal.kompasid.data.remote.dtos

import kotlinx.serialization.Serializable

@Serializable
data class HotTopicsResponse(
    val section: String? = null,
    val topics: List<HotTopicItem>? = null
)

@Serializable
data class HotTopicItem(
    val title: String? = null,
    val image_description: String? = null
)
