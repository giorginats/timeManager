package com.example.timemanager.ui.mainScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.timemanager.ui.mainScreen.destinations.DetailsScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination(start = true)
@Composable
fun MainScreen(
    navigator: DestinationsNavigator,
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
                        navigator.navigate(DetailsScreenDestination)
                    }
                    .padding(16.dp)
            )
        }
    }
}

@Destination
@Composable
fun DetailsScreen() {
    Text("Profile Screen:", textAlign = TextAlign.Center)
}