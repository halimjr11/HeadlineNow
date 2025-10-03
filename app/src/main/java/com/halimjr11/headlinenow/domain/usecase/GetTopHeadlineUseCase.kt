package com.halimjr11.headlinenow.domain.usecase

import com.halimjr11.headlinenow.data.repository.NewsRepository
import com.halimjr11.headlinenow.domain.model.ArticleDomain
import com.halimjr11.headlinenow.utils.DomainResult
import com.halimjr11.headlinenow.utils.coroutines.CoroutineDispatcherProvider
import kotlinx.coroutines.withContext

class GetTopHeadlineUseCase(
    private val repository: NewsRepository,
    private val dispatcher: CoroutineDispatcherProvider
) {
    suspend operator fun invoke(): List<ArticleDomain> = withContext(dispatcher.io) {
        val result = repository.getTopHeadlines()
        return@withContext if (result is DomainResult.Success) {
            result.data
        } else {
            emptyList()
        }
    }
}