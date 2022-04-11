package com.example.timemanager.features.addTaskScreen

import com.example.timemanager.helper.UiState

data class AddTaskScreenState(
    val title: String? = null,
    val description: String? = null
) : UiState
