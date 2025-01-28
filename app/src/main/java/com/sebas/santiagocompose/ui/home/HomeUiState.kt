package com.sebas.santiagocompose.ui.home

import com.sebas.santiagocompose.repository.network.response.Posts

data class HomeUiState(
    val isLoading: Boolean = false,
    val postList: ArrayList<Posts> = ArrayList()
)
