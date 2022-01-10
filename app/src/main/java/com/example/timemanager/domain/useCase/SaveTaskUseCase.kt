package com.example.timemanager.domain.useCase

import com.example.timemanager.base.baseUseCase.BaseRxUseCaseWithRepo
import com.example.timemanager.dataBase.entities.Task
import com.example.timemanager.domain.repositories.MainRepository
import io.reactivex.Observable
import javax.inject.Inject

class SaveTaskUseCase @Inject constructor(repository: MainRepository) :
    BaseRxUseCaseWithRepo<MainRepository, Task, Boolean>(repository) {
    override fun start(arg: Task?): Observable<Boolean> {
        return repository.addTask(arg!!)
    }
}