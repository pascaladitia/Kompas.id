package com.pascal.kompasid.ui.screen.bookmark

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.pascal.kompasid.R
import com.pascal.kompasid.ui.component.dialog.ShowDialog
import com.pascal.kompasid.ui.component.screenUtils.LoadingScreen
import com.pascal.kompasid.ui.screen.bookmark.state.BookmarkUIState
import com.pascal.kompasid.ui.screen.bookmark.state.LocalBookmarkEvent
import com.pascal.kompasid.ui.theme.AppTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun BookmarkScreen(
    viewModel: BookmarkViewModel = koinViewModel(),
    onNavBack: () -> Unit
) {
    val event = LocalBookmarkEvent.current
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    if (uiState.isLoading) LoadingScreen()

    if (uiState.error.first) {
        ShowDialog(
            message = uiState.error.second,
            textButton = stringResource(R.string.close)
        ) {
            viewModel.resetError()
        }
    }

    CompositionLocalProvider(
        LocalBookmarkEvent provides event.copy(
            onNavBack = onNavBack
        )
    ) {
        BookmarkContent(uiState = uiState)
    }
}

@Composable
fun BookmarkContent(
    modifier: Modifier = Modifier,
    uiState: BookmarkUIState = BookmarkUIState()
) {
    val event = LocalBookmarkEvent.current

    LazyColumn(
        modifier = modifier.fillMaxSize()
    ) {
        item {

        }
    }
}

@Preview(showBackground = true)
@Composable
private fun BookmarkPreview() {
    AppTheme {
        BookmarkContent()
    }
}