package com.example.jettrivia.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.LinearGradient
import androidx.compose.ui.graphics.LinearGradientShader
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jettrivia.ui.theme.JetTriviaColors

@Composable
fun JetTriviaProgressBar(modifier: Modifier = Modifier, progress: Float = 0f) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(45.dp)
            .padding(3.dp)
            .border(
                width = 3.dp,
                color = Color.Gray,
                shape = RoundedCornerShape(25.dp)
            )
            .clip(RoundedCornerShape(25.dp))
    ) {
        Button(
            modifier = Modifier
                .fillMaxWidth(progress)
                .background(
                    brush = Brush.linearGradient(
                        listOf(JetTriviaColors.progressBarStart, JetTriviaColors.progressBarEnd)
                    )
                ),
            contentPadding = PaddingValues(1.dp),
            onClick = {},
            elevation = null,
            enabled = false
        ) {}
    }

}

@Composable
fun JetTriviaButton(modifier: Modifier = Modifier, onClick: () -> Unit, label: String) {
    Button(
        modifier = modifier,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = JetTriviaColors.mLightBlue)
    ) {
        Text(text = label.uppercase())
    }
}

@Preview(showBackground = true)
@Composable
private fun Buttons() {
    Column {
        JetTriviaButton(onClick = { }, label = "my label")
        JetTriviaProgressBar()
    }

}

@Composable
fun JetTriviaRadioButton(
    modifier: Modifier = Modifier,
    isSelected: Boolean,
    onClick: () -> Unit,
    text: String,
    selectedColor: Color,
    textColor: Color
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(3.dp)
            .clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = isSelected,
            onClick = onClick,
            colors = RadioButtonDefaults.colors(
                selectedColor = selectedColor
            )
        )
        Text(
            text = text,
            color = textColor,
            fontWeight = if (isSelected) FontWeight.Bold
            else FontWeight.Normal
        )
    }
}