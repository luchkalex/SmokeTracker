package com.smoketracker.presentation.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.smoketracker.presentation.ui.AppExtendedFloatingActionButton
import com.smoketracker.presentation.ui.AppFloatingActionButton
import com.smoketracker.presentation.viewmodel.VolumeViewModel

@Composable
fun VolumeScreen(navController: NavController, vm: VolumeViewModel = hiltViewModel()) {

    val volume by vm.volume.observeAsState("")
    val started by vm.started.observeAsState(false)

    vm.getSmokingStatus()

    VolumeContent(
        started = started,
        text = volume,
        onClick = {
            vm.saveVolume(volume)
            navController.navigate(Screen.TypeScreen.route)
        },
        onValueChange = { vm.updateVolume(it) },
        onWelcomePageClick = { navController.navigate(Screen.MainScreen.route) }
    )
}

@Composable
private fun VolumeContent(
    text: String,
    onValueChange: (String) -> Unit,
    onClick: () -> Unit,
    started: Boolean,
    onWelcomePageClick: () -> Unit
) {
    if (started) {
        WelcomePage(onWelcomePageClick)
    } else {
        Scaffold(
            floatingActionButton = {
                AppFloatingActionButton(
                    onClick = onClick,
                    icon = Icons.Filled.ArrowForward,
                    contentDescription = "Confirm"
                )
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
                    modifier = Modifier.fillMaxWidth(),
                    label = { Text(text = "Volume of device")},
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
            }
        }
    }

}

@Composable
private fun WelcomePage(onClick: () -> Unit) {
    Scaffold{
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
        ) {
            AppExtendedFloatingActionButton(
                onClick = onClick,
                icon = Icons.Filled.AccountBox,
                text = "Welcome",
                contentDescription = "Welcome"
            )
        }
    }
}