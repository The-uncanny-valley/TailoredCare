package com.uncannyvalley.tailoredcare.presentation.model

import androidx.annotation.DrawableRes

data class PetCardUiModel(
    val id: Long,
    val name: String,
    val imageUri: String?,
    @DrawableRes val iconResId: Int
)
