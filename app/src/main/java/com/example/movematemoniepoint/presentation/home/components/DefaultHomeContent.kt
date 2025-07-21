package com.example.movematemoniepoint.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.movematemoniepoint.domain.AvailableVehicle
import com.example.movematemoniepoint.domain.Delivery

@Composable
fun DefaultHomeContent(deliveries: List<Delivery>, vehicles: List<AvailableVehicle>) {
    val firstDelivery = deliveries.firstOrNull()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF9F9F9)),
        contentPadding = PaddingValues(vertical = 16.dp)
    ) {
        item {
            firstDelivery?.let {
                TrackingInfoSection(delivery = it)
            }
        }

        item {
            Spacer(modifier = Modifier.height(24.dp))
            AvailableVehiclesSection(vehicles = vehicles)
        }
    }
}
