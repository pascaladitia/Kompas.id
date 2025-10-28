package com.pascal.kompasid.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.pascal.kompasid.R
import com.pascal.kompasid.ui.component.dialog.ShowDialog
import com.pascal.kompasid.ui.component.screenUtils.LoadingScreen
import com.pascal.kompasid.ui.component.screenUtils.TopAppBarComponent
import com.pascal.kompasid.ui.screen.home.component.homeArticles
import com.pascal.kompasid.ui.screen.home.component.homeBanner
import com.pascal.kompasid.ui.screen.home.component.homeBreakingNews
import com.pascal.kompasid.ui.screen.home.component.homeCampaign
import com.pascal.kompasid.ui.screen.home.component.homeHotTopics
import com.pascal.kompasid.ui.screen.home.component.homeLiveReport
import com.pascal.kompasid.ui.screen.home.state.HomeUIState
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
        HomeContent(uiState = uiState)
    }
}

@Composable
fun HomeContent(
    modifier: Modifier = Modifier,
    uiState: HomeUIState = HomeUIState()
) {
    val event = LocalHomeEvent.current
    val coroutine = rememberCoroutineScope()

    val tabItems = NewsTab.entries
    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { tabItems.size }
    )

    Column(
        modifier = modifier.fillMaxSize()
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
                divider = {},
                indicator = { tabPositions ->
                    TabRowDefaults.SecondaryIndicator(
                        modifier = Modifier.tabIndicatorOffset(tabPositions[pagerState.currentPage]),
                        color = Color.Green
                    )
                }
            ) {
                tabItems.forEachIndexed { index, tab ->
                    Tab(
                        selected = pagerState.currentPage == index,
                        onClick = {
                            coroutine.launch {
                                pagerState.animateScrollToPage(index)
                            }
                        },
                        modifier = Modifier
                            .background(Color.Transparent)
                            .padding(8.dp)
                    ) {
                        Text(
                            text = tab.title,
                            style = MaterialTheme.typography.bodyMedium.copy(
                                color = Color.White
                            )
                        )
                    }
                }
            }
        }

        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize(),
            userScrollEnabled = false
        ) { page ->
            when (tabItems[page]) {
                NewsTab.FIRST -> HomeFirstTab(uiState = uiState)
                NewsTab.NEW -> HomeFirstTab(uiState = uiState)
                NewsTab.CHOICE -> HomeFirstTab(uiState = uiState)
                NewsTab.FREE -> HomeFirstTab(uiState = uiState)
                NewsTab.FAVORITE -> HomeFirstTab(uiState = uiState)
            }
        }
    }
}

@Composable
fun HomeFirstTab(
    modifier: Modifier = Modifier,
    uiState: HomeUIState = HomeUIState()
) {
    LazyColumn(
        modifier = modifier.fillMaxSize()
    ) {
        homeBreakingNews(item = uiState.breakingNews)

        homeLiveReport(item = uiState.liveReport)

        homeCampaign(item = uiState.iframeCampaign)

        homeHotTopics(item = uiState.hotTopics)

        homeArticles(item = uiState.kabinet)

        homeArticles(item = uiState.ponAcehSumut)

        homeBanner(item = uiState.adsBanner)
    }
}

@Preview(showBackground = true)
@Composable
private fun HomePreview() {
    AppTheme {
        HomeContent()
    }
}