package pl.autopay.parkology.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [ParkEntity::class],
    version = 1,
    exportSchema = false
)

abstract class ParksDatabase : RoomDatabase() {
    abstract fun parksDao(): ParksDao
}