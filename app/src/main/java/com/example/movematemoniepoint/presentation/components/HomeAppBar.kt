package com.example.movematemoniepoint.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movematemoniepoint.R
import com.example.movematemoniepoint.ui.theme.MoveMateMoniepointTheme
import com.example.movematemoniepoint.ui.theme.Pink40
import com.example.movematemoniepoint.ui.theme.PurplePrimary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeAppBar(
    searchText: String,
    onSearchTextChange: (String) -> Unit,
    onCartClicked: () -> Unit,
    onNotificationClicked: () -> Unit,
    onProfileClicked: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(PurplePrimary)
            .padding(horizontal = 16.dp).padding(top = 12.dp, bottom = 12.dp)
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
                    .clickable { onProfileClicked() }
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
                        text = "Your location",
                        style = MaterialTheme.typography.labelLarge,
                        color = Color.LightGray
                    )
                }

                Row(verticalAlignment = Alignment.CenterVertically,modifier = Modifier.padding(top = 2.dp)) {
                    Text(
                        text = "Wertheimer, Illinois",
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
                onClick = { onNotificationClicked() },
                modifier = Modifier
                    .size(36.dp)
                    .padding(end = 8.dp)
                    .background(Color.White, shape = CircleShape)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_notifcation_icon),
                    contentDescription = "Notifications"
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Search box
        TextField(
            value = searchText,
            onValueChange = onSearchTextChange,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            placeholder = {
                Text(
                    text = "Enter the receipt number ...",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(bottom = 2.dp)
                )
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search Icon",
                    tint = PurplePrimary
                )
            },
            trailingIcon = {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(Color(0xFFE67E22))
                        .clickable { onCartClicked() },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_scanner),
                        contentDescription = "Receipt",
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
            onCartClicked = {},
            onProfileClicked = {},
            onNotificationClicked = {},
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

