package com.uncannyvalley.tailoredcare.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.uncannyvalley.tailoredcare.R
import com.uncannyvalley.tailoredcare.presentation.model.PetCardUiModel
import com.uncannyvalley.tailoredcare.presentation.theme.TailoredCareTheme

@Composable
fun PetCard(
    pet: PetCardUiModel,
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null
) {
    val shape = RoundedCornerShape(14.dp)

    Card(
        modifier = modifier
            .width(220.dp)
            .height(136.dp)
            .clip(shape)
            .border(BorderStroke(4.dp, MaterialTheme.colorScheme.primary), shape)
            .clickable(enabled = onClick != null) { onClick?.invoke() },
        shape = shape,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                // Pet image / icon
                val imageModifier = Modifier
                    .size(72.dp)
                    .align(Alignment.CenterStart)
                    .padding(start = 26.dp)

                if (!pet.imageUri.isNullOrEmpty()) {
                    AsyncImage(
                        model = pet.imageUri,
                        contentDescription = "Photo of your pet",
                        modifier = imageModifier.clip(CircleShape),
                        contentScale = ContentScale.Crop
                    )
                } else {
                    Image(
                        painter = painterResource(pet.iconResId),
                        contentDescription = null,
                        modifier = imageModifier
                    )
                }

                Column(
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(end = 24.dp)
                ) {
                    Text(
                        text = pet.name,
                        color = MaterialTheme.colorScheme.primary,
                        style = MaterialTheme.typography.labelLarge
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PetCardPreview() {

    val samplePetWithoutImage = PetCardUiModel(
        id = 2L,
        name = "Bobby",
        imageUri = null, // no image
        iconResId = R.drawable.ic_dog
    )

    TailoredCareTheme(darkTheme = false) {
        PetCard(
            pet = samplePetWithoutImage,
            onClick = {}
        )
    }
}