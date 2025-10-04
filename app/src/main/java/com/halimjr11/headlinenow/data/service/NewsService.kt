package com.halimjr11.headlinenow.data.service

import com.halimjr11.headlinenow.BuildConfig.NEWS_API_KEY
import com.halimjr11.headlinenow.data.model.ArticleResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {
    @GET("top-headlines")
    suspend fun fetchTopHeadlines(
        @Query("country") country: String = "us",
        @Query("apiKey") key: String = NEWS_API_KEY
    ): ArticleResponse

    @GET("everything")
    suspend fun fetchEverything(
        @Query("q") query: String? = null,
        @Query("sources") sources: String? = null,
        @Query("language") language: String = "en",
        @Query("pageSize") pageSize: Int = 5,
        @Query("apiKey") apiKey: String = NEWS_API_KEY
    ): ArticleResponse
}