package com.example.movematemoniepoint.presentation.shipment.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movematemoniepoint.R
import com.example.movematemoniepoint.domain.DeliveryStatus

/**
 * A composable function that displays a status chip.
 *
 * @param status The delivery status to display.
 */
@Composable
fun StatusChip(status: DeliveryStatus) {

    val icon = status.image

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .background((Color.LightGray.copy(alpha = 0.2f)), RoundedCornerShape(12.dp))
            .padding(horizontal = 10.dp, vertical = 3.dp)
    ) {
        Icon(
            painter = painterResource(icon),
            contentDescription = null,
            tint = status.color,
            modifier = Modifier.size(16.dp)
        )

        Spacer(modifier = Modifier.width(4.dp))

        Text(
            text = status.displayName,
            color = status.color,
            style = MaterialTheme.typography.labelSmall,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun StatusChipPreview() {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        StatusChip(DeliveryStatus.COMPLETED)
        StatusChip(DeliveryStatus.IN_PROGRESS)
        StatusChip(DeliveryStatus.PENDING_ORDER)
        StatusChip(DeliveryStatus.CANCELLED)
    }
}

