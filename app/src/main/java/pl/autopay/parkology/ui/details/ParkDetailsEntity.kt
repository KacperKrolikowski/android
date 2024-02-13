package pl.autopay.parkology.ui.details

import pl.autopay.parkology.data.database.ParkEntity
import pl.autopay.parkology.data.network.dto.park.Park
import java.io.Serializable

data class ParkDetailsEntity(
    val id: String,
    val name: String,
    val fullName: String,
    val imageUrl: String,
    val description: String
) : Serializable

fun Park.mapToParkDetailsEntity() = ParkDetailsEntity(
    this.id,
    this.name,
    this.fullName,
    this.images.first().url,
    this.description
)

fun ParkDetailsEntity.mapToParkEntity() = ParkEntity(
    this.id,
    this.name,
    this.fullName,
    this.imageUrl,
    this.description
)

fun ParkEntity.mapToParkDetailsEntity() = ParkDetailsEntity(
    this.id,
    this.name,
    this.fullName,
    this.imageUrl,
    this.description
)