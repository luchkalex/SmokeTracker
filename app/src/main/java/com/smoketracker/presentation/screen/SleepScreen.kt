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
import com.smoketracker.presentation.viewmodel.SleepViewModel

@Composable
fun SleepScreen(navController: NavController, vm: SleepViewModel = hiltViewModel()) {

    val sleepTime by vm.sleepTime.observeAsState("")

    SleepContent(
        text = sleepTime,
        onClick = {
            vm.saveSleepTime(sleepTime)
            navController.popBackStack()
        },
        onValueChange = { vm.updateSleepTime(it) },
    )
}

@Composable
private fun SleepContent(
    text: String,
    onValueChange: (String) -> Unit,
    onClick: () -> Unit,
) {
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
                label = { Text(text = "Slept time (minutes)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
        }
    }
}