package com.halimjr11.headlinenow.features.news

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.halimjr11.headlinenow.domain.model.ArticleDomain
import com.halimjr11.headlinenow.domain.usecase.GetTopHeadlineUseCase
import com.halimjr11.headlinenow.utils.UiState
import com.halimjr11.headlinenow.utils.coroutines.CoroutineDispatcherProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val getTopHeadlineUseCase: GetTopHeadlineUseCase,
    private val dispatcher: CoroutineDispatcherProvider
) : ViewModel() {
    private val _articlesState = MutableStateFlow<UiState<List<ArticleDomain>>>(UiState.Loading)
    val articlesState: StateFlow<UiState<List<ArticleDomain>>> = _articlesState

    init {
        fetchTrendingNews()
    }

    fun fetchTrendingNews() = viewModelScope.launch(dispatcher.io) {
        val data = getTopHeadlineUseCase()
        _articlesState.value =
            if (data.isNotEmpty()) UiState.Success(data) else UiState.Error("empty")
    }
}