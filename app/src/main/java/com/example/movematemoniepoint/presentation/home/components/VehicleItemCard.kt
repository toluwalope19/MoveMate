package com.example.movematemoniepoint.presentation.home.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movematemoniepoint.R
import com.example.movematemoniepoint.domain.AvailableVehicle
import com.example.movematemoniepoint.ui.theme.MoveMateMoniepointTheme
import kotlinx.coroutines.delay

@Composable
fun VehicleItemCard(vehicle: AvailableVehicle, modifier: Modifier = Modifier) {
    val cardOffsetX = remember { Animatable(300f) }
    val imageOffsetX = remember { Animatable(300f) }

    LaunchedEffect(Unit) {
        // Animate card in
        cardOffsetX.animateTo(0f, animationSpec = tween(500))
        // Delay image animation a bit
        delay(50)
        imageOffsetX.animateTo(0f, animationSpec = tween(500))
    }

    Card(
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = modifier
            .width(160.dp)
            .height(200.dp)
            .graphicsLayer { translationX = cardOffsetX.value }
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .padding(start = 12.dp, top = 12.dp, bottom = 12.dp)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = vehicle.name,
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Normal),
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = vehicle.description,
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.Gray,
                        fontWeight = FontWeight.Light
                    )
                }
            }

            Image(
                painter = painterResource(id = vehicle.imageUrl),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .graphicsLayer { translationX = imageOffsetX.value }
            )
        }
    }
}



@Preview(showBackground = true)
@Composable
fun AvailableVehiclesPreview() {
    val vehicle = AvailableVehicle("Ocean freight", "International", R.drawable.ic_trailer)
    MoveMateMoniepointTheme {
        VehicleItemCard(vehicle = vehicle, modifier = Modifier)
    }
}
