package com.example.movematemoniepoint.domain


enum class DeliveryStatus {
    COMPLETED, IN_PROGRESS, PENDING_ORDER, CANCELLED
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

