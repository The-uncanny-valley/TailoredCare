package com.uncannyvalley.tailoredcare.presentation.components


import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uncannyvalley.tailoredcare.presentation.theme.TailoredCareTheme

@Composable
fun RoundedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    modifier: Modifier = Modifier,
    singleLine: Boolean = true,
    enabled: Boolean = true
) {
    var isFocused by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text(placeholder) },
        singleLine = singleLine,
        enabled = enabled,
        modifier = modifier
            .fillMaxWidth()
            .border(
                2.dp,
                color = if (isFocused) MaterialTheme.colorScheme.outlineVariant
                else MaterialTheme.colorScheme.outline,
                RoundedCornerShape(10.dp)
            ),
        shape = RoundedCornerShape(12.dp), // set the shape here
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color.Transparent,
            focusedContainerColor = Color.Transparent,
            cursorColor = MaterialTheme.colorScheme.outlineVariant,
            unfocusedPlaceholderColor = MaterialTheme.colorScheme.onSecondaryContainer,
            focusedPlaceholderColor = MaterialTheme.colorScheme.onSecondaryContainer
        ),
        visualTransformation = VisualTransformation.None
    )
}

@Preview(showBackground = true)
@Composable
fun RoundedTextFieldPreview() {
    var text by remember { mutableStateOf("") }

    TailoredCareTheme() {
        RoundedTextField(
            value = text,
            onValueChange = { text = it },
            placeholder = "Enter text",
            modifier = Modifier.padding(16.dp)
        )
    }
}
