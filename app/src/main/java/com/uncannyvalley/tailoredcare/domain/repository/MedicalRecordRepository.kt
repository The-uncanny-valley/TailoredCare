package com.uncannyvalley.tailoredcare.domain.repository

import com.uncannyvalley.tailoredcare.domain.model.MedicalRecord
import kotlinx.coroutines.flow.Flow

interface MedicalRecordRepository {

    fun observeByCard(cardId: Long): Flow<List<MedicalRecord>>

    suspend fun getEntryById(id: Long): MedicalRecord?

    suspend fun addEntry(entry: MedicalRecord)

    suspend fun updateEntry(entry: MedicalRecord)

    suspend fun deleteEntry(entry: MedicalRecord)
}