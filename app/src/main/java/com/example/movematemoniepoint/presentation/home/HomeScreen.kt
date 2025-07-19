package com.example.movematemoniepoint.presentation.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.movematemoniepoint.presentation.components.HomeAppBar
import com.example.movematemoniepoint.ui.theme.PurplePrimary

@Composable
fun HomeScreen() {
    val appBarVisible = remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        appBarVisible.value = true
    }

    Column {
        AnimatedVisibility(
            visible = appBarVisible.value,
            enter = fadeIn(tween(1000)) + slideInVertically(initialOffsetY = { -1000 }),
        ) {
            // Wrap the whole top section including status bar space
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = WindowInsets.statusBars.asPaddingValues().calculateTopPadding())
                    .background(PurplePrimary) // handles status bar
            ) {
                HomeAppBar(
                    searchText = "", // or use remember state
                    onSearchTextChange = {},
                    onCartClicked = {},
                    onNotificationClicked = {},
                    onProfileClicked = {}
                )
            }
        }

        // Rest of screen content (e.g. LazyColumn)
    }
}

