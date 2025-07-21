package com.example.movematemoniepoint.presentation.calculate.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movematemoniepoint.R


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CategoriesSection(
    allCategories: List<String>,
    selectedCategories: List<String>,
    onCategorySelected: (String) -> Unit,
    modifier: Modifier = Modifier
) {

    Column(modifier = modifier) {
        Text(
            text = "Categories",
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.SemiBold),
        )

        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = stringResource(R.string.what_are_you_sending),
            style = MaterialTheme.typography.bodySmall,
            color = Color.Gray,
            fontWeight = FontWeight.Light
        )

        Spacer(modifier = Modifier.height(8.dp))

        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            allCategories.forEach { category ->
                CategoryChip(
                    label = category,
                    isSelected = category in selectedCategories,
                    onClick = { onCategorySelected(category) }
                )
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun CategoriesSectionPreview() {
    var selectedCategories by remember { mutableStateOf(listOf<String>()) }

//    MoveMateMoniepointTheme {
//        CategoriesSection(
//            selectedCategories = selectedCategories,
//            onCategorySelected = { category ->
//                selectedCategories = if (selectedCategories.contains(category)) {
//                    selectedCategories - category
//                } else {
//                    selectedCategories + category
//                }
//            }
//        )
//    }
}

