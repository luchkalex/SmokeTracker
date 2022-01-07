package com.smoketracker.presentation.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.smoketracker.presentation.viewmodel.VolumeViewModel

@Composable
fun VolumeScreen(navController: NavController, vm: VolumeViewModel = hiltViewModel()) {

    val volume by vm.volume.observeAsState("")

    VolumeContent(
        text = volume,
        onClick = {
            vm.saveVolume(volume)
            navController.navigate(Screen.TypeScreen.route)
        },
        onValueChange = { vm.updateVolume(it) }
    )
}

@Composable
private fun VolumeContent(
    text: String,
    onValueChange: (String) -> Unit,
    onClick: () -> Unit
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = onClick,
            ) {
                Icon(
                    Icons.Filled.ArrowForward,
                    contentDescription = "Confirm",
                )
            }
        },
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxHeight()
                .padding(15.dp),
        ) {
            TextField(
                value = text,
                onValueChange = onValueChange,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}