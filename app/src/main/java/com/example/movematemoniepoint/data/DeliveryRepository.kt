package com.example.movematemoniepoint.data

import com.example.movematemoniepoint.domain.Delivery
import com.example.movematemoniepoint.domain.DeliveryStatus


object DeliveryRepository {

    fun getAllDeliveries(): List<Delivery> = listOf(

        Delivery(
            shipmentId = "#NEJ479132796545808",
            deliveryItem = "Macbook pro M2",
            time = "8:00 AM",
            orderDate = "2025-07-19",
            amount = 391.21,
            status = DeliveryStatus.CANCELLED,
            addressFrom = "Bogota",
            addressTo = "France",
            weight = "18kg"
        ),
        Delivery(
            shipmentId = "#NEJ456932191512887",
            deliveryItem = "Summer linen jacket",
            time = "8:00 AM",
            orderDate = "2025-07-19",
            amount = 285.79,
            status = DeliveryStatus.IN_PROGRESS,
            addressFrom = "Dhaka",
            addressTo = "Germany",
            weight = "14kg"
        ),
        Delivery(
            shipmentId = "#NEJ119175802450579",
            deliveryItem = "Tapered-fit jeans AW",
            time = "8:00 AM",
            orderDate = "2025-07-19",
            amount = 287.11,
            status = DeliveryStatus.COMPLETED,
            addressFrom = "Morocco",
            addressTo = "Germany",
            weight = "18kg"
        ),
        Delivery(
            shipmentId = "#NEJ576974729557851",
            deliveryItem = "Slim fit jeans AW",
            time = "8:00 AM",
            orderDate = "2025-07-19",
            amount = 149.37,
            status = DeliveryStatus.PENDING_ORDER,
            addressFrom = "Dhaka",
            addressTo = "Germany",
            weight = "11kg"
        ),
        Delivery(
            shipmentId = "#NEJ358357198243759",
            deliveryItem = "Office setup desk",
            time = "8:00 AM",
            orderDate = "2025-07-19",
            amount = 257.76,
            status = DeliveryStatus.COMPLETED,
            addressFrom = "Germany",
            addressTo = "Barcelona",
            weight = "7kg"
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
