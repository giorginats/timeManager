package com.example.timemanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.timemanager.ui.mainScreen.MainScreen
import com.example.timemanager.ui.mainScreen.NavGraphs
import com.example.timemanager.ui.theme.TimeManagerTheme
import com.example.timemanager.util.Routes
import com.ramcosta.composedestinations.DestinationsNavHost
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TimeManagerTheme {
                DestinationsNavHost(navGraph = NavGraphs.root)
            }
        }
    }
}

//val navController = rememberNavController()
//NavHost(
//navController = navController,
//startDestination = Routes.MAIN_SCREEN
//){
//    composable(Routes.MAIN_SCREEN){
//        MainScreen(
//        )
//    }
//}