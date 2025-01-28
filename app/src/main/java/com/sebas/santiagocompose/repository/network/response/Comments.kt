package com.sebas.santiagocompose.repository.network.response

import com.google.gson.annotations.SerializedName

data class Comments(
    @SerializedName("postId") val postId: Int,
    @SerializedName("id") val idComment: Int,
    @SerializedName("name") val name: String,
    @SerializedName("email") val email: String,
    @SerializedName("body") val body: String
)
