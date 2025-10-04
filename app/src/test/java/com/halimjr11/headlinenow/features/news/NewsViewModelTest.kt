package com.halimjr11.headlinenow.features.news

import com.halimjr11.headlinenow.domain.model.ArticleDomain
import com.halimjr11.headlinenow.domain.usecase.GetTopHeadlineUseCase
import com.halimjr11.headlinenow.utils.MainDispatcherRule
import com.halimjr11.headlinenow.utils.UiState
import com.halimjr11.headlinenow.utils.coroutines.CoroutineDispatcherProvider
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class NewsViewModelTest {
    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()
    private lateinit var viewModel: NewsViewModel
    private val getTopHeadlineUseCase: GetTopHeadlineUseCase = mockk(relaxed = true)

    @Before
    fun setup() {
        viewModel = NewsViewModel(getTopHeadlineUseCase, object : CoroutineDispatcherProvider {
            override val io = mainDispatcherRule.testDispatcher
            override val default = mainDispatcherRule.testDispatcher
            override val unconfined = mainDispatcherRule.testDispatcher
            override val main = mainDispatcherRule.testDispatcher
        })
    }

    @Test
    fun `fetchTrendingNews returns success when data is not empty`() = runTest {
        val articles = listOf(ArticleDomain(title = "News 1"))
        coEvery { getTopHeadlineUseCase() } returns articles

        viewModel.fetchTrendingNews()
        advanceUntilIdle()
        val state = viewModel.articlesState.value
        assert(state is UiState.Success && state.data == articles)
    }

    @Test
    fun `fetchTrendingNews returns error when data is empty`() = runTest {
        // Arrange
        coEvery { getTopHeadlineUseCase() } returns emptyList()

        viewModel.fetchTrendingNews()
        advanceUntilIdle()
        val state = viewModel.articlesState.value
        assert(state is UiState.Error && state.message == "empty")
    }
}
