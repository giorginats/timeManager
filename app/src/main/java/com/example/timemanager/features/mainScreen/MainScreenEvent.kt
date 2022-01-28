package com.example.timemanager.features.mainScreen

import com.example.timemanager.dataBase.entities.Task

sealed class MainScreenEvent{
    object AddTask: MainScreenEvent()
    data class OnTaskDeleteClick(val task: Task): MainScreenEvent()
    data class CheckBoxClicked(val isClicked: Boolean): MainScreenEvent()
    object GoToAddTaskScreenEvent: MainScreenEvent()
}
