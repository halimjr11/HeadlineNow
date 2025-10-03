package com.halimjr11.headlinenow.data.mapper

import com.halimjr11.headlinenow.data.model.ArticleResponse
import com.halimjr11.headlinenow.domain.model.ArticleDomain

interface NewsDataMapper {
    suspend fun mapResponseToDomain(resp : ArticleResponse) : List<ArticleDomain>
}