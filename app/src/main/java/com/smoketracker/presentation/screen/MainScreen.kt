package com.smoketracker.presentation.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.smoketracker.presentation.viewmodel.MainViewModel

@Composable
fun MainScreen(navController: NavController, vm: MainViewModel = hiltViewModel()) {

    val started by vm.started.observeAsState(false)
    val volumeLeft by vm.volumeLeft.observeAsState(0)
    val daysLeft by vm.daysLeft.observeAsState(0.0)
    val balance by vm.balance.observeAsState(0)
    val paused by vm.paused.observeAsState(false)

    MainContent(
        started = started,
        volumeLeft = volumeLeft,
        daysLeft = daysLeft,
        balance = balance,
        mainButtonIcon = if (started) Icons.Filled.Add else Icons.Filled.PlayArrow,
        mainButtonText = if (started) "Puff" else "Start",
        onResetButtonClick = {
            vm.reset()
            navController.navigate(Screen.VolumeScreen.route)
        },
        onMainButtonClick = { if (started) vm.makePuff() else vm.startSmoking() },
        onPauseButtonClick = { if (paused) vm.continueSmoking() else vm.pause() },
        pauseButtonIcon = if (paused) Icons.Filled.PlayArrow else Icons.Outlined.Clear,
        pauseButtonText = if (paused) "Continue" else "Pause",
    )
}

@Composable
private fun MainContent(
    volumeLeft: Int,
    daysLeft: Double,
    balance: Int,
    mainButtonIcon: ImageVector,
    mainButtonText: String,
    pauseButtonIcon: ImageVector,
    pauseButtonText: String,
    onResetButtonClick: () -> Unit,
    onMainButtonClick: () -> Unit,
    onPauseButtonClick: () -> Unit,
    started: Boolean
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = onResetButtonClick,
            ) {
                Icon(
                    Icons.Filled.Delete,
                    contentDescription = "Reset",
                )
            }
        },
    ) {
        //Select
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
        ) {
            Text(text = "Volume left $volumeLeft")
            Spacer(modifier = Modifier.padding(15.dp))
            Text(text = "Time left $daysLeft")
            Spacer(modifier = Modifier.padding(15.dp))
            Text(text = "$balance", style = TextStyle(fontSize = 30.sp))
            Spacer(modifier = Modifier.padding(15.dp))
            ExtendedFloatingActionButton(
                onClick = onMainButtonClick,
                icon = {
                    Icon(
                        mainButtonIcon,
                        contentDescription = mainButtonText
                    )
                },
                text = { Text(text = mainButtonText) }
            )
            if (started){
                Spacer(modifier = Modifier.padding(15.dp))
                ExtendedFloatingActionButton(
                    onClick = onPauseButtonClick,
                    icon = {
                        Icon(
                            pauseButtonIcon,
                            contentDescription = pauseButtonText
                        )
                    },
                    text = { Text(text = pauseButtonText) }
                )
            }

        }
    }
}