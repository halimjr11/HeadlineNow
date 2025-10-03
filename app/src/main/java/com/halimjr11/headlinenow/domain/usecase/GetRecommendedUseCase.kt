package com.halimjr11.headlinenow.domain.usecase

import com.halimjr11.headlinenow.data.repository.NewsRepository
import com.halimjr11.headlinenow.domain.model.ArticleDomain
import com.halimjr11.headlinenow.utils.DomainResult
import com.halimjr11.headlinenow.utils.coroutines.CoroutineDispatcherProvider
import kotlinx.coroutines.withContext

class GetRecommendedUseCase(
    private val repository: NewsRepository,
    private val dispatcher: CoroutineDispatcherProvider
) {
    suspend operator fun invoke(
        articleDomain: ArticleDomain
    ): List<ArticleDomain> = withContext(dispatcher.io) {
        val sources = articleDomain.source.id.takeIf { !it.isBlank() }
        val query = if (sources == null) articleDomain.title else null
        val result = repository.getEverything(query = query, sources = sources)
        return@withContext if (result is DomainResult.Success) {
            result.data
        } else {
            emptyList()
        }
    }
}