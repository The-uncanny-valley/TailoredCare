package com.uncannyvalley.tailoredcare.domain.model

data class Doctor(
    val id: Long = 0L,
    val fullName: String,
    val specialization: String?,
    val phone: String?
)
