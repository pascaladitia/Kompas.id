package com.pascal.kompasid.ui.screen.home.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pascal.kompasid.R
import com.pascal.kompasid.domain.model.LiveReport
import com.pascal.kompasid.ui.component.screenUtils.ArticleComponent
import com.pascal.kompasid.ui.component.screenUtils.ArticleTimeline
import com.pascal.kompasid.ui.component.screenUtils.DynamicAsyncImage
import com.pascal.kompasid.ui.component.screenUtils.TextBorderComponent
import com.pascal.kompasid.ui.screen.home.state.HomeUIState
import com.pascal.kompasid.ui.theme.AppTheme

fun LazyListScope.homeLiveReport(
    modifier: Modifier = Modifier,
    item: LiveReport? = null
) {
    if (item == null) return

    item {
        Column(
            modifier = modifier
                .padding(vertical = 16.dp)
                .fillMaxWidth()
        ) {
            Box {
                TextBorderComponent(
                    modifier = Modifier.padding(8.dp),
                    text = item.reportType
                )

                DynamicAsyncImage(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    imageUrl = item.mainArticle?.image.orEmpty(),
                    placeholder = painterResource(R.drawable.no_thumbnail),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(Modifier.height(16.dp))

            Text(
                modifier = Modifier.padding(horizontal = 16.dp),
                text = item.mainArticle?.category.orEmpty(),
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            )

            Spacer(Modifier.height(16.dp))

            Text(
                modifier = Modifier.padding(horizontal = 16.dp),
                text = item.mainArticle?.title.orEmpty(),
                style = MaterialTheme.typography.headlineSmall.copy(
                    color = MaterialTheme.colorScheme.onSurface
                )
            )

            Spacer(Modifier.height(16.dp))

            Text(
                modifier = Modifier.padding(horizontal = 16.dp),
                text = item.mainArticle?.publishedTime.orEmpty(),
                style = MaterialTheme.typography.bodySmall.copy(
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            )
        }
    }

    itemsIndexed(item.relatedArticles) { index, article ->
        ArticleTimeline(
            modifier = Modifier.padding(horizontal = 16.dp),
            time = article.publishedTime.orEmpty(),
            title = article.title.orEmpty(),
            showDot = index != item.relatedArticles.lastIndex
        )
    }

    items(item.featuredArticles) { item ->
        ArticleComponent(
            image = item.image,
            title = item.title
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeLiveReportPreview() {
    AppTheme {
        LazyColumn {
            homeLiveReport()
        }
    }
}