package com.example.jettrivia.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun JetTriviaButton(onClick: () -> Unit, label: String) {
    Button(onClick = onClick) {
        Text(text = label.uppercase())
    }
}

@Composable
fun JetTriviaRadioButton(
    modifier: Modifier = Modifier,
    isSelected: Boolean,
    onClick: () -> Unit,
    text: String,
    selectedColor: Color
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(3.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = isSelected,
            onClick = onClick,
            colors = RadioButtonDefaults.colors(
                selectedColor = selectedColor
            )
        )
        Text(text = text)
    }
}