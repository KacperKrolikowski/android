package pl.autopay.parkology.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import pl.autopay.parkology.data.database.ParksDao
import pl.autopay.parkology.data.database.ParksDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Provides
    @Singleton
    fun provideParksDatabase(@ApplicationContext context: Context): ParksDatabase {
        return Room.databaseBuilder(
            context,
            ParksDatabase::class.java,
            PARKS_DB
        ).build()
    }

    @Provides
    @Singleton
    fun provideParksDao(parksDatabase: ParksDatabase): ParksDao =
        parksDatabase.parksDao()

    companion object {
        private const val PARKS_DB = "PARKS_DB"
    }
}