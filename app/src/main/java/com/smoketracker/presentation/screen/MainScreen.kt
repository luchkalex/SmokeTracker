package com.smoketracker.presentation.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.smoketracker.presentation.ui.AppExtendedFloatingActionButton
import com.smoketracker.presentation.ui.AppFloatingActionButton
import com.smoketracker.presentation.viewmodel.MainViewModel
import com.smoketracker.ui.theme.Primary
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun MainScreen(navController: NavController, vm: MainViewModel = hiltViewModel()) {

    val started by vm.started.observeAsState(false)
    val volumeLeft by vm.volumeLeft.observeAsState(0)
    val daysLeft by vm.daysLeft.observeAsState(0.0)
    val balance by vm.balance.observeAsState(0)
    val paused by vm.paused.observeAsState(false)
    val updatingPeriod by vm.updatingPeriod.observeAsState(0.0)
    val reset = remember {
        mutableStateOf(false)
    }
    val resetTime = remember {
        mutableStateOf(5)
    }
    val resetClicked = remember {
        mutableStateOf(false)
    }

    LaunchedEffect(key1 = Unit) {
        vm.init()
    }

    val scope = rememberCoroutineScope()

    MainContent(
        started = started,
        volumeLeft = volumeLeft,
        daysLeft = daysLeft,
        balance = balance,
        mainButtonIcon = if (started) Icons.Filled.Add else Icons.Filled.PlayArrow,
        mainButtonText = if (started) "Puff" else "Start",
        onResetButtonClick = {
            resetClicked.value = true
            scope.launch {
                while (resetTime.value != 0) {
                    resetTime.value--
                    delay(1000)
                }
                if (resetClicked.value) {
                    vm.reset()
                    navController.navigate(Screen.VolumeScreen.route)
                } else {
                    resetTime.value = 5
                }
            }
        },
        onMainButtonClick = { if (started) vm.makePuff() else vm.startSmoking() },
        onPauseButtonClick = { if (paused) vm.continueSmoking() else vm.pause() },
        onSleepButtonClick = { navController.navigate(Screen.SleepScreen.route) },
        pauseButtonIcon = if (paused) Icons.Filled.PlayArrow else Icons.Outlined.Clear,
        pauseButtonText = if (paused) "Continue" else "Pause",
        updatingPeriod = updatingPeriod,
        resetTime = resetTime.value,
        resetClicked = resetClicked.value,
        onCancelClicked = {
            resetClicked.value = false
        }
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
    started: Boolean,
    updatingPeriod: Double,
    onSleepButtonClick: () -> Unit,
    resetClicked: Boolean,
    resetTime: Int,
    onCancelClicked: () -> Unit
) {
    Scaffold(
    ) {
        //Select
        Box(contentAlignment = Alignment.BottomCenter) {
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
                Text(text = "Updating period $updatingPeriod minutes")
                Spacer(modifier = Modifier.padding(15.dp))
                Text(text = "$balance", style = TextStyle(fontSize = 30.sp))
                Spacer(modifier = Modifier.padding(15.dp))
                AppExtendedFloatingActionButton(
                    onClick = onMainButtonClick,
                    icon = mainButtonIcon,
                    text = mainButtonText,
                    contentDescription = mainButtonText
                )
                if (started) {
                    Spacer(modifier = Modifier.padding(15.dp))
                    AppExtendedFloatingActionButton(
                        onClick = onPauseButtonClick,
                        icon = pauseButtonIcon,
                        text = pauseButtonText,
                        contentDescription = pauseButtonText
                    )
                }

            }
            Row(
                modifier = Modifier
                    .padding(15.dp)
                    .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
            ) {
                if (resetClicked) {
                    FloatingActionButton(
                        onClick = onCancelClicked,
                        backgroundColor = Primary,
                    ) {
                        Text(text = resetTime.toString())
                    }
                } else {
                    AppFloatingActionButton(
                        onClick = onResetButtonClick,
                        contentDescription = "Reset",
                        icon = Icons.Filled.Delete
                    )
                }
                AppFloatingActionButton(
                    onClick = onSleepButtonClick,
                    contentDescription = "Sleep",
                    icon = Icons.Filled.KeyboardArrowDown
                )
            }
        }
    }
}