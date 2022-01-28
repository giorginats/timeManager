package com.example.timemanager.features.addTaskScreen

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.timemanager.ui.composables.DefTextField
import com.example.timemanager.ui.models.TextFieldPaddings
import com.example.timemanager.util.UiEvent
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.flow.collect


@Destination
@Composable
fun AddTaskScreen(
    navigator: DestinationsNavigator,
    viewModel: AddTaskScreenVM = hiltViewModel()
) {
    val scaffoldState = rememberScaffoldState()
    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                is UiEvent.PopBackStack -> {
                    navigator.popBackStack()
                }
                is UiEvent.ShowSnackBar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.message,
                        actionLabel = event.action
                    )
                }
                else -> Unit
            }
        }
    }
    Scaffold(
        scaffoldState = scaffoldState,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        floatingActionButton = {
            FloatingActionButton(onClick = {
                viewModel.onEvent(AddTaskScreenEvent.AddTask)
            }) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = "Save"
                )
            }
        }
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            DefTextField(
                value = viewModel.title,
                onValueChange = {
                    viewModel.onEvent(AddTaskScreenEvent.OnTitleChanged(it))
                },
                placeHolder = "Task Name"
            )
            Spacer(modifier = Modifier.height(10.dp))
            DefTextField(
                value = viewModel.description,
                onValueChange = {
                    viewModel.onEvent(AddTaskScreenEvent.OnDescriptionChanged(it))
                },
                placeHolder = "Task Description"
            )
        }
    }
}

