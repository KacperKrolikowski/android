package pl.autopay.parkology.data.repository

import kotlinx.coroutines.flow.flow
import pl.autopay.parkology.data.network.service.NetworkService
import javax.inject.Inject

class ParkRepository @Inject constructor(
    private val service: NetworkService
) {
    fun getParks(page: Int = 0) = flow { emit(service.getParks(page = page)) }
}