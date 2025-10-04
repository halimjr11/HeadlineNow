package com.halimjr11.headlinenow.data.repository

import com.halimjr11.headlinenow.domain.model.ArticleDomain
import com.halimjr11.headlinenow.utils.DomainResult

interface NewsRepository {
    suspend fun getTopHeadlines(country: String = "us"): DomainResult<List<ArticleDomain>>
    suspend fun getEverything(
        query: String? = null,
        sources: String? = null
    ): DomainResult<List<ArticleDomain>>
}