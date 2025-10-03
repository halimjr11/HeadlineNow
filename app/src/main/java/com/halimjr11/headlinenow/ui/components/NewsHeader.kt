package com.halimjr11.headlinenow.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.halimjr11.headlinenow.ui.theme.Typography

@Composable
fun NewsHeader(
    avatarUrl: String,
    source: String,
    time: String,
    onFollowClick: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Avatar(imageUrl = avatarUrl)
            Spacer(Modifier.width(8.dp))
            Column {
                Text(
                    source,
                    style = Typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                    color = MaterialTheme.colorScheme.onSurface
                )
                LabelText(text = time)
            }
        }
//        ButtonPrimary(text = "Following") { onFollowClick() }
    }
}
