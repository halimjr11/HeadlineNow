package com.halimjr11.headlinenow.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class ArticleDomain(
    val title: String = "",
    val description: String = "",
    val url: String = "",
    val urlToImage: String = "",
    val time: String = "",
    val source: SourceDomain = SourceDomain()
)
