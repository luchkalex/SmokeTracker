package com.smoketracker.presentation.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.smoketracker.presentation.navigation.Screen
import com.smoketracker.presentation.screen.VolumeScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.VolumeScreen.route) {
        composable(route = Screen.VolumeScreen.route) {
            VolumeScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NavigationPreview() {
    Scaffold(
        floatingActionButton = {
        FloatingActionButton(
            onClick = {},
        ){
            Icon(
                Icons.Filled.Add,
                contentDescription = "Localized description",
            )
        }
    },
    ){
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxHeight().padding(15.dp),
        ) {
            TextField(
                value = "asdf",
                onValueChange = {

                },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun CustomBox(color: Color, size: Dp = 50.dp, content: @Composable BoxScope.() -> Unit = {}) {
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier
            .background(color)
            .width(size)
            .height(size)) {
        content()
    }
}