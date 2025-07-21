package com.example.movematemoniepoint.presentation.shipment.component

import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.movematemoniepoint.domain.Delivery


/**
 * Composable function that displays a list of shipments.
 *
 * This function uses a [LazyColumn] to efficiently display a list of deliveries.
 * Each item in the list is represented by a [DeliveryItem] composable.
 * The items are animated using [Modifier.animateItemPlacement] for a smooth user experience.
 *
 * @param deliveries The list of [Delivery] objects to display.
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ShipmentListSection(
    deliveries: List<Delivery>,
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 4.dp),
    ) {
        itemsIndexed(
            items = deliveries,
            key = { _, item -> item.shipmentId }
        ) { index, delivery ->

            DeliveryItem(
                delivery = delivery,
                modifier = Modifier.animateItemPlacement(
                    animationSpec = tween(durationMillis = 350)
                )
            )
        }
    }
}




