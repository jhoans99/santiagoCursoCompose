package com.sebas.santiagocompose.ui.components.buttons

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun PrimaryButton(
    textButton: String,
    isEnabled: Boolean = true,
    modifier: Modifier = Modifier,
    onClickAction: () -> Unit
) {
    Button(
        onClick = {
           onClickAction()
        },
        enabled = isEnabled,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Blue,
            contentColor = Color.White
        )
    ) {
        Text(
            text = textButton
        )
    }
}