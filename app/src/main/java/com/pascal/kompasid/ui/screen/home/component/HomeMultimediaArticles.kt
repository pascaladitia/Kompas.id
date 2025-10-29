package com.pascal.kompasid.ui.screen.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pascal.kompasid.R
import com.pascal.kompasid.domain.model.CommonArticle
import com.pascal.kompasid.domain.model.CommonSection
import com.pascal.kompasid.ui.component.screenUtils.ArticleComponent
import com.pascal.kompasid.ui.component.screenUtils.ArticleSection
import com.pascal.kompasid.ui.component.screenUtils.DynamicAsyncImage
import com.pascal.kompasid.ui.component.screenUtils.TextBorderComponent
import com.pascal.kompasid.ui.screen.home.state.LocalHomeEvent
import com.pascal.kompasid.ui.theme.AppTheme

@Composable
fun HomeMultimediaArticles(
    modifier: Modifier = Modifier,
    item: CommonSection? = null
) {
    if (item == null) return

    val event = LocalHomeEvent.current

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

        val firstItem = item.articles.firstOrNull()
        if (firstItem != null) {
            firstItem.image?.let {
                Box {
                    DynamicAsyncImage(
                        modifier = Modifier
                            .padding(bottom = 16.dp)
                            .fillMaxWidth()
                            .height(200.dp),
                        imageUrl = firstItem.image,
                        placeholder = painterResource(R.drawable.no_thumbnail),
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )

                    if (firstItem.isExclusive) {
                        TextBorderComponent(
                            modifier = Modifier.padding(8.dp),
                            paddingValues = PaddingValues(vertical = 6.dp, horizontal = 12.dp),
                            icon = R.drawable.img_kompas,
                            text = "Eksklusif",
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }

            ArticleComponent(
                title = firstItem.title,
                desc = firstItem.description,
                time = firstItem.publishedTime,
                author = firstItem.author,
                showDivider = false,
                onItemClick = { event.onDetail(firstItem)},
                onBookmarkClick = { event.onBookMark(firstItem) },
                onAudioClick = { event.onAudio(firstItem.audio) },
                onShareClick = { event.onShare(firstItem.share) }
            )
        }

        HorizontalDivider(
            modifier = Modifier.padding(horizontal = 16.dp),
            color = MaterialTheme.colorScheme.outline
        )

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(end = 16.dp)
        ) {
            items(item.articles.drop(1)) {
                MultimediaArticlesItem(
                    item = it,
                    onItemClick = { event.onDetail(it)},
                    onBookmarkClick = { event.onBookMark(it) },
                    onAudioClick = { event.onAudio(it.audio) },
                    onShareClick = { event.onShare(it.share) }
                )
            }
        }

        item.moreLink?.let {
            Text(
                modifier = Modifier
                    .padding(start = 16.dp, bottom = 16.dp)
                    .fillMaxWidth(),
                text = item.moreLink,
                style = MaterialTheme.typography.titleMedium.copy(
                    color = MaterialTheme.colorScheme.primary
                ),
                textDecoration = TextDecoration.Underline
            )
        }

    }
}

@Composable
fun MultimediaArticlesItem(
    modifier: Modifier = Modifier,
    item: CommonArticle,
    onShareClick: () -> Unit = {},
    onBookmarkClick: () -> Unit = {},
    onAudioClick: () -> Unit = {},
    onItemClick: () -> Unit = {}
) {
    Column(
        modifier = modifier.width(380.dp)
    ) {
        Box(
            modifier = Modifier
                .padding(start = 16.dp)
                .clip(RoundedCornerShape(8.dp))
                .clickable { onItemClick() }
                .fillMaxWidth()
                .height(200.dp)
        ) {
            DynamicAsyncImage(
                modifier = Modifier
                    .fillMaxSize(),
                imageUrl = item.image.orEmpty(),
                placeholder = painterResource(R.drawable.no_thumbnail),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )

            Row(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(8.dp)
                    .background(Color.Black.copy(0.5f), RoundedCornerShape(6.dp))
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier
                        .size(16.dp),
                    imageVector = Icons.Default.CameraAlt,
                    contentDescription = null,
                    tint = Color.White
                )

                Spacer(Modifier.width(8.dp))

                item.mediaCount?.let {
                    Text(
                        text = item.mediaCount.toString(),
                        style = MaterialTheme.typography.bodyMedium.copy(
                            color = Color.White
                        )
                    )
                }
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = item.title,
                style = MaterialTheme.typography.headlineSmall.copy(
                    color = MaterialTheme.colorScheme.onSurface
                )
            )

            Spacer(Modifier.height(6.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier.weight(1f)
                ) {
                    item.label?.let {
                        Text(
                            modifier = Modifier.padding(top = 8.dp),
                            text = item.label,
                            style = MaterialTheme.typography.bodyMedium.copy(
                                color = MaterialTheme.colorScheme.primary
                            )
                        )
                    }
                }

                Icon(
                    modifier = Modifier
                        .clip(CircleShape)
                        .clickable { onShareClick() }
                        .size(42.dp),
                    painter = painterResource(R.drawable.ic_share),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Icon(
                    modifier = Modifier
                        .clip(CircleShape)
                        .clickable { onBookmarkClick() }
                        .size(42.dp),
                    painter = painterResource(R.drawable.ic_bookmark),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Icon(
                    modifier = Modifier
                        .clip(CircleShape)
                        .clickable { onAudioClick() }
                        .size(42.dp),
                    painter = painterResource(R.drawable.ic_audio),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeMultimediaArticlesPreview() {
    AppTheme {
        HomeMultimediaArticles()
    }
}
