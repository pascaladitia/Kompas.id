package com.pascal.kompasid.domain.model

data class HotTopics(
    val section: String,
    val topics: List<Topic>
)

data class Topic(
    val title: String,
    val imageDescription: String
)
