package com.example.movematemoniepoint.presentation.calculate

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

data class DestinationInputState(
    val sender: String = "",
    val receiver: String = "",
    val weight: String = ""
)


sealed class DestinationInputEvent {
    data class OnSenderChanged(val value: String) : DestinationInputEvent()
    data class OnReceiverChanged(val value: String) : DestinationInputEvent()
    data class OnWeightChanged(val value: String) : DestinationInputEvent()
}


class CalculateViewModel : ViewModel() {

    var destinationInputState by mutableStateOf(DestinationInputState())
        private set

    private val _selectedCategories = mutableStateListOf<String>()
    val selectedCategories: List<String> get() = _selectedCategories

    val allCategories = listOf(
        "Documents", "Glass", "Liquid", "Food",
        "Electronic", "Product", "Others"
    )


    fun onCategorySelected(category: String) {
        if (_selectedCategories.contains(category)) {
            _selectedCategories.remove(category)
        } else {
            _selectedCategories.add(category)
        }
    }


    fun onDestinationInputChanged(event: DestinationInputEvent) {
        destinationInputState = when (event) {
            is DestinationInputEvent.OnSenderChanged ->
                destinationInputState.copy(sender = event.value)

            is DestinationInputEvent.OnReceiverChanged ->
                destinationInputState.copy(receiver = event.value)

            is DestinationInputEvent.OnWeightChanged ->
                destinationInputState.copy(weight = event.value)
        }
    }
}
