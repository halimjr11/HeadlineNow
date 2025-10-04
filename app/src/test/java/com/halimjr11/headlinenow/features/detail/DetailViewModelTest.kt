package com.halimjr11.headlinenow.features.detail

import com.halimjr11.headlinenow.domain.model.ArticleDomain
import com.halimjr11.headlinenow.domain.usecase.GetRecommendedUseCase
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
class DetailViewModelTest {
    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()
    private lateinit var viewModel: DetailViewModel
    private val getRecommendedUseCase: GetRecommendedUseCase = mockk(relaxed = true)

    @Before
    fun setup() {
        viewModel = DetailViewModel(getRecommendedUseCase, object : CoroutineDispatcherProvider {
            override val io = mainDispatcherRule.testDispatcher
            override val default = mainDispatcherRule.testDispatcher
            override val unconfined = mainDispatcherRule.testDispatcher
            override val main = mainDispatcherRule.testDispatcher
        })
    }

    @Test
    fun `fetchMovieDetails returns success when data is not empty`() = runTest {
        val expectedData = listOf(ArticleDomain(title = "Test"))

        coEvery { getRecommendedUseCase(any()) } returns expectedData

        viewModel.onViewLoaded(ArticleDomain())
        advanceUntilIdle()
        val state = viewModel.shouldShowDetail.value
        assert(state is UiState.Success && state.data == expectedData)
    }

    @Test
    fun `fetchMovieDetails returns error when data is empty`() = runTest {
        val expectedData = emptyList<ArticleDomain>()

        coEvery { getRecommendedUseCase(any()) } returns expectedData

        viewModel.onViewLoaded(ArticleDomain())
        advanceUntilIdle()
        val state = viewModel.shouldShowDetail.value
        assert(state is UiState.Error && state.message == "empty")
    }
}