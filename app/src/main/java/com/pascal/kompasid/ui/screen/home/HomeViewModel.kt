package com.pascal.kompasid.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pascal.kompasid.domain.usecase.local.LocalUseCase
import com.pascal.kompasid.domain.usecase.movie.NewsUseCase
import com.pascal.kompasid.ui.screen.home.state.HomeUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val newsUseCase: NewsUseCase,
    private val localUseCase: LocalUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUIState())
    val uiState: StateFlow<HomeUIState> = _uiState.asStateFlow()

    fun loadDashboard() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            newsUseCase.dashboard()
                .catch { e ->
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            error = true to e.message.toString()
                        )
                    }

                }
                .collectLatest { data ->
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            dashboard = data
                        )
                    }
                }
        }
    }

    fun setError(value: String) {
        _uiState.update { it.copy(error = false to value) }
    }
}