package com.smoketracker.presentation.screen

sealed class Screen(val route: String) {
    object VolumeScreen : Screen("volume_screen")
    object CalculationScreen : Screen("calculation_screen")
}
