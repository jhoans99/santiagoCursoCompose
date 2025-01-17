package com.sebas.santiagocompose.navigation

import kotlinx.serialization.Serializable

@Serializable
object Login

@Serializable
data class Home(
    var nameUser: String
)
