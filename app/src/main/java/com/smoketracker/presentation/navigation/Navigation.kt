package com.smoketracker.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.smoketracker.presentation.screen.*

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.VolumeScreen.route) {
        composable(route = Screen.VolumeScreen.route) {
            VolumeScreen(navController)
        }
        composable(route = Screen.TypeScreen.route) {
            TypeScreen(navController)
        }
        composable(route = Screen.EPDScreen.route) {
            EPDScreen(navController)
        }
        composable(route = Screen.MainScreen.route) {
            MainScreen(navController)
        }
        composable(route = Screen.PPDScreen.route) {
            PPDScreen(navController)
        }
        composable(route = Screen.SleepScreen.route) {
            SleepScreen(navController)
        }
    }
}
