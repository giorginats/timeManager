package com.example.timemanager.features.mainScreen


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.timemanager.domain.repositories.MainRepository
import com.example.timemanager.features.destinations.AddTaskScreenDestination
import com.example.timemanager.util.GlobalUiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenVM @Inject constructor(
    private val mainRepository: MainRepository
) : ViewModel() {

    private val _uiEvent = Channel<GlobalUiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    val tasks = mainRepository.getTasks()


    fun onEvent(mainScreenEvent: MainScreenEvent) {
        when (mainScreenEvent) {
            is MainScreenEvent.CheckBoxClicked -> {
                viewModelScope.launch {
                    mainRepository.isDone(
                        mainScreenEvent.task.copy(
                            isDone = mainScreenEvent.isClicked
                        )
                    )
                }
            }

            is MainScreenEvent.OnTaskDeleteClick -> {
                viewModelScope.launch {
                    mainRepository.deleteTask(mainScreenEvent.task)
                }
            }
            MainScreenEvent.GoToAddTaskScreenEvent -> {
                sendUiEvent(GlobalUiEvent.Navigate(AddTaskScreenDestination))
            }
        }
    }

    private fun sendUiEvent(eventGlobal: GlobalUiEvent) {
        viewModelScope.launch {
            _uiEvent.send(eventGlobal)
        }
    }
}