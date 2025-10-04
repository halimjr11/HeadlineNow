package com.halimjr11.headlinenow.di

import com.halimjr11.headlinenow.utils.coroutines.CoroutineDispatcherProvider
import com.halimjr11.headlinenow.utils.coroutines.impl.DefaultDispatcherProvider
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class CoroutinesModule {
    @Binds
    abstract fun provideCoroutineProvider(impl: DefaultDispatcherProvider): CoroutineDispatcherProvider
}
