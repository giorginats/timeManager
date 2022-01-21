package com.example.timemanager.domain.repositories.dataProviders.local

import com.example.timemanager.dataBase.entities.Task
import kotlinx.coroutines.flow.Flow

interface LocalDataProvider {
    fun getTasks(): Flow<List<Task>>
    suspend fun addTask(task: Task)
    suspend fun deleteTask(task: Task)
}