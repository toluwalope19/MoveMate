package com.example.movematemoniepoint.presentation.home

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.with
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.movematemoniepoint.presentation.components.HomeAppBar
import com.example.movematemoniepoint.presentation.components.SearchModeAppBar
import com.example.movematemoniepoint.ui.theme.PurplePrimary
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.movematemoniepoint.presentation.components.DeliverySearchResults

import javax.inject.Inject

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun HomeScreen(viewModel: DeliveryViewModel = hiltViewModel()) {

    var isSearchMode by remember { mutableStateOf(false) }
    val appBarVisible = remember { mutableStateOf(false) }

    val searchText by viewModel.searchText.collectAsStateWithLifecycle()
    val deliveries by viewModel.filteredDeliveries.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        appBarVisible.value = true
    }

    Column(modifier = Modifier.fillMaxSize()) {
        AnimatedVisibility(
            visible = appBarVisible.value,
            enter = fadeIn(tween(1000)) + slideInVertically(initialOffsetY = { -1000 }),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = WindowInsets.statusBars.asPaddingValues().calculateTopPadding())
                    .background(PurplePrimary)
            ) {
                // 🔁 Toggle app bars based on search state
                AnimatedContent(
                    targetState = isSearchMode,
                    transitionSpec = {
                        (fadeIn(tween(600)) + slideInVertically { it / 2 }) with
                                (fadeOut(tween(400)) + slideOutVertically { -it / 2 })
                    },
                    label = "SearchModeSwitcher"
                ) { inSearch ->
                    if (inSearch) {
                        SearchModeAppBar(
                            searchText = searchText,
                            onSearchTextChange = viewModel::onSearchTextChanged,
                            onBackClicked = {
                                isSearchMode = false
                                viewModel.onSearchTextChanged("")
                            }
                        )
                    } else {
                        HomeAppBar(
                            searchText = searchText,
                            onSearchTextChange = viewModel::onSearchTextChanged,
                            onEnterSearchMode = {
                                isSearchMode = true
                            }
                        )
                    }
                }
            }
        }

        // 🔁 Below content switches with search mode
        if (isSearchMode) {
            DeliverySearchResults(deliveries)
        } else {
            DefaultHomeContent()
        }
    }

}



@Composable
fun DefaultHomeContent() {
    LazyColumn {
        items(10) {
            Text(
                text = "Home item #$it",
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}


