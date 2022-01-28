package com.example.timemanager.features.mainScreen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Checkbox
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.timemanager.dataBase.entities.Task


@Composable
fun TaskItem(
    task: Task,
    onEvent: (MainScreenEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = task.taskName,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.width(8.dp))
                IconButton(onClick = {
                    onEvent(MainScreenEvent.OnTaskDeleteClick(task))
                }) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Delete"
                    )
                }
            }
            task.description?.let {
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = it)
            }
        }
        Checkbox(
            checked = task.isDone,
            onCheckedChange = { isChecked ->
                onEvent(MainScreenEvent.CheckBoxClicked(isChecked))
            }
        )
    }
}