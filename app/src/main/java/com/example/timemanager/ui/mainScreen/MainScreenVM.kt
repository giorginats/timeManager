package com.example.timemanager.ui.mainScreen


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.timemanager.dataBase.entities.Task
import com.example.timemanager.domain.repositories.MainRepository
import com.example.timemanager.ui.destinations.AddTaskScreenDestination
import com.example.timemanager.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenVM @Inject constructor(
    private val mainRepository: MainRepository
) : ViewModel() {

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    val tasks = mainRepository.getTasks()


    fun onEvent(mainScreenEvent: MainScreenEvent) {
        when (mainScreenEvent) {
            MainScreenEvent.AddTask -> {

            }
            is MainScreenEvent.CheckBoxClicked -> {
                viewModelScope.launch {
                    mainRepository.addTask(Task(taskName = "blabla", description = "Asdasdasdad"))
                }
            }

            is MainScreenEvent.OnTaskDeleteClick -> {
                viewModelScope.launch {
                    mainRepository.deleteTask(mainScreenEvent.task)
                }
            }
            MainScreenEvent.GoToAddTaskScreenEvent -> {
                sendUiEvent(UiEvent.Navigate(AddTaskScreenDestination))
            }
        }
    }

    private fun sendUiEvent(event: UiEvent) {
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }
}