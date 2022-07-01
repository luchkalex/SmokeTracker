package com.smoketracker.presentation.ui

import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.smoketracker.ui.theme.Accent
import com.smoketracker.ui.theme.Primary

@Composable
fun AppFloatingActionButton(
    onClick: () -> Unit,
    icon: ImageVector,
    contentDescription: String
){
    FloatingActionButton(
        onClick = onClick,
        backgroundColor = Accent,
    ) {
        Icon(
            icon,
            contentDescription = contentDescription
        )
    }
}

@Composable
fun AppExtendedFloatingActionButton(
    onClick: () -> Unit,
    icon: ImageVector,
    text: String = "",
    contentDescription: String = ""
){
    ExtendedFloatingActionButton(
        onClick = onClick,
        icon = {
            Icon(
                icon,
                contentDescription = contentDescription
            )
        },
        text = { Text(text = text) },
        backgroundColor = Accent
    )
}