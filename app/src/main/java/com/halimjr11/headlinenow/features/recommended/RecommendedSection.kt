package com.halimjr11.headlinenow.features.recommended

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.halimjr11.headlinenow.domain.model.ArticleDomain
import com.halimjr11.headlinenow.domain.model.SourceDomain
import com.halimjr11.headlinenow.ui.components.RecommendedCard
import com.halimjr11.headlinenow.ui.theme.HeadlineNowTheme
import com.halimjr11.headlinenow.ui.theme.Typography

@Composable
fun RecommendedSection(
    title: String = "Recommended for you",
    articles: List<ArticleDomain>,
    onArticleClick: (ArticleDomain) -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = title,
            style = Typography.titleMedium,
            modifier = Modifier.padding(vertical = 8.dp)
        )

        LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            items(articles) { article ->
                RecommendedCard(article = article, onClick = { onArticleClick(article) })
            }
        }
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    name = "Reccommended Light"
)
@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "Recommended Dark"
)
@Composable
fun PreviewRecommendedSection() {
    val mockArticles = listOf(
        ArticleDomain(
            title = "Russia-Ukraine conflict: latest updates",
            urlToImage = "https://ichef.bbci.co.uk/news/976/cpsprodpb/12A23/production/_124178139_moskva.jpg",
            source = SourceDomain("bbc.com", "BBC News")
        ),
        ArticleDomain(
            title = "EU proposes new sanctions on Russian oil",
            urlToImage = "https://ichef.bbci.co.uk/news/976/cpsprodpb/5C9E/production/_124178141_eu.jpg",
            source = SourceDomain("cnn.com", "CNN")
        ),
        ArticleDomain(
            title = "Ukrainian cities face more shelling overnight",
            urlToImage = "https://ichef.bbci.co.uk/news/976/cpsprodpb/AB12/production/_124178143_kiev.jpg",
            source = SourceDomain("nytimes.com", "New York Times")
        )
    )

    HeadlineNowTheme {
        RecommendedSection(
            articles = mockArticles,
            onArticleClick = { /* preview no-op */ }
        )
    }
}


