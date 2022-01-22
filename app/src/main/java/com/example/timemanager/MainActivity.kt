package com.example.timemanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.timemanager.ui.NavGraphs
import com.example.timemanager.ui.theme.TimeManagerTheme
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