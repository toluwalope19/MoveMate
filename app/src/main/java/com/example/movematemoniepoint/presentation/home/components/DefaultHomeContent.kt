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

/**
 * Composable function that displays the default content for the home screen.
 * It shows tracking information for the first delivery and a list of available vehicles.
 *
 * @param deliveries A list of [Delivery] objects. The first delivery in this list will be used to display tracking information.
 * @param vehicles A list of [AvailableVehicle] objects to be displayed in the "Available Vehicles" section.
 */
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
