package com.example.movematemoniepoint.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.movematemoniepoint.presentation.calculate.CalculateScreen
import com.example.movematemoniepoint.presentation.calculate.SuccessScreen

@Composable
fun CalculateNavGraph(parentNavController: NavController) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "calculate_main"
    ) {
        composable("calculate_main") {
            CalculateScreen(
                navController = navController,
                onBack = { navController.popBackStack() }
            )
        }
        composable("success") {
            SuccessScreen(
                onBackToHome = { parentNavController.navigate("home") }
            )
        }
    }
}
