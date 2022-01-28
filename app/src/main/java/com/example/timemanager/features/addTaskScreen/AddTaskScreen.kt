package com.example.timemanager.features.addTaskScreen

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.timemanager.ui.composables.DefTextField
import com.example.timemanager.ui.models.TextFieldPaddings
import com.ramcosta.composedestinations.annotation.Destination


@Destination
@Preview
@Composable
fun AddTaskScreen(
    viewModel: AddTaskScreenVM = hiltViewModel()
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        floatingActionButton = {
            FloatingActionButton(onClick = {

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

