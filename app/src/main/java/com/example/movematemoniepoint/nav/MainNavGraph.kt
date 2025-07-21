package com.example.movematemoniepoint.nav

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.movematemoniepoint.presentation.calculate.CalculateScreen
import com.example.movematemoniepoint.presentation.calculate.SuccessScreen
import com.example.movematemoniepoint.presentation.home.components.BottomNav
import com.example.movematemoniepoint.presentation.home.HomeScreen
import com.example.movematemoniepoint.presentation.shipment.ShipmentScreen

@Composable
fun MainNavGraph(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    val currentBackStack by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStack?.destination?.route

    val showBottomBar = currentRoute !in listOf("success","shipment")

    Scaffold(
        bottomBar = { if (showBottomBar) {
            BottomNav(navController)
        } }
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(padding)
        ) {
            composable("home") {
                HomeScreen()
            }

            composable("calculate") {
                CalculateScreen(
                    navController = navController,
                    onBack = { navController.popBackStack() }
                )
            }

            composable("success") {
                SuccessScreen(
                    onBackToHome = {
                        navController.navigate("home") {
                            popUpTo("home") { inclusive = false }
                            launchSingleTop = true
                        }
                    }
                )
            }

            composable("shipment") { ShipmentScreen(
                onBack = { navController.popBackStack() }
            ) }
            composable("profile") { /* ProfileScreen */ }
        }
    }
}
