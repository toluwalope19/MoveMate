package com.example.movematemoniepoint.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movematemoniepoint.R
import com.example.movematemoniepoint.ui.theme.MoveMateMoniepointTheme
import com.example.movematemoniepoint.ui.theme.PurplePrimary

/**
 * Composable function that displays the app bar for the home screen.
 * It includes user profile information, location, notification icon, and a search bar.
 *
 * @param searchText The current text in the search bar.
 * @param onSearchTextChange Callback function invoked when the search text changes.
 * @param onEnterSearchMode Callback function invoked when the user interacts with the search bar to enter search mode.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeAppBar(
    searchText: String,
    onSearchTextChange: (String) -> Unit,
    onEnterSearchMode: () -> Unit
) {

    val interactionSource = remember { MutableInteractionSource() }

    LaunchedEffect(interactionSource) {
        interactionSource.interactions.collect { interaction ->
            if (interaction is PressInteraction.Press) {
                onEnterSearchMode()
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(PurplePrimary)
            .padding(horizontal = 16.dp)
            .padding(top = 12.dp, bottom = 12.dp)
    ) {
        // Top Row (Profile + Location + Notification)
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            // Profile image
            Image(
                painter = painterResource(R.drawable.person_icon),
                contentDescription = null,
                modifier = Modifier
                    .size(54.dp)
                    .clip(CircleShape)

            )

            Spacer(modifier = Modifier.width(12.dp))

            // Location column
            Column(modifier = Modifier.weight(1f)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_near_me),
                        contentDescription = null,
                        tint = Color.LightGray,
                        modifier = Modifier
                            .size(24.dp)
                            .padding(end = 4.dp)
                    )
                    Text(
                        text = stringResource(R.string.your_location),
                        style = MaterialTheme.typography.labelLarge,
                        color = Color.LightGray
                    )
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(top = 2.dp)
                ) {
                    Text(
                        text = stringResource(R.string.wertheimer_illinois),
                        color = Color.White,
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Icon(
                        painter = painterResource(R.drawable.ic_right_arrow),
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }

            // Notification icon with white background
            IconButton(
                onClick = {},
                modifier = Modifier
                    .size(36.dp)
                    .padding(end = 8.dp)
                    .background(Color.White, shape = CircleShape)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_notifcation_icon),
                    contentDescription = stringResource(R.string.notifications)
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Search box
        TextField(
            value = searchText,
            onValueChange = {
                onSearchTextChange(it)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            readOnly = true,
            interactionSource = interactionSource,
            placeholder = {
                Text(
                    text = stringResource(R.string.enter_the_receipt_number),
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(bottom = 2.dp)
                )
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = stringResource(R.string.txt_search_icon),
                    tint = PurplePrimary,
                    modifier = Modifier.padding(start = 8.dp)
                )
            },
            trailingIcon = {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(Color(0xFFE67E22)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_scanner),
                        contentDescription = stringResource(R.string.txt_receipt),
                        tint = Color.White,
                        modifier = Modifier.size(16.dp)
                    )
                }
            },
            shape = RoundedCornerShape(28.dp),
            singleLine = true,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                cursorColor = MaterialTheme.colorScheme.primary
            )
        )
    }
}


@Preview(showBackground = true)
@Composable
fun HomeAppBarPreview_Normal() {
    MoveMateMoniepointTheme {
        HomeAppBar(
            onEnterSearchMode = {},
            onSearchTextChange = {},
            searchText = ""
        )
    }
}

//@Preview(showBackground = true)
//@Composable
//fun HomeAppBarPreview_SearchMode() {
//    MoveMateMoniepointTheme {
//        HomeAppBar(
//            searchMode = true,
//            onSearchClicked = {},
//        )
//    }
//}

