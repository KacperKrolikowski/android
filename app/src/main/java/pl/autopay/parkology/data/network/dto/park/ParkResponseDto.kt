package pl.autopay.parkology.data.network.dto.park

import com.google.gson.annotations.SerializedName

data class ParkResponseDto(
    @SerializedName("total")
    val total: String,
    @SerializedName("data")
    val data: List<Park>,
    @SerializedName("limit")
    val limit: String,
    @SerializedName("start")
    val start: String
)
