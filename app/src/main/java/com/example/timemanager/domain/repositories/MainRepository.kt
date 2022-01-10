package com.example.timemanager.domain.repositories

import com.example.timemanager.dataBase.entities.Task
import io.reactivex.Observable

interface MainRepository {
    fun getTasks(): Observable<List<Task>>
    fun addTask(task: Task): Observable<Boolean>
}