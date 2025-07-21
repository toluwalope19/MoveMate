package com.example.movematemoniepoint.presentation.home.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.movematemoniepoint.R
import com.example.movematemoniepoint.ui.theme.BottomBarBackground
import com.example.movematemoniepoint.ui.theme.PurplePrimary

@Composable
fun BottomNav(navController: NavHostController) {
    val currentBackStack by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStack?.destination?.route

    val items = listOf(
        BottomNavItem("home", "Home", R.drawable.ic_home),
        BottomNavItem("calculate", "Calculate", R.drawable.ic_calculate),
        BottomNavItem("shipment", "Shipment", R.drawable.ic_shipment),
        BottomNavItem("profile", "Profile", R.drawable.ic_profile)
    )

    val selectedIndex = items.indexOfFirst { it.route == currentRoute }.coerceAtLeast(0)
    val tabWidth = with(LocalDensity.current) {
        (LocalConfiguration.current.screenWidthDp / items.size).dp
    }
    val indicatorOffset by animateDpAsState(
        targetValue = selectedIndex * tabWidth,
        label = "indicatorOffset"
    )


    Column {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(5.dp)
        ) {
            Box(
                modifier = Modifier
                    .offset(x = indicatorOffset)
                    .width(tabWidth)
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(8.dp))
                    .background(PurplePrimary)
            )
        }


        NavigationBar(
            containerColor = BottomBarBackground,
            tonalElevation = 0.dp
        ) {
            items.forEach { item ->
                val selected = currentRoute == item.route

                NavigationBarItem(
                    selected = selected,
                    onClick = {
                        if (!selected) {
                            navController.navigate(item.route) {
                                popUpTo(navController.graph.startDestinationId) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    },
                    icon = {
                        Icon(
                            painter = painterResource(item.icon),
                            contentDescription = item.label,
                            tint = if (selected) PurplePrimary else Color.Gray
                        )
                    },
                    label = {
                        Text(
                            text = item.label,
                            color = if (selected) PurplePrimary else Color.Gray
                        )
                    },
                    alwaysShowLabel = true,
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = Color.Transparent
                    )
                )
            }
        }
    }
}

data class BottomNavItem(
    val route: String,
    val label: String,
    val icon: Int
)
