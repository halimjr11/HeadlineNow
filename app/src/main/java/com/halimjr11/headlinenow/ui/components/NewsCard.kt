package com.halimjr11.headlinenow.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.halimjr11.headlinenow.R
import com.halimjr11.headlinenow.ui.theme.HeadlineNowTheme
import com.halimjr11.headlinenow.ui.theme.Typography

@Composable
fun NewsCard(
    imageUrl: String,
    category: String,
    title: String,
    source: String,
    timeAgo: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 6.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Column {
            // Image
            AsyncImage(
                model = imageUrl,
                contentDescription = title,
                placeholder = painterResource(R.drawable.banner),
                error = painterResource(R.drawable.banner),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .clip(RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp))
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Category
            Text(
                text = category,
                style = Typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
                modifier = Modifier.padding(horizontal = 12.dp)
            )

            // Title
            Text(
                text = title,
                style = Typography.titleMedium.copy(fontWeight = FontWeight.SemiBold),
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp)
            )

            Spacer(modifier = Modifier.height(4.dp))

            // Source & Time
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Source icon (dummy bbc logo placeholder)
                Image(
                    painter = painterResource(id = R.drawable.logo), // add your source logo here
                    contentDescription = "Source",
                    modifier = Modifier
                        .size(18.dp)
                        .clip(RoundedCornerShape(50))
                        .background(MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f))
                )

                Spacer(modifier = Modifier.width(6.dp))

                Text(
                    text = source,
                    style = Typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )

                Spacer(modifier = Modifier.width(12.dp))

                Icon(
                    imageVector = Icons.Default.AccessTime,
                    contentDescription = "Time",
                    tint = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
                    modifier = Modifier.size(14.dp)
                )

                Spacer(modifier = Modifier.width(4.dp))

                Text(
                    text = timeAgo,
                    style = Typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                )
            }
        }
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    name = "NewsCard Light"
)
@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "NewsCard Dark"
)
@Composable
fun PreviewNewsCard() {
    HeadlineNowTheme {
        NewsCard(
            imageUrl = "https://ichef.bbci.co.uk/news/976/cpsprodpb/12A23/production/_124178139_moskva.jpg",
            category = "Europe",
            title = "Russian warship: Moskva sinks in Black Sea",
            source = "BBC News",
            timeAgo = "4h ago"
        )
    }
}
