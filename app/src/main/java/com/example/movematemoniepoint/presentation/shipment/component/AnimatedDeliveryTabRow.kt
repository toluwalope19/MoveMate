package com.example.movematemoniepoint.presentation.shipment.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.runtime.Composable
import com.example.movematemoniepoint.domain.DeliveryStatus


/**
 * A Composable function that displays a [DeliveryTabRow] with an animation.
 *
 * The [DeliveryTabRow] will slide in from the right and fade in when it becomes visible.
 *
 * @param visible Whether the [DeliveryTabRow] should be visible.
 * @param selectedTab The currently selected [DeliveryStatus].
 * @param onTabSelected A callback that is invoked when a tab is selected.
 * @param counts A map of [DeliveryStatus] to the number of items in that status.
 */
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




