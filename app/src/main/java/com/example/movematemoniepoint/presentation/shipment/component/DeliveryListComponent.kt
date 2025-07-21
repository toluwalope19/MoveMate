package com.example.movematemoniepoint.presentation.shipment.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.movematemoniepoint.domain.Delivery
import com.example.movematemoniepoint.presentation.components.DeliveryResultItem
import kotlinx.coroutines.delay

@Composable
fun DeliverListComponent(deliveries: List<Delivery>, modifier: Modifier = Modifier) {

    LazyColumn(
        modifier = modifier
    ) {
        itemsIndexed(deliveries, key = { _, item -> item.shipmentId }) { index, delivery ->
            var visible by remember { mutableStateOf(false) }

            // Launch effect to trigger animation staggered by index
            LaunchedEffect(delivery) {
                delay(index * 50L) // 100ms stagger
                visible = true
            }

            AnimatedVisibility(
                visible = visible,
                enter = fadeIn(tween(200)) + slideInVertically(
                    tween(200),
                    initialOffsetY = { it / 3 }),
                exit = fadeOut(tween(150)) + slideOutVertically(
                    tween(150),
                    targetOffsetY = { it / 3 })
            ) {
                DeliveryItem(delivery)
            }
        }
    }
}

