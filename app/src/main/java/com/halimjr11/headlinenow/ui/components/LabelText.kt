package com.halimjr11.headlinenow.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import com.halimjr11.headlinenow.ui.theme.Typography

@Composable
fun LabelText(text: String, color: Color = Color.Gray, style: TextStyle = Typography.labelSmall) {
    Text(text = text, color = color, style = style)
}
