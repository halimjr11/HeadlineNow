package com.halimjr11.headlinenow.di

import com.halimjr11.headlinenow.data.mapper.NewsDataMapper
import com.halimjr11.headlinenow.data.mapper.impl.NewsDataMapperImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class MapperModule {
    @Binds
    abstract fun provideNewsDataMapperProvider(impl: NewsDataMapperImpl): NewsDataMapper
}
