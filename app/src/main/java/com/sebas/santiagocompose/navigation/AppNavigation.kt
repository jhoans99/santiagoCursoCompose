package com.sebas.santiagocompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.sebas.santiagocompose.ui.home.HomeScreen
import com.sebas.santiagocompose.ui.login.LoginScreen
import com.sebas.santiagocompose.ui.login.LoginViewModel

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Login
    ) {
        composable<Login> {
            LoginScreen() { nameUser ->
                navController.navigate(Home(nameUser))
            }
        }
        composable<Home> { navBackStackEntry ->
            val home: Home = navBackStackEntry.toRoute()
            HomeScreen(home.nameUser) {
                navController.popBackStack()
            }
        }
    }
}
