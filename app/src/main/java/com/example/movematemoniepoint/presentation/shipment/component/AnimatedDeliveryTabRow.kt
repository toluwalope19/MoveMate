package com.example.movematemoniepoint.presentation.shipment.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.runtime.Composable
import com.example.movematemoniepoint.domain.DeliveryStatus



@Composable
fun AnimatedDeliveryTabRow(
    visible: Boolean,
    selectedTab: DeliveryStatus?,
    onTabSelected: (DeliveryStatus?) -> Unit,
    counts: Map<DeliveryStatus?, Int>
) {

    AnimatedVisibility(
        visible = visible,
        enter = slideInHorizontally(
            // This starts the component off-screen to the right
            initialOffsetX = { fullWidth -> fullWidth },
            animationSpec = tween(durationMillis = 700)
        ) + fadeIn(animationSpec = tween(durationMillis = 700))
    ) {

        DeliveryTabRow(
            selectedTab = selectedTab,
            onTabSelected = onTabSelected,
            counts = counts
        )
    }
}




