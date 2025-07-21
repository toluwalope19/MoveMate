package com.example.movematemoniepoint.presentation.shipment.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.movematemoniepoint.domain.DeliveryStatus
import com.example.movematemoniepoint.ui.theme.Orange
import com.example.movematemoniepoint.ui.theme.PurplePrimary

@Composable
fun DeliveryTabRow(
    selectedTab: DeliveryStatus?,
    onTabSelected: (DeliveryStatus?) -> Unit,
    counts: Map<DeliveryStatus?, Int>
) {
    val tabs = listOf(null) + DeliveryStatus.values().toList()

    val selectedColor = Color.White
    val unselectedTextColor = Color.White.copy(alpha = 0.5f)
    val selectedCountBg = Color(0xFFFF8700)
    val unselectedCountBg = Color.White.copy(alpha = 0.2f)
    val unselectedCountTextColor = Color.White.copy(alpha = 0.6f)

    ScrollableTabRow(
        selectedTabIndex = tabs.indexOf(selectedTab),
        edgePadding = 16.dp,
        containerColor = PurplePrimary,
        modifier = Modifier
            .height(64.dp)
            .background(PurplePrimary),
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                Modifier.tabIndicatorOffset(tabPositions[tabs.indexOf(selectedTab)]),
                height = 3.dp,
                color = selectedCountBg
            )
        },
        divider = {}
    ) {
        tabs.forEach { tab ->
            val isSelected = tab == selectedTab
            val label = tab?.tabName ?: "All"
            val count = counts[tab] ?: 0

            Tab(
                selected = isSelected,
                onClick = { onTabSelected(tab) },
                selectedContentColor = selectedColor,
                unselectedContentColor = unselectedTextColor,
                modifier = Modifier.height(56.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 12.dp)
                ) {
                    Text(
                        text = label,
                        color = if (isSelected) selectedColor else unselectedTextColor,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                        fontSize = 18.sp
                    )

                    Spacer(modifier = Modifier.width(4.dp))

                    Box(
                        modifier = Modifier
                            .background(
                                color = if (isSelected) selectedCountBg else unselectedCountBg,
                                shape = RoundedCornerShape(10.dp)
                            )
                            .padding(horizontal = 9.dp, vertical = 4.dp)
                    ) {
                        Text(
                            text = count.toString(),
                            color = if (isSelected) selectedColor else unselectedCountTextColor,
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}




@Preview(showBackground = true)
@Composable
fun DeliveryTabRowPreview() {
    var selectedTab by remember { mutableStateOf<DeliveryStatus?>(null) }

    val counts = mapOf(
        null to 10,
        DeliveryStatus.COMPLETED to 3,
        DeliveryStatus.IN_PROGRESS to 2,
        DeliveryStatus.PENDING_ORDER to 4,
        DeliveryStatus.CANCELLED to 1
    )

    Column {
        DeliveryTabRow(
            selectedTab = selectedTab,
            onTabSelected = { selectedTab = it },
            counts = counts
        )
    }
}

