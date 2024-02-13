package pl.autopay.parkology.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ParksDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addPark(parkEntity: ParkEntity)

    @Delete
    suspend fun deletePark(parkEntity: ParkEntity)

    @Query("SELECT * from parks")
    fun getSavedParks(): Flow<List<ParkEntity>>

    @Query("SELECT * from parks WHERE :searchedId = parkId")
    suspend fun checkIsSaved(searchedId: String): ParkEntity?
}