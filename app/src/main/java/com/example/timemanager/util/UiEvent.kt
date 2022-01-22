package com.example.timemanager.util

import com.example.timemanager.ui.destinations.DirectionDestination
import java.util.*

sealed class UiEvent {
    object PopBackStack : UiEvent()
    data class Navigate(val destination: DirectionDestination) : UiEvent()
    data class ShowSnackBar(
        val message: String,
        val action: String? = null
    ) : UiEvent()
}
