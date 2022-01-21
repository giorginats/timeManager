package com.example.timemanager.domain.repositories.dataProviders.local

import com.example.timemanager.dataBase.daos.TaskDao
import com.example.timemanager.dataBase.entities.Task
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataProviderImpl @Inject constructor(
    private val taskDao: TaskDao
) : LocalDataProvider {

    override fun getTasks(): Flow<List<Task>> {
        return taskDao.getTasks()
    }

    override suspend fun addTask(task: Task) {
        return taskDao.addTask(task)
    }

    override suspend fun deleteTask(task: Task) {
        return taskDao.deleteTask(task)
    }
}