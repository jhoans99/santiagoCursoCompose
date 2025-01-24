package com.sebas.santiagocompose.ui.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import com.sebas.santiagocompose.ui.theme.SantiagoComposeTheme

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel(),
    onNavigateHome: (String) -> Unit
 ) {
    val uiState by viewModel.uiState.collectAsState()

    if(uiState.isLoading) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.LightGray)
                .zIndex(2f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircularProgressIndicator(
                modifier = Modifier
            )
        }
    }
    loginBody(uiState) {
        onNavigateHome(it)
    }
}

@Composable
fun loginBody(
    uiState: LoginUiState,
    viewModel: LoginViewModel = hiltViewModel(),
    onNavigateHome: (String) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = uiState.nameUser,
            onValueChange = {
                viewModel.onUpdateNameUser(it)
            },
            label = {
                Text(text = "Ingresa el usuario")
            }
        )

        Button(onClick = {
            viewModel.doLogin {
                onNavigateHome(uiState.nameUser)
            }
        },
            enabled = uiState.isEnabledButton
        ) {
            Text(text = "Inicia sesion")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    SantiagoComposeTheme {
    }
}