package com.example.timemanager.ui.mainScreen

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun MainScreen(
    viewModel: MainScreenVM = hiltViewModel()
){
    val scaffoldState = rememberScaffoldState()
    Text(text = "asdasdasdasdas")
//    Scaffold(
//        scaffoldState = scaffoldState,
//        floatingActionButton = {
//            FloatingActionButton(onClick = {
//
//            }) {
//                Icon(
//                    imageVector = Icons.Default.Add,
//                    contentDescription = "Add"
//                )
//            }
//        }
//    )
}