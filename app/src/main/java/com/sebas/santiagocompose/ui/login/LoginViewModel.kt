package com.sebas.santiagocompose.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class LoginViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState
    fun onUpdateNameUser(nameUser: String) {
        _uiState.value = _uiState.value.copy(nameUser = nameUser)
        validateInput()
    }

    fun validateInput() {
        _uiState.value = _uiState.value.copy(
            isEnabledButton = _uiState.value.nameUser.isNotEmpty()
        )
    }

    fun doLogin(
        onNavigateHome: () -> Unit
    ) {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)
            delay(5000)
            _uiState.value = _uiState.value.copy(isLoading = false)
            onNavigateHome()
        }
    }
}