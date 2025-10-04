package com.halimjr11.headlinenow.di

import com.halimjr11.headlinenow.data.repository.NewsRepository
import com.halimjr11.headlinenow.domain.usecase.GetRecommendedUseCase
import com.halimjr11.headlinenow.domain.usecase.GetTopHeadlineUseCase
import com.halimjr11.headlinenow.utils.coroutines.CoroutineDispatcherProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {
    @Provides
    @Singleton
    fun provideGetTopHeadlineUseCase(
        repository: NewsRepository,
        dispatcher: CoroutineDispatcherProvider
    ): GetTopHeadlineUseCase {
        return GetTopHeadlineUseCase(repository, dispatcher)
    }

    @Provides
    @Singleton
    fun provideGetRecommendedUseCase(
        repository: NewsRepository,
        dispatcher: CoroutineDispatcherProvider
    ): GetRecommendedUseCase {
        return GetRecommendedUseCase(repository, dispatcher)
    }
}
