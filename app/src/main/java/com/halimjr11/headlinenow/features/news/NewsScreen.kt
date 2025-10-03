package com.halimjr11.headlinenow.features.news

import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.halimjr11.headlinenow.R
import com.halimjr11.headlinenow.domain.model.ArticleDomain
import com.halimjr11.headlinenow.ui.components.ErrorView
import com.halimjr11.headlinenow.ui.components.NewsCard
import com.halimjr11.headlinenow.utils.UiState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsScreen(
    onCardClick: () -> Unit,
    viewModel: NewsViewModel = hiltViewModel()
) {
    val state by viewModel.articlesState.collectAsState()
    val isDark = isSystemInDarkTheme()
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.app_name)) },
                navigationIcon = {
                    IconButton(onClick = { /* handle back */ }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(onClick = {
                        val newMode = if (isDark) {
                            AppCompatDelegate.MODE_NIGHT_NO   // Light mode
                        } else {
                            AppCompatDelegate.MODE_NIGHT_YES  // Dark mode
                        }
                        AppCompatDelegate.setDefaultNightMode(newMode)
                    }) {
                        if (isDark) {
                            Icon(Icons.Default.LightMode, contentDescription = "Switch to Light")
                        } else {
                            Icon(Icons.Default.DarkMode, contentDescription = "Switch to Dark")
                        }
                    }
                }
            )
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentAlignment = Alignment.Center
        ) {
            when (state) {
                is UiState.Loading -> {
                    CircularProgressIndicator()
                }

                is UiState.Error -> {
                    ErrorView(
                        message = (state as UiState.Error).message,
                        onRetry = { viewModel.fetchTrendingNews() }
                    )
                }

                is UiState.Success -> {
                    val articles = (state as UiState.Success<List<ArticleDomain>>).data
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(8.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        items(articles) { article ->
                            NewsCard(
                                imageUrl = article.urlToImage,
                                category = article.source.category,
                                title = article.title,
                                source = article.source.name,
                                timeAgo = article.time,
                            ) {
                                // TODO GO TO DETAIL
                            }
                        }
                    }
                }

                else -> {}
            }
        }
    }
}
