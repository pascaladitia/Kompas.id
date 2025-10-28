package com.pascal.kompasid.ui.screen.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pascal.kompasid.R
import com.pascal.kompasid.domain.model.CommonSection
import com.pascal.kompasid.ui.component.screenUtils.ArticleComponent
import com.pascal.kompasid.ui.component.screenUtils.DynamicAsyncImage
import com.pascal.kompasid.ui.component.screenUtils.TextBorderComponent
import com.pascal.kompasid.ui.theme.AppTheme

@Composable
fun HomeBriefArticles(
    modifier: Modifier = Modifier,
    item: CommonSection? = null
) {
    if (item == null) return

    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        HorizontalDivider(
            thickness = 8.dp,
            color = MaterialTheme.colorScheme.outline
        )

        val firstItem = item.articles.firstOrNull()
        if (firstItem != null) {

            item.headline?.let {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Image(
                        modifier = Modifier
                            .width(120.dp)
                            .height(40.dp),
                        painter = painterResource(R.drawable.img_kompas_brief),
                        contentDescription = null
                    )

                    Text(
                        text = item.headline,
                        style = MaterialTheme.typography.bodySmall.copy(
                            color = MaterialTheme.colorScheme.inverseOnSurface
                        )
                    )
                }
            }

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
                showDivider = false
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeBriefArticlesPreview() {
    AppTheme {
        HomeBriefArticles()
    }
}
