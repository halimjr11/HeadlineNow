package com.halimjr11.headlinenow.features.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.halimjr11.headlinenow.domain.model.ArticleDomain
import com.halimjr11.headlinenow.domain.usecase.GetRecommendedUseCase
import com.halimjr11.headlinenow.utils.UiState
import com.halimjr11.headlinenow.utils.coroutines.CoroutineDispatcherProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getRecommendedUseCase: GetRecommendedUseCase,
    private val dispatcherProvider: CoroutineDispatcherProvider
) : ViewModel() {
    val shouldShowDetail: MutableStateFlow<UiState<List<ArticleDomain>>> =
        MutableStateFlow(UiState.Loading)

    fun onViewLoaded(articleDomain: ArticleDomain) {
        fetchMovieDetails(articleDomain = articleDomain)
    }

    fun fetchMovieDetails(
        articleDomain: ArticleDomain
    ) = viewModelScope.launch(dispatcherProvider.io) {
        val data = getRecommendedUseCase(articleDomain)
        shouldShowDetail.value =
            if (data.isNotEmpty()) UiState.Success(data) else UiState.Error("empty")
    }

}