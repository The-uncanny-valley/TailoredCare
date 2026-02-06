package com.uncannyvalley.tailoredcare.presentation.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uncannyvalley.tailoredcare.presentation.state.NewPetUiState
import com.uncannyvalley.tailoredcare.presentation.theme.Poppins
import com.uncannyvalley.tailoredcare.presentation.theme.TailoredCareTheme

@Composable
fun ActionButton(
    state: NewPetUiState,
    onNext: () -> Unit,
    onSave: () -> Unit,
    modifier: Modifier = Modifier
) {
    val shape = RoundedCornerShape(15.dp)
    val colors = ButtonDefaults.buttonColors(
        containerColor = MaterialTheme.colorScheme.primaryContainer,        // enabled color
        disabledContainerColor = MaterialTheme.colorScheme.errorContainer
    )

    Button(
        onClick = if (state.currentStep < state.maxStep) onNext else onSave,
        enabled = state.isStepValid,
        shape = shape,
        colors = colors,
        contentPadding = PaddingValues(vertical = 16.dp),
        modifier = modifier
            .fillMaxWidth()
            .padding(24.dp)
    ) {
        Text(
            text = if (state.currentStep < state.maxStep) "Continue" else "Save",
            color = Color.White,
            fontFamily = Poppins,
            fontWeight = FontWeight.Medium,
            fontSize = 20.sp
        )
    }
}


@Preview(showBackground = false)
@Composable
fun ActionButtonPreviewStep1() {
    TailoredCareTheme(darkTheme = false) {
        ActionButton(
            state = NewPetUiState(
                currentStep = 1,   // less than maxStep
                maxStep = 3,
                petName = "Milo"   // valid name → isStepValid = true
            ),
            onNext = {},
            onSave = {}
        )
    }
}

@Preview(showBackground = false)
@Composable
fun ActionButtonPreviewStep3() {
    TailoredCareTheme(darkTheme = false) {
        ActionButton(
            state = NewPetUiState(
                currentStep = 3,   // last step → should show "Save"
                maxStep = 3,
                petName = "Milo"
            ),
            onNext = {},
            onSave = {}
        )
    }
}

@Preview(showBackground = false)
@Composable
fun ActionButtonPreviewInvalid() {
    TailoredCareTheme(darkTheme = false) {
        ActionButton(
            state = NewPetUiState(
                currentStep = 1,
                maxStep = 3,
                petName = ""       // invalid name → button disabled
            ),
            onNext = {},
            onSave = {}
        )
    }

}
