package com.uncannyvalley.tailoredcare.data.mappers

import com.uncannyvalley.tailoredcare.data.local.entity.AppointmentEntity
import com.uncannyvalley.tailoredcare.data.local.entity.DoctorEntity
import com.uncannyvalley.tailoredcare.data.local.entity.MedicalCardEntity
import com.uncannyvalley.tailoredcare.data.local.entity.MedicalRecordEntity
import com.uncannyvalley.tailoredcare.data.local.entity.OwnerEntity
import com.uncannyvalley.tailoredcare.data.local.entity.VaccinationEntity
import com.uncannyvalley.tailoredcare.domain.model.Appointment
import com.uncannyvalley.tailoredcare.domain.model.AppointmentStatus
import com.uncannyvalley.tailoredcare.domain.model.Doctor
import com.uncannyvalley.tailoredcare.domain.model.Gender
import com.uncannyvalley.tailoredcare.domain.model.MedicalCard
import com.uncannyvalley.tailoredcare.domain.model.MedicalRecord
import com.uncannyvalley.tailoredcare.domain.model.Owner
import com.uncannyvalley.tailoredcare.domain.model.PetType
import com.uncannyvalley.tailoredcare.domain.model.Vaccination
import com.uncannyvalley.tailoredcare.domain.model.VaccineType
import java.time.LocalDate
import java.time.LocalDateTime

fun MedicalCardEntity.toDomain(): MedicalCard = MedicalCard(
    id = id,
    ownerId = ownerId,
    petName = petName,
    petType = PetType.valueOf(petType),
    breed = breed,
    gender = Gender.valueOf(gender),
    birthDate = birthDate?.let(LocalDate::parse),
    weightKg = weightKg,
    isSterilized = isSterilized,
    chipNumber = chipNumber,
    origin = origin,
    createdAt = LocalDate.parse(createdAt)
)

fun MedicalCard.toEntity(): MedicalCardEntity = MedicalCardEntity(
    id = id,
    ownerId = ownerId,
    petName = petName,
    petType = petType.name,
    breed = breed,
    gender = gender.name,
    birthDate = birthDate?.toString(),
    weightKg = weightKg,
    isSterilized = isSterilized,
    chipNumber = chipNumber,
    origin = origin,
    createdAt = createdAt.toString()
)

fun OwnerEntity.toDomain(): Owner = Owner(
    id = id,
    fullName = fullName,
    phone = phone,
    email = email
)

fun Owner.toEntity(): OwnerEntity = OwnerEntity(
    id = id,
    fullName = fullName,
    phone = phone,
    email = email
)

fun DoctorEntity.toDomain(): Doctor = Doctor(
    id = id,
    fullName = fullName,
    specialization = specialization,
    phone = phone
)

fun Doctor.toEntity(): DoctorEntity = DoctorEntity(
    id = id,
    fullName = fullName,
    specialization = specialization,
    phone = phone
)

fun VaccinationEntity.toDomain(): Vaccination = Vaccination(
    id = id,
    medicalCardId = medicalCardId,
    type = VaccineType.valueOf(type),
    vaccinationDate = LocalDate.parse(vaccinationDate),
    nextVaccinationDate = nextVaccinationDate?.let(LocalDate::parse),
    notes = notes
)

fun Vaccination.toEntity(): VaccinationEntity = VaccinationEntity(
    id = id,
    medicalCardId = medicalCardId,
    type = type.name,
    vaccinationDate = vaccinationDate.toString(),
    nextVaccinationDate = nextVaccinationDate?.toString(),
    notes = notes
)

fun AppointmentEntity.toDomain(): Appointment = Appointment(
    id = id,
    medicalCardId = medicalCardId,
    doctorId = doctorId,
    appointmentDateTime = LocalDateTime.parse(appointmentDateTime),
    reason = reason,
    status = AppointmentStatus.valueOf(status)
)

fun Appointment.toEntity(): AppointmentEntity = AppointmentEntity(
    id = id,
    medicalCardId = medicalCardId,
    doctorId = doctorId,
    appointmentDateTime = appointmentDateTime.toString(),
    reason = reason,
    status = status.name
)

fun MedicalRecordEntity.toDomain(): MedicalRecord = MedicalRecord(
    id = id,
    medicalCardId = medicalCardId,
    doctorId = doctorId,
    visitDate = LocalDate.parse(visitDate),
    complaints = complaints,
    diagnosis = diagnosis,
    treatment = treatment,
    recommendations = recommendations
)

fun MedicalRecord.toEntity(): MedicalRecordEntity = MedicalRecordEntity(
    id = id,
    medicalCardId = medicalCardId,
    doctorId = doctorId,
    visitDate = visitDate.toString(),
    complaints = complaints,
    diagnosis = diagnosis,
    treatment = treatment,
    recommendations = recommendations
)





