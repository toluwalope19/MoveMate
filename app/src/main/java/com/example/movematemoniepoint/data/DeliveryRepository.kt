package com.example.movematemoniepoint.data

import com.example.movematemoniepoint.domain.Delivery
import com.example.movematemoniepoint.domain.DeliveryStatus


object DeliveryRepository {

    fun getAllDeliveries(): List<Delivery> = listOf(

        Delivery(
            shipmentId = "SHIP-001",
            deliveryItem = "Long Jeans",
            time = "12:30 PM, Jul 12",
            status = DeliveryStatus.COMPLETED,
            addressFrom = "Lagos",
            addressTo = "Abuja",
            weight = "15kg",
            orderDate = "Sep 20, 2023",
            amount = 1400.00
        ),
        Delivery(
            shipmentId = "SHIP-002",
            deliveryItem = "Long Skirt",
            time = "10:00 AM, Jul 14",
            status = DeliveryStatus.IN_PROGRESS,
            addressFrom = "New York",
            addressTo = "Accra",
            weight = "40kg",
            amount = 1200.23,
            orderDate = "Sep 20, 2024"
        ),
        Delivery(
            shipmentId = "SHIP-003",
            deliveryItem = "Television",
            time = "10:00 AM, Jul 14",
            status = DeliveryStatus.IN_PROGRESS,
            addressFrom = "New York",
            addressTo = "Lagos",
            weight = "40kg",
            amount = 1200.23,
            orderDate = "Sep 20, 2021"
        ),
        Delivery(
            shipmentId = "SHIP-004",
            deliveryItem = "Macbook pro M2",
            time = "10:00 AM, Jul 14",
            status = DeliveryStatus.IN_PROGRESS,
            addressFrom = "Ibadan",
            addressTo = "Jos",
            weight = "40kg",
            amount = 1200.23,
            orderDate = "Aug 10, 2024"
        ),
        Delivery(
            shipmentId = "SHIP-005",
            deliveryItem = "Summer linen jacket",
            time = "10:00 AM, Jul 14",
            status = DeliveryStatus.COMPLETED,
            addressFrom = "New York",
            addressTo = "Accra",
            weight = "40kg",
            amount = 1200.23,
            orderDate = "Sep 20, 2024"
        ),
        Delivery(
            shipmentId = "SHIP-006",
            deliveryItem = "Office setup desk",
            time = "10:00 AM, Jul 14",
            status = DeliveryStatus.COMPLETED,
            addressFrom = "New York",
            addressTo = "Accra",
            weight = "40kg",
            amount = 1200.23,
            orderDate = "Sep 20, 2024"
        ),
        Delivery(
            shipmentId = "SHIP-007",
            deliveryItem = "Slim fit jeans",
            time = "10:00 AM, Jul 14",
            status = DeliveryStatus.PENDING_ORDER,
            addressFrom = "Barcelona",
            addressTo = "Madrid",
            weight = "40kg",
            amount = 1250.23,
            orderDate = "Jan 20, 2021"
        ),
        Delivery(
            shipmentId = "SHIP-008",
            deliveryItem = "Taoered-fit jeans",
            time = "10:00 AM, Jul 14",
            status = DeliveryStatus.CANCELLED,
            addressFrom = "New York",
            addressTo = "Accra",
            weight = "40kg",
            amount = 1200.23,
            orderDate = "Sep 20, 2024"
        ),
        Delivery(
            shipmentId = "SHIP-009",
            deliveryItem = "Slim fit dress",
            time = "10:00 AM, Jul 14",
            status = DeliveryStatus.CANCELLED,
            addressFrom = "New York",
            addressTo = "Tokyo",
            weight = "40kg",
            amount = 5400.00,
            orderDate = "Mar 18, 2024"
        ),
        Delivery(
            shipmentId = "SHIP-010",
            deliveryItem = "Nike Sneakers",
            time = "10:00 AM, Jul 14",
            status = DeliveryStatus.IN_PROGRESS,
            addressFrom = "New York",
            addressTo = "Dhaka",
            weight = "40kg",
            amount = 4000.23,
            orderDate = "Feb 20, 2021"
        ),
        Delivery(
            shipmentId = "SHIP-011",
            deliveryItem = "Adidas Shirt",
            time = "10:00 AM, Jul 14",
            status = DeliveryStatus.COMPLETED,
            addressFrom = "Dhaka",
            addressTo = "Miami",
            weight = "40kg",
            amount = 500.23,
            orderDate = "Sep 20, 2020"
        ),
        Delivery(
            shipmentId = "SHIP-002",
            deliveryItem = "Football",
            time = "10:00 AM, Jul 14",
            status = DeliveryStatus.IN_PROGRESS,
            addressFrom = "New York",
            addressTo = "London",
            weight = "40kg",
            amount = 1000.23,
            orderDate = "Sep 10, 2019"
        ),
        Delivery(
            shipmentId = "SHIP-002",
            deliveryItem = "Macbook pro M3",
            time = "10:00 AM, Jul 14",
            status = DeliveryStatus.IN_PROGRESS,
            addressFrom = "New York",
            addressTo = "Accra",
            weight = "40kg",
            amount = 1100.23,
            orderDate = "Sep 20, 2024"
        ),

    )
}
