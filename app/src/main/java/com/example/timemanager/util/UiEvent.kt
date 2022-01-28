package com.example.timemanager.util

import com.example.timemanager.features.destinations.DirectionDestination

sealed class UiEvent {
    object PopBackStack : UiEvent()
    data class Navigate(val destination: DirectionDestination) : UiEvent()
    data class ShowSnackBar(
        val message: String,
        val action: String? = null
    ) : UiEvent()
    data class Something(val sasda: String) : UiEvent()
}
