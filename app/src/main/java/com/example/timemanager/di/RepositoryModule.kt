package com.example.timemanager.di

import com.example.timemanager.domain.repositories.MainRepository
import com.example.timemanager.domain.repositories.MainRepositoryImpl
import com.example.timemanager.domain.repositories.dataProviders.local.LocalDataProviderImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    @Singleton
    fun provideMainRepository(localDP: LocalDataProviderImpl): MainRepository {
        return MainRepositoryImpl(localDP)
    }
}