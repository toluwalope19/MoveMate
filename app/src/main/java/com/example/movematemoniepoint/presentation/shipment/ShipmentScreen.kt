package com.example.movematemoniepoint.presentation.shipment

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.movematemoniepoint.domain.DeliveryStatus
import com.example.movematemoniepoint.presentation.shipment.component.AnimatedDeliveryTabRow
import com.example.movematemoniepoint.presentation.shipment.component.ShipmentListSection
import com.example.movematemoniepoint.presentation.shipment.component.ShipmentTopAppBar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShipmentScreen(viewModel: ShipmentViewModel = hiltViewModel(), onBack: () -> Unit = {}) {
    val deliveries by viewModel.deliveries.collectAsStateWithLifecycle()
    var selectedStatus by rememberSaveable { mutableStateOf<DeliveryStatus?>(null) }

    val counts = remember(deliveries) { viewModel.getDeliveryCountsByStatus() }

    val filteredDeliveries = remember(selectedStatus, deliveries) {
        viewModel.getDeliveriesByStatus(selectedStatus)
    }


    var animateTitle by remember { mutableStateOf(false) }
    var isTabRowVisible by remember { mutableStateOf(false) }


    // Initial animations for the whole screen
    LaunchedEffect(Unit) {

        animateTitle = true
        isTabRowVisible = true

    }

    Scaffold(
        topBar = { ShipmentTopAppBar(onBack) },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            AnimatedDeliveryTabRow(
                visible = isTabRowVisible,
                selectedTab = selectedStatus,
                onTabSelected = { newStatus ->
                    if (selectedStatus != newStatus) {
                        selectedStatus = newStatus
                    }
                },
                counts = counts
            )

            AnimatedVisibility(
                visible = animateTitle,
                enter = fadeIn(tween(700)) + slideInVertically(
                    initialOffsetY = { it / 2 },
                    animationSpec = tween(700)
                )
            ) {
                Column {
                    Text(
                        text = "Shipments",
                        style = MaterialTheme.typography.headlineMedium,
                        modifier = Modifier.padding(top = 24.dp, start = 16.dp, bottom = 8.dp),
                        color = Color.Black
                    )

                    ShipmentListSection(
                        deliveries = filteredDeliveries,
                    )
                }
            }

        }
    }
}





