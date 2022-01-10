package com.example.timemanager.domain.repositories

import com.example.timemanager.dataBase.entities.Task
import com.example.timemanager.domain.repositories.dataProviders.local.LocalDataProvider
import io.reactivex.Observable
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val localDataProvider: LocalDataProvider
) : MainRepository {
    override fun getTasks(): Observable<List<Task>> {
        return localDataProvider.getTasks()
    }

    override fun addTask(task: Task): Observable<Boolean> {
        return localDataProvider.addTask(task)
    }
}