package com.halimjr11.headlinenow.data.repository.impl

import com.halimjr11.headlinenow.data.mapper.NewsDataMapper
import com.halimjr11.headlinenow.data.repository.NewsRepository
import com.halimjr11.headlinenow.data.service.NewsService
import com.halimjr11.headlinenow.domain.model.ArticleDomain
import com.halimjr11.headlinenow.utils.DomainResult
import com.halimjr11.headlinenow.utils.coroutines.CoroutineDispatcherProvider
import kotlinx.coroutines.withContext

class NewsRepositoryImpl(
    private val apiService: NewsService,
    private val dispatcherProvider: CoroutineDispatcherProvider,
    private val mapper: NewsDataMapper
) : NewsRepository {
    override suspend fun getTopHeadlines(
        country: String
    ): DomainResult<List<ArticleDomain>> = withContext(dispatcherProvider.io) {
        try {
            val response = apiService.fetchTopHeadlines(
                country = country,
                key = ""
            )
            DomainResult.Success(mapper.mapResponseToDomain(response))
        } catch (e: Exception) {
            DomainResult.Error(e)
        }
    }

    override suspend fun getEverything(
        query: String?,
        sources: String?
    ): DomainResult<List<ArticleDomain>> = withContext(dispatcherProvider.io) {
        try {
            val response = apiService.fetchEverything(
                query = query,
                sources = sources,
                apiKey = ""
            )
            DomainResult.Success(mapper.mapResponseToDomain(response))
        } catch (e: Exception) {
            DomainResult.Error(e)
        }
    }
}