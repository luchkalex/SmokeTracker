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
import com.smoketracker.presentation.viewmodel.EPDViewModel

@Composable
fun EPDScreen(navController: NavController, vm: EPDViewModel = hiltViewModel()) {

    val EPD by vm.EPD.observeAsState("")
    val price by vm.price.observeAsState("")

    EPDContent(
        onClick = {
            vm.saveExpenseData()
            navController.navigate(Screen.MainScreen.route)
        },
        onEPDValueChanged = {
            vm.updateEPD(it)
        },
        onPriceValueChanged = {
            vm.updatePrice(it)
        },
        EPD = EPD,
        price = price

    )
}

@Composable
private fun EPDContent(
    onClick: () -> Unit,
    onPriceValueChanged: (String) -> Unit,
    onEPDValueChanged: (String) -> Unit,
    EPD: String,
    price: String
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
                    value = price,
                    onValueChange = onPriceValueChanged,
                    modifier = Modifier.fillMaxWidth(),
                    label = { Text(text = "Price of device") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
                Spacer(modifier = Modifier.padding(15.dp))
                TextField(
                    value = EPD,
                    onValueChange = onEPDValueChanged,
                    modifier = Modifier.fillMaxWidth(),
                    label = { Text(text = "Expenses per day")},
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
            }
        }
    }
}