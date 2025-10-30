package com.pascal.kompasid.ui.screen.home.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pascal.kompasid.R
import com.pascal.kompasid.domain.model.AdsBanner
import com.pascal.kompasid.ui.component.screenUtils.DynamicAsyncImage
import com.pascal.kompasid.ui.theme.AppTheme

@Composable
fun HomeBanner(
    modifier: Modifier = Modifier,
    item: AdsBanner? = null
) {
    if (item == null) return

    DynamicAsyncImage(
        modifier = modifier
            .fillMaxWidth()
            .height(380.dp),
        imageUrl = item.url,
        placeholder = painterResource(R.drawable.img_ads_banner),
        contentDescription = null,
        contentScale = ContentScale.FillBounds
    )
}

@Preview(showBackground = true)
@Composable
private fun HomeBannerPreview() {
    AppTheme {
        HomeBanner()
    }
}