package com.uncannyvalley.tailoredcare.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "medical_cards",
    foreignKeys = [
        ForeignKey(
            entity = OwnerEntity::class,
            parentColumns = ["id"],
            childColumns = ["ownerId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("ownerId")]
)
data class MedicalCardEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val ownerId: Long,
    val petName: String,
    val petType: String,
    val breed: String?,
    val gender: String,
    val birthDate: String?,
    val weightKg: Double?,
    val isSterilized: Boolean,
    val origin: String?,
    val chipNumber: String?,
    val createdAt: String,
    val imageUri: String? = null
)
