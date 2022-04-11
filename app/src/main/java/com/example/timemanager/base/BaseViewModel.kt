package com.example.timemanager.base

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.timemanager.helper.UiEvent
import com.example.timemanager.helper.UiState
import com.example.timemanager.util.GlobalUiEvent
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<EVENT: UiEvent, STATE: UiState>: ViewModel() {

    private val _uiEvent = Channel<GlobalUiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    private val initialState : STATE by lazy { createInitialState() }
    abstract fun createInitialState() : STATE

    private val _state = MutableStateFlow(initialState)
    val state: StateFlow<STATE> = _state.asStateFlow()


    fun setState(reduce: STATE.() -> STATE) {
        _state.tryEmit(_state.value.reduce())
    }

    abstract fun onEvent(event: EVENT)

    protected fun sendGlobalUiEvent(event: GlobalUiEvent) {
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }
}