package com.example.timemanager.ui.mainScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun MainScreen(
//    onNavigate: (UiEvent.Navigate) -> Unit,
    viewModel: MainScreenVM = hiltViewModel()
) {
    val task = viewModel.tasks.collectAsState(initial = emptyList())
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(task.value) { task ->
            TaskItem(
                task = task,
                onEvent = viewModel::onEvent,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
//                        viewModel.onEvent(MainScreenEvent.OnTaskDeleteClick(task))
                    }
                    .padding(16.dp)
            )
        }
    }
}