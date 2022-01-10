package com.example.timemanager.ui.mainScreen

import androidx.lifecycle.ViewModel
import com.example.timemanager.base.BaseViewModel
import com.example.timemanager.common.async
import com.example.timemanager.dataBase.entities.Task
import com.example.timemanager.domain.repositories.MainRepository
import com.example.timemanager.domain.useCase.GetTasksUseCase
import com.example.timemanager.domain.useCase.SaveTaskUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainScreenVM @Inject constructor(
    private val getTasksUseCase: GetTasksUseCase,
    private val saveTaskUseCase: SaveTaskUseCase
) : BaseViewModel() {
    init {
        getTasks()
    }

    private fun getTasks() {
        registerDisposable(
            getTasksUseCase.start()
                .map {
                    val variable = it
                }
                .onErrorReturn {

                }
                .async()
                .subscribe()
        )
    }

    private fun saveTask() {
        saveTaskUseCase.start(Task(taskName = "pirveli"))
            .map {

            }
            .async()
            .subscribe()
    }
}