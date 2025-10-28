package com.pascal.kompasid.ui.screen.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pascal.kompasid.R
import com.pascal.kompasid.domain.model.CommonArticle
import com.pascal.kompasid.domain.model.CommonSection
import com.pascal.kompasid.ui.component.screenUtils.ArticleSection
import com.pascal.kompasid.ui.component.screenUtils.DynamicAsyncImage
import com.pascal.kompasid.ui.component.screenUtils.TextBorderComponent
import com.pascal.kompasid.ui.theme.AppTheme
import com.pascal.kompasid.ui.theme.Yellow500

@Composable
fun HomeVisualArticles(
    modifier: Modifier = Modifier,
    item: CommonSection? = null
) {
    if (item == null) return

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HorizontalDivider(
            thickness = 8.dp,
            color = MaterialTheme.colorScheme.outline
        )

        if (item.section.isNotBlank()) {
            ArticleSection(
                label = item.section,
                isExclusive = item.isExclusive
            )
        }

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(item.articles) {
                VisualArticlesItem(item = it)
            }
        }

        Text(
            modifier = Modifier.padding(vertical = 16.dp),
            text = "Geser untuk lihat lainnya →",
            style = MaterialTheme.typography.bodySmall.copy(
                color = MaterialTheme.colorScheme.inverseOnSurface
            )
        )
    }
}

@Composable
fun VisualArticlesItem(
    modifier: Modifier = Modifier,
    item: CommonArticle
) {
    Box(
        modifier = modifier
            .width(300.dp)
            .height(380.dp)
            .clip(RoundedCornerShape(12.dp))
    ) {
        DynamicAsyncImage(
            modifier = Modifier.fillMaxSize(),
            imageUrl = item.image.orEmpty(),
            placeholder = painterResource(R.drawable.no_thumbnail),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Black,
                            Color.Black.copy(alpha = 0.7f),
                            Color.Transparent
                        ),
                        startY = Float.POSITIVE_INFINITY,
                        endY = 0f
                    )
                )
                .padding(16.dp)
                .align(Alignment.BottomCenter)
        ) {
            item.label?.let {
                TextBorderComponent(
                    text = it,
                    textColor = MaterialTheme.colorScheme.onSurface,
                    color = Yellow500
                )
            }

            Spacer(Modifier.height(8.dp))

            Text(
                text = item.title,
                style = MaterialTheme.typography.headlineSmall.copy(
                    color = Color.White
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeVisualArticlesPreview() {
    AppTheme {
        HomeVisualArticles()
    }
}
