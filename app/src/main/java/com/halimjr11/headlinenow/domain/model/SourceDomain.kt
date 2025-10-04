package com.halimjr11.headlinenow.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class SourceDomain(
    val id: String = "",
    val name: String = "",
    val description: String = "",
    val url: String = "",
    val category: String = "",
    val language: String = "",
    val country: String = "",
)