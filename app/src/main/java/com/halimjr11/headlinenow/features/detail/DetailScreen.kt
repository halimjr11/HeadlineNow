package com.halimjr11.headlinenow.features.detail

import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.halimjr11.headlinenow.domain.model.ArticleDomain
import com.halimjr11.headlinenow.features.recommended.RecommendedSection
import com.halimjr11.headlinenow.ui.theme.Typography
import com.halimjr11.headlinenow.utils.UiState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    onBackClick: () -> Unit,
    onRecommendedClick: (ArticleDomain) -> Unit,
    article: ArticleDomain,
    viewModel: DetailViewModel = hiltViewModel()
) {
    viewModel.onViewLoaded(articleDomain = article)
    val recommendedState by viewModel.shouldShowDetail.collectAsState()
    val context = LocalContext.current
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = article.source.name,
                        style = Typography.titleMedium
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(
                        onClick = {
                            val sendIntent = Intent().apply {
                                action = Intent.ACTION_SEND
                                putExtra(Intent.EXTRA_TEXT, "Check this out: ${article.title}\n${article.url}")
                                type = "text/plain"
                            }
                            val shareIntent = Intent.createChooser(sendIntent, null)
                            context.startActivity(shareIntent)
                        }
                    ) {
                        Icon(Icons.Default.Share, contentDescription = "Share")
                    }

                }
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // detail card
            item {
                NewsDetailCard(
                    source = article.source.name,
                    time = article.time,
                    imageUrl = article.urlToImage,
                    category = article.source.category,
                    title = article.title,
                    description = article.description
                )
            }

            // recommended section
            item {
                when (recommendedState) {
                    is UiState.Loading -> {
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator()
                        }
                    }

                    is UiState.Success -> {
                        val data = (recommendedState as UiState.Success<List<ArticleDomain>>).data
                        RecommendedSection(articles = data) { article ->
                            onRecommendedClick(article)
                        }
                    }

                    else -> {}
                }
            }
        }
    }
}
