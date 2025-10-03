package com.halimjr11.headlinenow.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.halimjr11.headlinenow.R

@Composable
fun Avatar(imageUrl: String, modifier: Modifier = Modifier) {
    AsyncImage(
        model = imageUrl,
        contentDescription = "Avatar",
        placeholder = painterResource(R.drawable.logo),
        modifier = modifier
            .size(32.dp)
            .clip(CircleShape)
    )
}
