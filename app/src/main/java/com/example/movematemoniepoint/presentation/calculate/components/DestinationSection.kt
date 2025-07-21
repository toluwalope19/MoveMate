package com.example.movematemoniepoint.presentation.calculate.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movematemoniepoint.R
import com.example.movematemoniepoint.presentation.calculate.DestinationInputEvent
import com.example.movematemoniepoint.presentation.calculate.DestinationInputState
import com.example.movematemoniepoint.ui.theme.MoveMateMoniepointTheme
import com.example.movematemoniepoint.ui.theme.PurplePrimary

/**
 * A composable function that displays a section for inputting destination details.
 *
 * This section includes input fields for sender location, receiver location, and approximate weight.
 *
 * @param state The current state of the destination input fields.
 * @param onValueChange A callback function that is invoked when the value of an input field changes.
 */
@Composable
fun DestinationSection(
    state: DestinationInputState,
    onValueChange: (DestinationInputEvent) -> Unit
) {
    Column {
        Text(
            text = stringResource(R.string.destination),
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.SemiBold),
        )

        Spacer(modifier = Modifier.height(12.dp))

        Card(
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                DestinationInputField(
                    value = state.sender,
                    onValueChange = { onValueChange(DestinationInputEvent.OnSenderChanged(it)) },
                    hint = stringResource(R.string.sender_location),
                    leadingIcon = painterResource(id = R.drawable.ic_sender_location),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp)
                )

                DestinationInputField(
                    value = state.receiver,
                    onValueChange = { onValueChange(DestinationInputEvent.OnReceiverChanged(it)) },
                    hint = stringResource(R.string.receiver_location),
                    leadingIcon = painterResource(id = R.drawable.ic_receiver_location),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp)
                )

                DestinationInputField(
                    value = state.weight,
                    onValueChange = { onValueChange(DestinationInputEvent.OnWeightChanged(it)) },
                    hint = stringResource(R.string.approx_weight),
                    leadingIcon = painterResource(id = R.drawable.ic_weight),
                    modifier = Modifier.fillMaxWidth()
                )

            }
        }
    }
}

@Composable
fun DestinationInputField(
    value: String,
    onValueChange: (String) -> Unit,
    hint: String,
    leadingIcon: Painter,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = {
            Text(
                text = hint,
                color = Color.Gray,
                style = MaterialTheme.typography.bodyMedium
            )
        },
        textStyle = MaterialTheme.typography.bodyMedium.copy(color = Color.Black),
        leadingIcon = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(start = 12.dp, end = 4.dp)
            ) {
                Icon(
                    painter = leadingIcon,
                    contentDescription = null,
                    tint = Color.Gray,
                    modifier = Modifier.size(24.dp)
                )

                Spacer(modifier = Modifier.width(8.dp))

                // Divider between icon and text
                Box(
                    modifier = Modifier
                        .width(1.dp)
                        .height(24.dp)
                        .background(Color(0xFFDADADA))
                )

                Spacer(modifier = Modifier.width(8.dp))
            }
        },
        shape = RoundedCornerShape(12.dp),
        modifier = modifier
            .fillMaxWidth()
            .background(Color(0xFFF6F6F6), RoundedCornerShape(12.dp)),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color(0xFFF5F5F5),
            unfocusedContainerColor = Color(0xFFF5F5F5),
            disabledContainerColor = Color(0xFFF5F5F5),
            cursorColor = PurplePrimary,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            unfocusedLabelColor = Color.Gray,
            focusedLabelColor = Color.Gray
        ),
        singleLine = true
    )
}


@Preview(showBackground = true)
@Composable
fun DestinationSectionPreview() {
    val previewState = DestinationInputState(
        sender = "Lagos",
        receiver = "Abuja",
        weight = "2.5kg"
    )

    MoveMateMoniepointTheme {
        DestinationSection(
            state = previewState,
            onValueChange = {}
        )
    }
}


