package com.example.timemanager.domain.repositories.dataProviders.local

import com.example.timemanager.dataBase.entities.Task
import io.reactivex.Observable

interface LocalDataProvider {
    fun getTasks(): Observable<List<Task>>
    fun addTask(task: Task): Observable<Boolean>
}