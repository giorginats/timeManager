package com.example.timemanager.di

import android.app.Application
import androidx.room.Room
import com.example.timemanager.dataBase.TMDataBase
import com.example.timemanager.dataBase.daos.TaskDao
import com.example.timemanager.domain.repositories.MainRepository
import com.example.timemanager.domain.repositories.MainRepositoryImpl
import com.example.timemanager.domain.repositories.dataProviders.local.LocalDataProvider
import com.example.timemanager.domain.repositories.dataProviders.local.LocalDataProviderImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalStorageModule {

    @Provides
    @Singleton
    fun provideDataBase(app: Application): TMDataBase {
        return Room.databaseBuilder(
            app,
            TMDataBase::class.java,
            "dataBase"
        ).build()
    }

    @Provides
    @Singleton
    fun provideLocalDataProvider(db: TMDataBase): LocalDataProvider {
        return LocalDataProviderImpl(db.taskDao)
    }

    @Provides
    fun provideTaskDao(db: TMDataBase): TaskDao {
        return db.taskDao
    }
}