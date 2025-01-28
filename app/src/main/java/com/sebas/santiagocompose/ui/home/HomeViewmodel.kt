package com.sebas.santiagocompose.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sebas.santiagocompose.repository.PostRepository
import com.sebas.santiagocompose.ui.login.LoginUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewmodel @Inject constructor(
    private val postRepository: PostRepository
): ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState
    init {
        viewModelScope.launch {
            postRepository.fetchAllPosts().collect {
                _uiState.value = _uiState.value.copy(postList = it)
            }
        }
    }

    fun getPostDetail(
        postId: String
    ) {
        viewModelScope.launch {
            postRepository.fetchDetailsPost(postId).collect {

            }
        }
    }

}