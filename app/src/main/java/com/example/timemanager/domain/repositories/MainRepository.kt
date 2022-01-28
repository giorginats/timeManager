package com.example.timemanager.domain.repositories

import com.example.timemanager.dataBase.entities.Task
import kotlinx.coroutines.flow.Flow

interface MainRepository {
    fun getTasks(): Flow<List<Task>>
    suspend fun addTask(task: Task)
    suspend fun deleteTask(task: Task)
    suspend fun isDone(task: Task)
}