package com.halimjr11.headlinenow.features.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.halimjr11.headlinenow.domain.model.ArticleDomain
import com.halimjr11.headlinenow.ui.components.NewsFooter
import com.halimjr11.headlinenow.ui.theme.Typography

@Composable
fun DetailsRoute(
    onBackPressed: () -> Unit,
    argsId: ArticleDomain,
    viewModel: DetailViewModel = hiltViewModel()
) {

    var newsArticle: ArticleDomain? = null

    with(viewModel) {
        onViewLoaded(articleDomain = argsId)

        val dataDetails = viewModel.shouldShowDetails.collectAsState()
        dataDetails.value.apply {
            this.onSuccess { movieDetailsResult = it }
            this.onLoading { }
            this.onError { e -> println("Error: ${e.message}") }
        }
    }

    newsArticle?.let {
        DetailScreen(
            article = it,
            onBackClick = onBackPressed
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    article: ArticleDomain,
    onBackClick: () -> Unit
) {
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
                    IconButton(onClick = { /* share */ }) {
                        Icon(Icons.Default.Share, contentDescription = "Share")
                    }
                }
            )
        },
        bottomBar = {
            NewsFooter(onLikeClick = {}, onCommentClick = {}, onBookmarkClick = {})
        }
    ) { innerPadding ->
        // Content scrollable
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
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
        }
    }
}
