package pl.autopay.parkology.data.repository

import kotlinx.coroutines.flow.flow
import pl.autopay.parkology.data.database.ParksDao
import pl.autopay.parkology.ui.details.ParkDetailsEntity
import pl.autopay.parkology.ui.details.mapToParkEntity
import javax.inject.Inject

class FavouritesRepository @Inject constructor(
    private val parksDao: ParksDao
) {
    fun getSavedParks() = flow { emit(parksDao.getSavedParks()) }

    suspend fun checkIsParkSaved(parkId: String) = parksDao.checkIsSaved(parkId) != null

    suspend fun savePark(park: ParkDetailsEntity) = parksDao.addPark(park.mapToParkEntity())

    suspend fun deletePark(park: ParkDetailsEntity) = parksDao.deletePark(park.mapToParkEntity())
}