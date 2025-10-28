package com.pascal.kompasid.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pascal.kompasid.domain.usecase.local.LocalUseCase
import com.pascal.kompasid.domain.usecase.news.NewsUseCase
import com.pascal.kompasid.ui.screen.home.state.HomeUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val newsUseCase: NewsUseCase,
    private val localUseCase: LocalUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUIState())
    val uiState: StateFlow<HomeUIState> = _uiState.asStateFlow()

    fun loadHomePartOne() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }

            combine(
                newsUseCase.getAdsBanner(),
                newsUseCase.getBreakingNews(),
                newsUseCase.getHotTopics()
            ) { ads, breaking, hotTopics ->

                _uiState.value.copy(
                    isLoading = false,
                    adsBanner = ads,
                    breakingNews = breaking,
                    hotTopics = hotTopics
                )
            }.catch { e ->
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        error = true to (e.message ?: "Unknown error")
                    )
                }
            }.collect { newState ->
                _uiState.update { newState }
            }
        }
    }

    fun loadHomePartTwo() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }

            combine(
                newsUseCase.getIframeCampaign(),
                newsUseCase.getLiveReport(),
                newsUseCase.getAllCommonSections()
            ) { iframe, live, commonList ->

                _uiState.value.copy(
                    isLoading = false,
                    iframeCampaign = iframe,
                    liveReport = live,
                    articleList = commonList
                )
            }.catch { e ->
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        error = true to (e.message ?: "Unknown error")
                    )
                }
            }.collect { newState ->
                _uiState.update { newState }
            }
        }
    }

    fun resetError() {
        _uiState.update { it.copy(error = false to "") }
    }
}

enum class NewsTab(val title: String) {
    FIRST("Berita Utama"),
    NEW("Terbaru"),
    CHOICE("Pilihanku"),
    FREE("Bebas"),
    FAVORITE("Favorit Pembaca"),
}
