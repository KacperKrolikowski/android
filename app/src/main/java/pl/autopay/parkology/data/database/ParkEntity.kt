package pl.autopay.parkology.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "parks")
data class ParkEntity (
    @PrimaryKey(autoGenerate = false) @ColumnInfo(name = "parkId") val id: String,
    val name: String,
    val fullName: String,
    val imageUrl: String,
    val description: String
)