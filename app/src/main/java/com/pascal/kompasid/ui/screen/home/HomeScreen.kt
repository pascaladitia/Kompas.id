package com.pascal.kompasid.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.pascal.kompasid.R
import com.pascal.kompasid.ui.component.dialog.ShowDialog
import com.pascal.kompasid.ui.component.screenUtils.LoadingScreen
import com.pascal.kompasid.ui.component.screenUtils.TopAppBarComponent
import com.pascal.kompasid.ui.screen.home.state.LocalHomeEvent
import com.pascal.kompasid.ui.theme.AppTheme
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues,
    viewModel: HomeViewModel = koinViewModel(),
    onDetail: () -> Unit
) {
    val event = LocalHomeEvent.current
    val coroutineScope = rememberCoroutineScope()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.loadHomePartOne()
        viewModel.loadHomePartTwo()
    }

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
        LocalHomeEvent provides event.copy(
            onDetail = onDetail
        )
    ) {
        Surface(
            modifier = modifier.padding(paddingValues),
            color = MaterialTheme.colorScheme.background
        ) {
            HomeContent()
        }
    }
}

@Composable
fun HomeContent(
    modifier: Modifier = Modifier
) {
    val event = LocalHomeEvent.current
    val coroutine = rememberCoroutineScope()

    val tabTitles = MovieTab.entries
    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { tabTitles.size }
    )

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.primary)
        ) {
            TopAppBarComponent(
                leftIcon1 = Icons.Default.Menu,
                leftIcon2 = Icons.Default.Search,
                rightIcon2 = Icons.Outlined.Notifications
            )

            ScrollableTabRow(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth(),
                selectedTabIndex = pagerState.currentPage,
                containerColor = Color.Transparent,
                edgePadding = 0.dp,
            ) {
                tabTitles.forEachIndexed { index, movie ->
                    Text(
                        modifier = Modifier
                            .padding(bottom = 12.dp)
                            .clickable {
                                coroutine.launch {
                                    pagerState.animateScrollToPage(index)
                                }
                            },
                        text = movie.title,
                        style = MaterialTheme.typography.bodyMedium.copy(
                            color = Color.White
                        ),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }

        LazyColumn(
            modifier = modifier.fillMaxSize()
        ) {
            item {

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomePreview() {
    AppTheme {
        HomeContent()
    }
}