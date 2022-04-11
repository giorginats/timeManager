package com.example.timemanager.features.addTaskScreen

import androidx.lifecycle.viewModelScope
import com.example.timemanager.base.BaseViewModel
import com.example.timemanager.dataBase.entities.Task
import com.example.timemanager.domain.repositories.MainRepository
import com.example.timemanager.util.GlobalUiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddTaskScreenVM @Inject constructor(
    private val mainRepository: MainRepository
) : BaseViewModel<AddTaskScreenEvent, AddTaskScreenState>() {

    override fun createInitialState(): AddTaskScreenState {
        return AddTaskScreenState()
    }

    override fun onEvent(event: AddTaskScreenEvent) {
        when (event) {
            AddTaskScreenEvent.AddTask -> {
                viewModelScope.launch {
                    if (state.value.title == null || state.value.title == "") {
                        sendGlobalUiEvent(
                            GlobalUiEvent.ShowSnackBar(
                                message = "The title can't be empty"
                            )
                        )
                        return@launch
                    }
                    mainRepository.addTask(
                        Task(
                            taskName = state.value.title!!,
                            description = state.value.description ?: ""
                        )
                    )
                    sendGlobalUiEvent(GlobalUiEvent.PopBackStack)
                }
            }
            is AddTaskScreenEvent.OnDescriptionChanged -> {
                setState {
                    copy(description = event.description)
                }
            }
            is AddTaskScreenEvent.OnTitleChanged -> {
                setState {
                    copy(title = event.title)
                }
            }
        }
    }
}