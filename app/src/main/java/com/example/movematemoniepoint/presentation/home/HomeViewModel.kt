package com.example.movematemoniepoint.presentation.home

import androidx.lifecycle.ViewModel
import com.example.movematemoniepoint.data.DeliveryRepository
import com.example.movematemoniepoint.data.VehicleRepository
import com.example.movematemoniepoint.domain.AvailableVehicle
import com.example.movematemoniepoint.domain.Delivery
import com.example.movematemoniepoint.domain.DeliveryStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class DeliveryViewModel @Inject constructor() : ViewModel() {

    private val _deliveries = MutableStateFlow<List<Delivery>>(emptyList())
    val deliveries = _deliveries.asStateFlow()

    private val _vehicles = MutableStateFlow<List<AvailableVehicle>>(emptyList())
    val vehicles = _vehicles.asStateFlow()

    init {
        loadData()
    }

    private fun loadData() {
        _deliveries.value = DeliveryRepository.getAllDeliveries()
        _vehicles.value = VehicleRepository.getAvailableVehicles()
    }

    fun getDeliveriesByStatus(status: DeliveryStatus?): List<Delivery> {
        return if (status == null) _deliveries.value
        else _deliveries.value.filter { it.status == status }
    }
}
