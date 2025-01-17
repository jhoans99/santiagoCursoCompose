package com.sebas.santiagocompose.ui.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun LoginScreen(
    onNavigateHome: (String) -> Unit
 ) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var nameUser by remember {
            mutableStateOf("")
        }
        OutlinedTextField(
            value = nameUser,
            onValueChange = {
              nameUser = it
            },
            label = {
                Text(text = "Ingresa el usuario")
            }
        )

        Button(onClick = {
            onNavigateHome(nameUser)
        }) {
            Text(text = "Inicia sesion")
        }
    }
}