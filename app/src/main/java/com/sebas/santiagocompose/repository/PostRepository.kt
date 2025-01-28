package com.sebas.santiagocompose.repository

import com.sebas.santiagocompose.repository.network.JsonPlaceHolderApiService
import com.sebas.santiagocompose.repository.network.response.Posts
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class PostRepository @Inject constructor(
    private val apiService: JsonPlaceHolderApiService
) {

    suspend fun fetchAllPosts(): Flow<ArrayList<Posts>> {
        return flow {
            emit(apiService.fetchPost())
        }
    }

    suspend fun fetchDetailsPost(postId: String): Flow<Posts> {
        return flow {
            emit(apiService.fetchPostDetail(postId))
        }

    }
}