package com.pascal.kompasid.ui.screen.home.component

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pascal.kompasid.R
import com.pascal.kompasid.domain.model.CommonSection
import com.pascal.kompasid.ui.component.screenUtils.ArticleSection
import com.pascal.kompasid.ui.component.screenUtils.DynamicAsyncImage
import com.pascal.kompasid.ui.theme.AppTheme

fun LazyListScope.homeHotTopics(
    item: CommonSection? = null
) {
    if (item == null) return

    item {
        ArticleSection(
            label = item.section,
            isExclusive = true,
            showIcon = false
        )
    }

    items(item.topics) { item ->
        HotTopicsItem(
            image = item.image,
            label = item.title
        )
    }

    item {
        HorizontalDivider(
            thickness = 8.dp,
            color = MaterialTheme.colorScheme.outline
        )
    }
}

@Composable
fun HotTopicsItem(
    modifier: Modifier = Modifier,
    image: String? = null,
    label: String? = null,
    onClick: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
            .fillMaxWidth()
            .border(1.dp, MaterialTheme.colorScheme.outline, RoundedCornerShape(10.dp))
            .clip(RoundedCornerShape(10.dp))
            .clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        image?.let {
            DynamicAsyncImage(
                modifier = Modifier
                    .size(60.dp),
                imageUrl = image,
                placeholder = painterResource(R.drawable.img_campaign),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }

        label?.let {
            Text(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 16.dp),
                text = label,
                style = MaterialTheme.typography.titleSmall.copy(
                    color = MaterialTheme.colorScheme.onSurface
                )
            )
        }

        Icon(
            modifier = Modifier
                .padding(16.dp)
                .size(28.dp),
            imageVector = Icons.Default.ChevronRight,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.inverseOnSurface
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeHotTopicsPreview() {
    AppTheme {
        LazyColumn {
            homeHotTopics()
        }
    }
}