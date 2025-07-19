package com.example.movematemoniepoint.presentation.components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movematemoniepoint.R
import com.example.movematemoniepoint.domain.Delivery
import com.example.movematemoniepoint.domain.DeliveryStatus
import com.example.movematemoniepoint.ui.theme.MoveMateMoniepointTheme
import com.example.movematemoniepoint.ui.theme.PurplePrimary

@Composable
fun DeliverySearchResults(
    deliveries: List<Delivery>,
    modifier: Modifier = Modifier
) {
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
            itemsIndexed(deliveries) { index, delivery ->
                Column(modifier = Modifier.padding(horizontal = 12.dp, vertical = 14.dp)) {
                    Row(verticalAlignment = Alignment.Top) {

                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .clip(CircleShape)
                                .background(PurplePrimary),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_package),
                                contentDescription = "Package",
                                tint = Color.White,
                                modifier = Modifier.size(24.dp)
                            )
                        }

                        Spacer(modifier = Modifier.width(8.dp))


                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = delivery.deliveryItem,
                                style = MaterialTheme.typography.bodyLarge,
                                color = Color.Black
                            )

                            Spacer(modifier = Modifier.height(6.dp))

                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = delivery.shipmentId,
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = Color.Gray
                                )

                                Spacer(modifier = Modifier.width(4.dp))

                                Text(
                                    text = "•",
                                    color = Color.Gray,
                                    modifier = Modifier.padding(end = 4.dp)
                                )

                                Text(
                                    text = "${delivery.addressFrom} → ${delivery.addressTo}",
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = Color.Gray,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )

                            }
                        }

                    }

                    // Divider except after last item
                    if (index < deliveries.lastIndex) {
                        Spacer(modifier = Modifier.height(12.dp))
                        HorizontalDivider(color = Color(0xFFF2F2F2), thickness = 1.dp)
                    }
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

