package pl.autopay.parkology.data.network.service

import pl.autopay.parkology.data.network.dto.park.ParkResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkService {
    @GET("parks")
    suspend fun getParks(
        @Query("limit") limit: Int = 20,
        @Query("start") page: Int = 0,
        @Query("q") query: String? = null,
    ): ParkResponseDto
}
