package com.example.timemanager.features.addTaskScreen

import com.example.timemanager.helper.UiEvent

sealed class AddTaskScreenEvent: UiEvent {
    object AddTask : AddTaskScreenEvent()
    data class OnTitleChanged(val title: String) : AddTaskScreenEvent()
    data class OnDescriptionChanged(val description: String) : AddTaskScreenEvent()
}