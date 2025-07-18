package com.example.movematemoniepoint.nav

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.movematemoniepoint.presentation.calculate.CalculateScreen
import com.example.movematemoniepoint.presentation.components.BottomNav
import com.example.movematemoniepoint.presentation.home.HomeScreen
import com.example.movematemoniepoint.presentation.shipment.ShipmentScreen

@Composable
fun MainNavGraph(modifier: Modifier) {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNav(navController) }
    ) { padding ->
        NavHost(navController, startDestination = "home", Modifier.padding(padding)) {
            composable("home") { HomeScreen() }
            composable("calculate") { CalculateScreen() }
            composable("shipment") { ShipmentScreen() }
            composable("profile") { }
        }
    }
}