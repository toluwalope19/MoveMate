package com.example.movematemoniepoint.data

import com.example.movematemoniepoint.domain.AvailableVehicle

object VehicleRepository {
    fun getAvailableVehicles(): List<AvailableVehicle> = listOf(
        AvailableVehicle(
            name = "Ocean Freight",
            imageUrl = "drawable/ocean_freight.png",
        ),
        AvailableVehicle(
            name = "Cargo Freight",
            imageUrl = "drawable/cargo_freight.png",
        ),
        AvailableVehicle(
            name = "Air Freight",
            imageUrl = "drawable/air_freight.png",
        )
    )
}
