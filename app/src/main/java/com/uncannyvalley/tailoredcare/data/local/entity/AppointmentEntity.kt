package com.uncannyvalley.tailoredcare.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "appointments",
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
data class AppointmentEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val medicalCardId: Long,
    val doctorId: Long,
    val appointmentDateTime: String,
    val reason: String?,
    val status: String
)
