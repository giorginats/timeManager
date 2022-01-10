package com.example.timemanager.domain.useCase

import com.example.timemanager.base.baseUseCase.BaseRxUseCaseWithRepo
import com.example.timemanager.dataBase.entities.Task
import com.example.timemanager.domain.repositories.MainRepository
import io.reactivex.Observable
import javax.inject.Inject

class GetTasksUseCase @Inject constructor(repository: MainRepository) :
    BaseRxUseCaseWithRepo<MainRepository, Unit, List<Task>>(repository) {
    override fun start(arg: Unit?): Observable<List<Task>> {
        return repository.getTasks()
    }
}