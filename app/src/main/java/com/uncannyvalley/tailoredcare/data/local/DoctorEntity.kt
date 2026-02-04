package com.uncannyvalley.tailoredcare.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "doctors")
data class DoctorEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val fullName: String,
    val specialization: String?,
    val phone: String?
)
