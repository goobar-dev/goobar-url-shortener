package dev.goobar.data

import kotlinx.serialization.Serializable

@Serializable
data class ShortenUrlRequestBody(
    val url: String,
    val description: String? = null
)