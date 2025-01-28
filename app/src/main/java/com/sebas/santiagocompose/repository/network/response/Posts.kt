package com.sebas.santiagocompose.repository.network.response

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

data class Posts(
    @SerializedName("userId") val userId: Int,
    @SerializedName("id") val postId: Int,
    @SerializedName("title") val title: String,
    @SerializedName("body") val body: String
)
