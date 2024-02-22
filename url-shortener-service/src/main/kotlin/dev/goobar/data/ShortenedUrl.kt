package dev.goobar.data

import kotlinx.serialization.Serializable

@Serializable
data class ShortenedUrl(
    val id: Long,
    val url: String,
    val urlKey: String,
    val description: String? = null
)
