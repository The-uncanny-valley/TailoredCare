package com.uncannyvalley.tailoredcare.di

import com.uncannyvalley.tailoredcare.data.local.dao.MedicalCardDao
import com.uncannyvalley.tailoredcare.data.local.dao.VaccinationDao
import com.uncannyvalley.tailoredcare.data.repository.MedicalCardRepositoryImpl
import com.uncannyvalley.tailoredcare.data.repository.VaccinationRepositoryImpl
import com.uncannyvalley.tailoredcare.domain.repository.MedicalCardRepository
import com.uncannyvalley.tailoredcare.domain.repository.VaccinationRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideMedicalCarsRepository(
        medicalCardDao: MedicalCardDao
    ): MedicalCardRepository =
        MedicalCardRepositoryImpl(medicalCardDao)

    @Provides
    @Singleton
    fun provideVaccinationRepository(
        vaccinationDao: VaccinationDao
    ): VaccinationRepository =
        VaccinationRepositoryImpl(vaccinationDao)

}