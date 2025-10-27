package com.pascal.kompasid.ui.screen.home.component

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
import com.pascal.kompasid.ui.component.screenUtils.ArticleComponent
import com.pascal.kompasid.ui.component.screenUtils.DynamicAsyncImage
import com.pascal.kompasid.ui.screen.home.state.HomeUIState
import com.pascal.kompasid.ui.theme.AppTheme

fun LazyListScope.homeBreakingNews(
    modifier: Modifier = Modifier,
    uiState: HomeUIState
) {
    item {
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
                title = uiState.breakingNews?.headline,
                desc = uiState.breakingNews?.subheadline,
                time = uiState.breakingNews?.publishedTime,
                isCenter = true,
                showDivider = false
            )

            DynamicAsyncImage(
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .fillMaxWidth()
                    .height(200.dp),
                imageUrl = uiState.breakingNews?.image.orEmpty(),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
    }

    items(uiState.breakingNews?.articles.orEmpty()) { item ->
        ArticleComponent(
            title = item.title,
            time = item.publishedTime
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeArticlesPreview() {
    AppTheme {
        LazyColumn {
            homeBreakingNews(
                uiState = HomeUIState()
            )
        }
    }
}