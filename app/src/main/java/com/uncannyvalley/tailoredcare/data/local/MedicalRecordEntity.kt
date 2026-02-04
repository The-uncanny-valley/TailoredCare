package com.uncannyvalley.tailoredcare.data.local

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(
    tableName = "medical_records",
    foreignKeys = [
        ForeignKey(
            entity = MedicalCardEntity::class,
            parentColumns = ["id"],
            childColumns = ["medicalCardId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = DoctorEntity::class,
            parentColumns = ["id"],
            childColumns = ["doctorId"],
            onDelete = ForeignKey.RESTRICT
        )
    ],
    indices = [Index("medicalCardId")]
)
data class MedicalRecordEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val medicalCardId: Long,
    val visitDate: String,
    val complaints: String?,
    val diagnosis: String?,
    val treatment: String?,
    val recommendations: String?,
    val doctorId: Long
)
