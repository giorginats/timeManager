package com.example.timemanager.ui.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.timemanager.ui.models.TextFieldPaddings

@Composable
fun DefTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeHolder: String,
    padding: TextFieldPaddings? = null,
    oneLine: Boolean = true
) {
    TextField(
        singleLine = oneLine,
        maxLines = if (oneLine) {
            1
        } else Int.MAX_VALUE,
        value = value,
        onValueChange = {
            onValueChange(it)
        },
        placeholder = {
            Text(text = placeHolder)
        },
        modifier = if (padding != null) {
            Modifier
                .fillMaxWidth()
                .padding(
                    start = padding.start,
                    end = padding.end,
                    top = padding.top,
                    bottom = padding.bot
                )
        } else {
            Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp)
        }
    )
}