package com.halimjr11.headlinenow.features.detail

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.halimjr11.headlinenow.R
import com.halimjr11.headlinenow.ui.components.LabelText
import com.halimjr11.headlinenow.ui.components.NewsHeader
import com.halimjr11.headlinenow.ui.theme.HeadlineNowTheme
import com.halimjr11.headlinenow.ui.theme.Typography

@Composable
fun NewsDetailCard(
    avatarUrl: String = "",
    source: String,
    time: String,
    imageUrl: String,
    category: String,
    title: String,
    description: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        NewsHeader(avatarUrl, source, time, onFollowClick = {})
        Spacer(Modifier.height(12.dp))

        AsyncImage(
            model = imageUrl,
            contentDescription = "News image",
            placeholder = painterResource(R.drawable.banner),
            modifier = Modifier
                .height(250.dp)
                .clip(RoundedCornerShape(12.dp)),
            contentScale = ContentScale.Crop
        )

        Spacer(Modifier.height(12.dp))
        LabelText(
            category.uppercase(),
            color = MaterialTheme.colorScheme.primary,
            style = Typography.labelSmall
        )
        Spacer(Modifier.height(6.dp))
        Text(
            title,
            color = MaterialTheme.colorScheme.primary,
            style = Typography.titleMedium,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.height(8.dp))
        Text(
            description,
            style = Typography.bodyMedium,
            color = Color.Gray,
            maxLines = 3,
            overflow = TextOverflow.Ellipsis
        )
        Spacer(Modifier.height(12.dp))
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO, name = "News Detail Light")
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES, name = "News Detail Dark")
@Composable
fun PreviewNewsDetailCard() {
    HeadlineNowTheme {
        NewsDetailCard(
            avatarUrl = "https://www.bbc.com/news/articles/c20vyjevxe3o",
            source = "BBC News",
            time = "14m ago",
            imageUrl = "https://i0.wp.com/electrek.co/wp-content/uploads/sites/3/2025/08/Fords-midsize-EV-pickup-name.jpeg?resize=1200%2C628&quality=82&strip=all&ssl=1",
            category = "Europe",
            title = "Ukraine’s President Zelensky to BBC: Blood money being paid for Russian oil",
            description = "Ukrainian President Volodymyr Zelensky has accused European countries that continue to buy Russian oil of 'earning their money in other people’s blood'.",
        )
    }
}
