package com.pascal.kompasid.ui.screen.bookmark

import androidx.lifecycle.ViewModel
import com.pascal.kompasid.ui.screen.bookmark.state.BookmarkUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class BookmarkViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(BookmarkUIState())
    val uiState: StateFlow<BookmarkUIState> = _uiState.asStateFlow()

    fun resetError() {
        _uiState.update { it.copy(error = false to "") }
    }
}