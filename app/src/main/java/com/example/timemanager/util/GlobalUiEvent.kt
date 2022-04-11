package com.example.timemanager.util

import com.example.timemanager.features.destinations.DirectionDestination

sealed class GlobalUiEvent {
    object PopBackStack : GlobalUiEvent()
    data class Navigate(val destination: DirectionDestination) : GlobalUiEvent()
    data class ShowSnackBar(
        val message: String,
        val action: String? = null
    ) : GlobalUiEvent()
}
