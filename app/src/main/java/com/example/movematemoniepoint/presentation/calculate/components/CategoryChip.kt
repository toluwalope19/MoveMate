package com.example.movematemoniepoint.presentation.calculate.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.movematemoniepoint.R

/**
 * A composable function that displays a category chip.
 *
 * The chip displays a label and an optional check icon when selected.
 * The background and text color of the chip animate based on the selection state.
 *
 * @param label The text to display on the chip.
 * @param isSelected Whether the chip is currently selected.
 * @param onClick A callback function that is invoked when the chip is clicked.
 */
@Composable
fun CategoryChip(
    label: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val backgroundColor by animateColorAsState(
        targetValue = if (isSelected) Color.Black else Color.Transparent,
        animationSpec = tween(durationMillis = 100)
    )
    val textColor by animateColorAsState(
        targetValue = if (isSelected) Color.White else Color.Black,
        animationSpec = tween(durationMillis = 100)
    )

    Surface(
        onClick = onClick,
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, if (isSelected) Color.Black else Color.Gray),
        color = backgroundColor
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 14.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AnimatedVisibility(
                visible = isSelected,
                enter = fadeIn(tween(200)) + slideInHorizontally(initialOffsetX = { -10 }),
                exit = fadeOut()
            ) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = stringResource(R.string.txt_selected),
                    tint = Color.White,
                    modifier = Modifier
                        .size(16.dp)
                        .padding(end = 6.dp)
                )
            }

            Text(
                text = label,
                style = MaterialTheme.typography.bodyMedium,
                color = textColor
            )
        }
    }
}
