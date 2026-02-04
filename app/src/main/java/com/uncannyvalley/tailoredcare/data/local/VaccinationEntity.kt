package com.uncannyvalley.tailoredcare.data.local

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.uncannyvalley.tailoredcare.domain.model.VaccineType
import java.time.LocalDate

@Entity(
    tableName = "vaccinations",
    foreignKeys = [
        ForeignKey(
            entity = MedicalCardEntity::class,
            parentColumns = ["id"],
            childColumns = ["medicalCardId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("medicalCardId")]
)
data class VaccinationEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    val medicalCardId: Long,
    val type: String,
    val vaccinationDate: String,
    val nextVaccinationDate: String?,
    val notes: String?
)
