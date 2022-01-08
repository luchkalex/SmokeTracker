package com.smoketracker.presentation.screen

sealed class Screen(val route: String) {
    object VolumeScreen : Screen("volume_screen")
    object TypeScreen : Screen("type_screen")
    object EPDScreen : Screen("epd_screen")
    object PPDScreen : Screen("ppd_screen")
    object MainScreen : Screen("main_screen")
}
