package com.halimjr11.headlinenow.data.mapper.impl

import com.halimjr11.headlinenow.data.mapper.NewsDataMapper
import com.halimjr11.headlinenow.data.model.ArticleResponse
import com.halimjr11.headlinenow.domain.model.ArticleDomain
import com.halimjr11.headlinenow.domain.model.SourceDomain
import com.halimjr11.headlinenow.utils.coroutines.CoroutineDispatcherProvider
import kotlinx.coroutines.withContext
import java.time.Duration
import java.time.Instant

class NewsDataMapperImpl(private val dispatchers: CoroutineDispatcherProvider) : NewsDataMapper {
    override suspend fun mapResponseToDomain(resp: ArticleResponse): List<ArticleDomain> =
        withContext(dispatchers.io) {
            resp.articles?.let { articles ->
                articles.map { article ->
                    ArticleDomain(
                        title = article?.title.orEmpty(),
                        description = article?.description.orEmpty(),
                        url = article?.url.orEmpty(),
                        urlToImage = article?.urlToImage.orEmpty(),
                        source = mapSourceToDomain(source = article?.source),
                        time = formatRelativeTime(
                            isoDate = article?.publishedAt.orEmpty()
                        )
                    )
                }
            }.orEmpty()
        }

    private fun mapSourceToDomain(source: ArticleResponse.Source?): SourceDomain =
        source?.let { data ->
            SourceDomain(
                id = data.id.orEmpty(),
                name = data.name.orEmpty(),
                description = data.description.orEmpty(),
                url = data.url.orEmpty(),
                category = data.category.orEmpty(),
                language = data.language.orEmpty(),
                country = data.country.orEmpty()
            )
        } ?: SourceDomain()

    private fun formatRelativeTime(isoDate: String): String {
        return try {
            val time = Instant.parse(isoDate)
            val now = Instant.now()
            val duration = Duration.between(time, now)

            val seconds = duration.seconds
            val minutes = seconds / 60
            val hours = minutes / 60
            val days = hours / 24
            val months = days / 30
            val years = days / 365

            when {
                seconds < 60 -> "$seconds sec ago"
                minutes < 60 -> "$minutes min ago"
                hours < 24 -> "$hours hr ago"
                days < 30 -> "$days d ago"
                months < 12 -> "$months mo ago"
                else -> "$years yr ago"
            }
        } catch (e: Exception) {
            ""
        }
    }
}