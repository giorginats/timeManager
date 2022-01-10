package com.example.timemanager.domain.repositories.dataProviders.local

import com.example.timemanager.dataBase.daos.TaskDao
import com.example.timemanager.dataBase.entities.Task
import io.reactivex.Observable
import javax.inject.Inject

class LocalDataProviderImpl @Inject constructor(
    private val taskDao: TaskDao
) : LocalDataProvider {

    override fun getTasks(): Observable<List<Task>> {
        return taskDao.getTasks().toObservable()
    }

    override fun addTask(task: Task): Observable<Boolean> {
        return Observable.fromCallable {
            taskDao.addTask(task)
            true
        }
    }
}