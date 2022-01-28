package com.example.timemanager.features.addTaskScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.timemanager.dataBase.entities.Task
import com.example.timemanager.domain.repositories.MainRepository
import com.example.timemanager.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddTaskScreenVM @Inject constructor(
    private val mainRepository: MainRepository
) : ViewModel() {

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    var title by mutableStateOf("")
        private set

    var description by mutableStateOf("")
        private set

    fun onEvent(screenEvent: AddTaskScreenEvent) {
        when (screenEvent) {
            AddTaskScreenEvent.AddTask -> {
                viewModelScope.launch {
                    mainRepository.addTask(Task(taskName = "blabla", description = "Asdasdasdad"))
                }
            }
            is AddTaskScreenEvent.OnDescriptionChanged -> {
                description = screenEvent.description
            }
            is AddTaskScreenEvent.OnTitleChanged -> {
                title = screenEvent.title
            }
        }
    }

}