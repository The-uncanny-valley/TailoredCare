package com.uncannyvalley.tailoredcare.presentation.mapper

import com.uncannyvalley.tailoredcare.R
import com.uncannyvalley.tailoredcare.domain.model.MedicalCard
import com.uncannyvalley.tailoredcare.domain.model.PetType
import com.uncannyvalley.tailoredcare.presentation.model.PetCardUiModel

fun MedicalCard.toUiModel(): PetCardUiModel =
    PetCardUiModel(
        id = id,
        name = petName,
        imageUri = imageUri,
        iconResId = when (petType) {
            PetType.CAT -> R.drawable.ic_cat
            PetType.DOG -> R.drawable.ic_dog
            PetType.BIRD -> R.drawable.ic_bird
            PetType.RODENT -> R.drawable.ic_rodent
            PetType.OTHER -> R.drawable.ic_other
        }
    )