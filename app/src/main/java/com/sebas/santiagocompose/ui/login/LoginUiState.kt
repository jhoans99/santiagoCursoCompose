package com.sebas.santiagocompose.ui.login

data class LoginUiState(
    val nameUser: String = "",
    val isEnabledButton: Boolean = false,
    val isLoading: Boolean = false
)
