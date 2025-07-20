package com.example.movematemoniepoint.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.unit.dp
import com.example.movematemoniepoint.R
import com.example.movematemoniepoint.domain.Delivery
import com.example.movematemoniepoint.ui.theme.PurplePrimary


@Composable
fun DeliveryResultItem(
    delivery: Delivery,
    showDivider: Boolean,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(horizontal = 12.dp, vertical = 14.dp)) {
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

                Row(verticalAlignment = Alignment.CenterVertically) {
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

        if (showDivider) {
            Spacer(modifier = Modifier.height(12.dp))
            HorizontalDivider(color = Color(0xFFF2F2F2), thickness = 1.dp)
        }
    }
}
