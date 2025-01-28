package com.sebas.santiagocompose.repository.network

import com.sebas.santiagocompose.repository.network.response.Comments
import com.sebas.santiagocompose.repository.network.response.Posts
import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface JsonPlaceHolderApiService {

    @GET("posts")
    suspend fun fetchPost(): ArrayList<Posts>

    @GET("post/{id}")
    suspend fun fetchPostDetail(
        @Path("id") id: String
    ): Posts


    /*@GET("post/{id}/comments")
    suspend fun fetchPostComments(
        @Path("id") id: Int
    ): Call<ArrayList<Comments>>*/


    @GET("comments")
    suspend fun fetchPostComments(
        @Query("postId") postId: String
    ): Call<ArrayList<Comments>>
}