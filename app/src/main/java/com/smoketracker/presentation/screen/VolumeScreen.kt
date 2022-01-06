package com.smoketracker.presentation.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.smoketracker.presentation.viewmodel.MainViewModel

@Composable
fun VolumeScreen (vm: MainViewModel = hiltViewModel()) {

    val volume by vm.volume.observeAsState("")

    VolumeContent(
        text = volume,
        onClick = { vm.saveVolume(volume) },
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
                    Icons.Filled.Add,
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
            Text(text)
            TextField(
                value = text,
                onValueChange = onValueChange,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}