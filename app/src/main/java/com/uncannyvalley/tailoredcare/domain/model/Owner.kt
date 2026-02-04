package com.uncannyvalley.tailoredcare.domain.model

data class Owner(
    val id: Long = 0L,
    val fullName: String,
    val phone: String?,
    val email: String?
)
