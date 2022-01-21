package com.example.timemanager.domain.repositories

import com.example.timemanager.dataBase.entities.Task
import com.example.timemanager.domain.repositories.dataProviders.local.LocalDataProvider
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val localDataProvider: LocalDataProvider
) : MainRepository {

    override fun getTasks(): Flow<List<Task>> {
        return localDataProvider.getTasks()
    }

    override suspend fun addTask(task: Task) {
        return localDataProvider.addTask(task)
    }

    override suspend fun deleteTask(task: Task) {
        return localDataProvider.deleteTask(task)
    }
}