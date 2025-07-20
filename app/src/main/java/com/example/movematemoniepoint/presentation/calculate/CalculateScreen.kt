package com.example.movematemoniepoint.presentation.calculate

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.movematemoniepoint.presentation.calculate.components.CalculateButton
import com.example.movematemoniepoint.presentation.calculate.components.CategoriesSection
import com.example.movematemoniepoint.presentation.calculate.components.DestinationSection
import com.example.movematemoniepoint.presentation.calculate.components.PackagingSection
import com.example.movematemoniepoint.ui.theme.PurplePrimary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalculateScreen(
    onBack: () -> Unit = {},
    viewModel: CalculateViewModel = hiltViewModel()
) {
    val state = viewModel.destinationInputState

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Calculate", color = Color.White) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = White)
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = PurplePrimary)
            )
        },
        bottomBar = {
            CalculateButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 16.dp),
                onClick = {

                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 20.dp, vertical = 24.dp)
        ) {
            DestinationSection(
                state = state,
                onValueChange = viewModel::onDestinationInputChanged
            )

            Spacer(modifier = Modifier.height(24.dp))

            PackagingSection()

            Spacer(modifier = Modifier.height(24.dp))

            CategoriesSection(
                allCategories = viewModel.allCategories,
                selectedCategories = viewModel.selectedCategories,
                onCategorySelected = viewModel::onCategorySelected
            )
        }
    }
}

