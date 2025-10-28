package com.pascal.kompasid.ui.component.screenUtils

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pascal.kompasid.ui.theme.AppTheme

@Composable
fun TextBorderComponent(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = MaterialTheme.colorScheme.error,
    paddingValues: PaddingValues = PaddingValues(6.dp),
    shape: RoundedCornerShape = RoundedCornerShape(6.dp)
) {
    Box(
        modifier = modifier
            .background(color, shape)
            .clip(shape)
            .padding(paddingValues),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.titleSmall.copy(
                color = Color.White
            ),
            textAlign = TextAlign.Center,
            maxLines = 1
        )
    }
}

@Preview
@Composable
fun TextBorderPreview() {
    AppTheme {
        TextBorderComponent(text = "TEST")
    }
}
