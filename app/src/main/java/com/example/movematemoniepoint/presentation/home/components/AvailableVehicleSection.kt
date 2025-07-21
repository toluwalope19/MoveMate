package com.example.movematemoniepoint.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movematemoniepoint.R
import com.example.movematemoniepoint.domain.AvailableVehicle
import com.example.movematemoniepoint.presentation.home.components.VehicleItemCard
import com.example.movematemoniepoint.ui.theme.MoveMateMoniepointTheme

@Composable
fun AvailableVehiclesSection(
    vehicles: List<AvailableVehicle>,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(horizontal = 16.dp)) {
        Text(
            text = "Available vehicles",
            style = MaterialTheme.typography.titleLarge,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(vehicles) { vehicle ->
                VehicleItemCard(vehicle = vehicle)
            }
        }
    }
}




@Preview(showBackground = true)
@Composable
fun AvailableVehiclesSectionPreview() {
    val vehicles = listOf(
        AvailableVehicle("Ocean freight", "International", R.drawable.ic_trailer),
        AvailableVehicle("Cargo freight", "Reliable",R.drawable.ic_trailer),
        AvailableVehicle("Air freight", "International",R.drawable.ic_trailer)
    )

    MoveMateMoniepointTheme {
        AvailableVehiclesSection(vehicles = vehicles)
    }
}

