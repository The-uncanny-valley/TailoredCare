package com.uncannyvalley.tailoredcare.di

import android.content.Context
import androidx.room.Room
import com.uncannyvalley.tailoredcare.data.local.dao.MedicalCardDao
import com.uncannyvalley.tailoredcare.data.local.dao.OwnerDao
import com.uncannyvalley.tailoredcare.data.local.dao.VaccinationDao
import com.uncannyvalley.tailoredcare.data.local.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "tailored_care_db",
        ).build()
    }

    @Provides
    fun provideMedicalCardDao(database: AppDatabase): MedicalCardDao =
        database.medicalCardDao()

    @Provides
    fun provideVaccinationDao(database: AppDatabase): VaccinationDao =
        database.vaccinationDao()

    @Provides
    fun provideOwnerDao(database: AppDatabase): OwnerDao =
        database.ownerDao()
}