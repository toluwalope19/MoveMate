package com.example.movematemoniepoint.presentation.shipment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movematemoniepoint.data.DeliveryRepository
import com.example.movematemoniepoint.data.VehicleRepository
import com.example.movematemoniepoint.domain.AvailableVehicle
import com.example.movematemoniepoint.domain.Delivery
import com.example.movematemoniepoint.domain.DeliveryStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject


enum class DeliveryTab(val status: DeliveryStatus?, val title: String) {
    ALL(null, "All"),
    COMPLETED(DeliveryStatus.COMPLETED, "Completed"),
    IN_PROGRESS(DeliveryStatus.IN_PROGRESS, "In Progress"),
    PENDING(DeliveryStatus.PENDING_ORDER, "Pending"),
    CANCELLED(DeliveryStatus.CANCELLED, "Cancelled")
}


@HiltViewModel
class ShipmentViewModel @Inject constructor() : ViewModel() {

    private val _deliveries = MutableStateFlow<List<Delivery>>(emptyList())
    val deliveries = _deliveries.asStateFlow()


    init {
        loadData()
    }

    fun getDeliveriesByStatus(status: DeliveryStatus?): List<Delivery> {
        return if (status == null) _deliveries.value
        else _deliveries.value.filter { it.status == status }
    }


    fun getDeliveryCountsByStatus(): Map<DeliveryStatus?, Int> {
        val list = _deliveries.value

        return buildMap {
            put(null, list.size)
            DeliveryStatus.entries.forEach { status ->
                put(status, list.count { it.status == status })
            }
        }
    }


    private fun loadData() {
        _deliveries.value = DeliveryRepository.getAllDeliveries()
    }

}
