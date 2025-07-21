package com.example.movematemoniepoint.presentation.shipment.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.runtime.Composable
import com.example.movematemoniepoint.domain.DeliveryStatus



@Composable
fun AnimatedDeliveryTabRow(
    visible: Boolean, // Control visibility directly from the parent
    selectedTab: DeliveryStatus?,
    onTabSelected: (DeliveryStatus?) -> Unit,
    counts: Map<DeliveryStatus?, Int>
) {
    // The animation is now tied to the 'visible' state changing from false to true.
    AnimatedVisibility(
        visible = visible,
        enter = slideInHorizontally(
            // This starts the component off-screen to the right
            initialOffsetX = { fullWidth -> fullWidth },
            animationSpec = tween(durationMillis = 700)
        ) + fadeIn(animationSpec = tween(durationMillis = 700))
    ) {
        // The DeliveryTabRow is now a direct child of the animation.
        DeliveryTabRow(
            selectedTab = selectedTab,
            onTabSelected = onTabSelected,
            counts = counts
        )
    }
}




