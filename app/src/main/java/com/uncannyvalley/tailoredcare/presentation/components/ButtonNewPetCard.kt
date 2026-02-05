package com.uncannyvalley.tailoredcare.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uncannyvalley.tailoredcare.R
import com.uncannyvalley.tailoredcare.presentation.theme.PastelPurple
import com.uncannyvalley.tailoredcare.presentation.theme.TailoredCareTheme

@Composable
fun ButtonNewPetCard(
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null
) {
    val shape = RoundedCornerShape(14.dp)
    val strokeWidth = 4.dp

    Card(
        modifier = modifier
            .width(152.dp)
            .height(95.dp)
            .clip(shape)
            .drawWithContent {
                drawContent()

                val strokePx = strokeWidth.toPx()
                val halfStroke = strokePx / 2

                drawRoundRect(
                    color = PastelPurple,
                    topLeft = Offset(halfStroke, halfStroke),
                    size = Size(
                        size.width - strokePx,
                        size.height - strokePx
                    ),
                    cornerRadius = CornerRadius(14.dp.toPx()),
                    style = Stroke(
                        width = strokePx,
                        pathEffect = PathEffect.dashPathEffect(
                            floatArrayOf(28f, 28f) // dash length, gap length
                        )
                    )
                )
            }
            .clickable(enabled = onClick != null) { onClick?.invoke() },
        shape = shape,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(R.drawable.ic_plus),
                contentDescription = "Add new pet"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ButtonNewPetCardPreview() {
    TailoredCareTheme(darkTheme = false) {
        ButtonNewPetCard { }
    }
}