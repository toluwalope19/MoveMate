package com.example.movematemoniepoint.data

import com.example.movematemoniepoint.R
import com.example.movematemoniepoint.domain.AvailableVehicle

object VehicleRepository {
    fun getAvailableVehicles(): List<AvailableVehicle> = listOf(
        AvailableVehicle(
            name = "Ocean Freight",
            description = "International",
            imageUrl = R.drawable.ic_trailer,
        ),
        AvailableVehicle(
            name = "Cargo Freight",
            description = "Reliable",
            imageUrl = R.drawable.ic_trailer,
        ),
        AvailableVehicle(
            name = "Air Freight",
            description = "International",
            imageUrl = R.drawable.ic_trailer,
        )
    )
}
