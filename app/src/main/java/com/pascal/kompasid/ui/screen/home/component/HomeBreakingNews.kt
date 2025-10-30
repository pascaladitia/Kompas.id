@file:OptIn(ExperimentalSharedTransitionApi::class)

package com.pascal.kompasid.ui.screen.home.component

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pascal.kompasid.R
import com.pascal.kompasid.domain.mapper.toCommonArticle
import com.pascal.kompasid.domain.model.BreakingNews
import com.pascal.kompasid.ui.component.screenUtils.ArticleComponent
import com.pascal.kompasid.ui.component.screenUtils.DynamicAsyncImage
import com.pascal.kompasid.ui.screen.home.state.HomeUIState
import com.pascal.kompasid.ui.screen.home.state.LocalHomeEvent
import com.pascal.kompasid.ui.theme.AppTheme

fun LazyListScope.homeBreakingNews(
    modifier: Modifier = Modifier,
    uiState: HomeUIState = HomeUIState()
) {
    val item: BreakingNews? = uiState.breakingNews
    if (item == null) return

    item {
        val event = LocalHomeEvent.current
        val article = item.toCommonArticle()

        Column(
            modifier = modifier
                .padding(top = 16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .width(100.dp)
                    .height(40.dp),
                painter = painterResource(R.drawable.ic_news),
                contentDescription = null
            )

            ArticleComponent(
                title = item.headline,
                desc = item.subheadline,
                time = item.publishedTime,
                isFavorite = item.isFavorite,
                isCenter = true,
                showDivider = false,
                onItemClick = { event.onDetail(article)},
                onBookmarkClick = { event.onBookMark(article, it) },
                onAudioClick = { event.onAudio(article.audio) },
                onShareClick = { event.onShare(article.share) }
            )

            uiState.sharedTransitionScope?.let {
                with(it) {
                    DynamicAsyncImage(
                        modifier = Modifier
                            .padding(bottom = 16.dp)
                            .fillMaxWidth()
                            .height(200.dp)
                            .sharedElement(
                                state = rememberSharedContentState(article.title),
                                animatedVisibilityScope = uiState.animatedVisibilityScope!!
                            ),
                        imageUrl = item.image,
                        placeholder = painterResource(R.drawable.no_thumbnail),
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                }
            }
        }
    }

    items(item.articles) { item ->
        val event = LocalHomeEvent.current

        ArticleComponent(
            title = item.title,
            time = item.publishedTime,
            isFavorite = item.isFavorite,
            onItemClick = { event.onDetail(item)},
            onBookmarkClick = { event.onBookMark(item, it) },
            onAudioClick = { event.onAudio(item.audio) },
            onShareClick = { event.onShare(item.share) }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeBreakingNewsPreview() {
    AppTheme {
        LazyColumn {
            homeBreakingNews()
        }
    }
}