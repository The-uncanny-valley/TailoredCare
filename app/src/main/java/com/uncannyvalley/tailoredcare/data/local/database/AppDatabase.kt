package com.uncannyvalley.tailoredcare.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.uncannyvalley.tailoredcare.data.local.dao.AppointmentDao
import com.uncannyvalley.tailoredcare.data.local.dao.DoctorDao
import com.uncannyvalley.tailoredcare.data.local.dao.MedicalCardDao
import com.uncannyvalley.tailoredcare.data.local.dao.MedicalRecordDao
import com.uncannyvalley.tailoredcare.data.local.dao.OwnerDao
import com.uncannyvalley.tailoredcare.data.local.dao.VaccinationDao
import com.uncannyvalley.tailoredcare.data.local.entity.AppointmentEntity
import com.uncannyvalley.tailoredcare.data.local.entity.DoctorEntity
import com.uncannyvalley.tailoredcare.data.local.entity.MedicalCardEntity
import com.uncannyvalley.tailoredcare.data.local.entity.MedicalRecordEntity
import com.uncannyvalley.tailoredcare.data.local.entity.OwnerEntity
import com.uncannyvalley.tailoredcare.data.local.entity.VaccinationEntity

@Database(
    entities = [
        OwnerEntity::class,
        DoctorEntity::class,
        MedicalRecordEntity::class,
        VaccinationEntity::class,
        AppointmentEntity::class,
        MedicalCardEntity::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun ownerDao(): OwnerDao
    abstract fun doctorDao(): DoctorDao
    abstract fun medicalRecordDao(): MedicalRecordDao
    abstract fun vaccinationDao(): VaccinationDao
    abstract fun appointmentDao(): AppointmentDao
    abstract fun medicalCardDao(): MedicalCardDao
}