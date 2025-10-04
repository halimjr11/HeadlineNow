package com.halimjr11.headlinenow.di

import com.halimjr11.headlinenow.data.repository.NewsRepository
import com.halimjr11.headlinenow.data.repository.impl.NewsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun provideNewsRepositoryProvide(impl: NewsRepositoryImpl): NewsRepository
}
