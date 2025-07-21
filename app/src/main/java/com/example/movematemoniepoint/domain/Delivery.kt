package com.example.movematemoniepoint.domain

import androidx.compose.ui.graphics.Color
import com.example.movematemoniepoint.R
import com.example.movematemoniepoint.ui.theme.GreenHighlight
import com.example.movematemoniepoint.ui.theme.LightOrange
import com.example.movematemoniepoint.ui.theme.LightRed


enum class DeliveryStatus(val displayName: String, val color: Color, val image: Int, val tabName: String) {
    COMPLETED("completed", LightOrange, R.drawable.ic_completed, "Completed"),
    IN_PROGRESS("in-progress", GreenHighlight, R.drawable.ic_in_progess, "In progress"),
    PENDING_ORDER("Pending", LightOrange, R.drawable.ic_pending, "Pending order"),
    CANCELLED("cancelled", LightRed,R.drawable.ic_cancelled, "Cancelled")
}

data class Delivery(
    val shipmentId: String,
    val deliveryItem: String,
    val time: String,
    val orderDate: String,
    val amount: Double,
    val status: DeliveryStatus,
    val addressFrom: String,
    val addressTo: String,
    val weight: String,
    val imageUrl: String? = null,
    val statusTitle: String? = null,
)

