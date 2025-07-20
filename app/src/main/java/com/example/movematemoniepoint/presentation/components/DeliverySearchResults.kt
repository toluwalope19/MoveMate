package com.example.movematemoniepoint.presentation.components


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movematemoniepoint.domain.Delivery
import com.example.movematemoniepoint.domain.DeliveryStatus
import com.example.movematemoniepoint.ui.theme.MoveMateMoniepointTheme
import kotlinx.coroutines.delay

@Composable
fun DeliverySearchResults(deliveries: List<Delivery>, modifier: Modifier = Modifier) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 24.dp, horizontal = 20.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
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
                    DeliveryResultItem(delivery, showDivider = index < deliveries.lastIndex)
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DeliverySearchResultsPreview() {
    val sampleDeliveries = listOf(
        Delivery(
            shipmentId = "#NEJ43857340857904",
            deliveryItem = "Macbook pro M2",
            time = "12:00PM",
            orderDate = "2025-07-18",
            amount = 2500.0,
            status = DeliveryStatus.COMPLETED,
            addressFrom = "Paris",
            addressTo = "Morocco",
            weight = "1.5kg"
        ),
        Delivery(
            shipmentId = "#NEJ20089934122231",
            deliveryItem = "Summer linen jacket",
            time = "10:00AM",
            orderDate = "2025-07-16",
            amount = 450.0,
            status = DeliveryStatus.PENDING_ORDER,
            addressFrom = "Barcelona",
            addressTo = "Paris",
            weight = "0.8kg"
        ),
        Delivery(
            shipmentId = "#NEJ35870264978659",
            deliveryItem = "Tapered-fit jeans AW",
            time = "2:30PM",
            orderDate = "2025-07-14",
            amount = 780.0,
            status = DeliveryStatus.CANCELLED,
            addressFrom = "Colombia",
            addressTo = "Paris",
            weight = "1.2kg"
        ),
        Delivery(
            shipmentId = "#NEJ35870264978659",
            deliveryItem = "Slim fit jeans AW",
            time = "4:45PM",
            orderDate = "2025-07-10",
            amount = 720.0,
            status = DeliveryStatus.COMPLETED,
            addressFrom = "Bogota",
            addressTo = "Dhaka",
            weight = "1.3kg"
        ),
        Delivery(
            shipmentId = "#NEJ23481570754963",
            deliveryItem = "Office setup desk",
            time = "6:15PM",
            orderDate = "2025-07-05",
            amount = 3120.0,
            status = DeliveryStatus.COMPLETED,
            addressFrom = "France",
            addressTo = "German",
            weight = "15kg"
        )
    )

    MoveMateMoniepointTheme {
        DeliverySearchResults(deliveries = sampleDeliveries)
    }
}

