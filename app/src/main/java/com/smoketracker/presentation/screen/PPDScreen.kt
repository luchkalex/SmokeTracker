package com.smoketracker.presentation.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
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
import com.smoketracker.presentation.ui.AppFloatingActionButton
import com.smoketracker.presentation.viewmodel.PPDViewModel

@Composable
fun PPDScreen(navController: NavController, vm: PPDViewModel = hiltViewModel()) {

    val PPD by vm.PPD.observeAsState("")

    EPDContent(
        onClick = {
            vm.saveExpenseData()
            navController.navigate(Screen.MainScreen.route)
        },
        onPPDValueChanged = {
            vm.updatePPD(it)
        },
        PPD = PPD
    )
}

@Composable
private fun EPDContent(
    onClick: () -> Unit,
    onPPDValueChanged: (String) -> Unit,
    PPD: String,
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
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(15.dp),
            ) {
                TextField(
                    value = PPD,
                    onValueChange = onPPDValueChanged,
                    modifier = Modifier.fillMaxWidth(),
                    label = { Text(text = "Puffs per day")},
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
            }
        }
    }
}