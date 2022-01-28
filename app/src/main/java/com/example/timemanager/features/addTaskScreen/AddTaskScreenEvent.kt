package com.example.timemanager.features.addTaskScreen

sealed class AddTaskScreenEvent {
    object AddTask : AddTaskScreenEvent()
    data class OnTitleChanged(val title: String) : AddTaskScreenEvent()
    data class OnDescriptionChanged(val description: String) : AddTaskScreenEvent()
}