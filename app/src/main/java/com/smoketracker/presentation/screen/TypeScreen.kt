package com.smoketracker.presentation.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.domain.model.CalculationType
import com.smoketracker.presentation.viewmodel.TypeViewModel

@Composable
fun TypeScreen(navController: NavController, vm: TypeViewModel = hiltViewModel()) {
    TypeContent(
        onClick = {
            vm.saveType(it)
            when (it) {
                CalculationType.EPD -> {
                    navController.navigate(Screen.EPDScreen.route)
                }
                CalculationType.PPD -> {

                }
            }
        },
    )
}

@Composable
private fun TypeContent(
    onClick: (CalculationType) -> Unit,
) {
    Scaffold {
        //Select
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
        ) {
            Text(text = "Chose the type of calculation your daily quantity of puffs")
            Spacer(modifier = Modifier.padding(15.dp))
            ExtendedFloatingActionButton(
                onClick = { onClick(CalculationType.PPD) },
                icon = {
                    Icon(
                        Icons.Filled.Favorite,
                        contentDescription = "Puffs per day"
                    )
                },
                text = { Text(text = "Puffs per day") }
            )
            Spacer(modifier = Modifier.padding(15.dp))
            ExtendedFloatingActionButton(
                onClick = { onClick(CalculationType.EPD) },
                icon = {
                    Icon(
                        Icons.Filled.ShoppingCart,
                        contentDescription = "Expenses per day"
                    )
                },
                text = { Text(text = "Expenses per day") }
            )
        }
    }
}