package com.example.movematemoniepoint.presentation.shipment.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movematemoniepoint.R
import com.example.movematemoniepoint.domain.Delivery
import com.example.movematemoniepoint.domain.DeliveryStatus
import com.example.movematemoniepoint.ui.theme.GreenHighlight
import com.example.movematemoniepoint.ui.theme.PurplePrimary

/**
 * Composable function that displays a single delivery item in a card format.
 * It shows information such as delivery status, arrival information,
 * shipment ID, origin address, amount, and order date.
 *
 * @param delivery The [Delivery] object containing the details to be displayed.
 * @param modifier The [Modifier] to be applied to the card.
 */
@Composable
fun DeliveryItem(delivery: Delivery, modifier: Modifier = Modifier) {
    Card(
        shape = RoundedCornerShape(12.dp),
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                StatusChip(status = delivery.status)

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = stringResource(R.string.arriving_today),
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Text(
                    text = stringResource(
                        R.string.your_delivery_from_is_arriving_today,
                        delivery.shipmentId,
                        delivery.addressFrom
                    ),
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(end = 24.dp)

                )

                Spacer(modifier = Modifier.height(12.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = stringResource(R.string.usd, delivery.amount),
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.SemiBold,
                        color = PurplePrimary
                    )
                    Spacer(modifier = Modifier.width(4.dp))

                    Box(
                        modifier = Modifier
                            .size(4.dp)
                            .clip(CircleShape)
                            .background(Color.LightGray)
                    )

                    Spacer(modifier = Modifier.width(4.dp))

                    Text(
                        text = delivery.orderDate,
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.Gray,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }

            Image(
                painter = painterResource(id = R.drawable.ic_pack),
                contentDescription = null,
                modifier = Modifier
                    .size(70.dp)

            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DeliveryItemPreview() {
    val sampleDelivery = Delivery(
        shipmentId = "#NEJ456932191512887",
        deliveryItem = "Laptop",
        time = "10:00 AM",
        orderDate = "July 20, 2025",
        amount = 1490.00,
        status = DeliveryStatus.IN_PROGRESS,
        addressFrom = "Lagos",
        addressTo = "Abuja",
        weight = "2kg"
    )

    DeliveryItem(delivery = sampleDelivery)
}

