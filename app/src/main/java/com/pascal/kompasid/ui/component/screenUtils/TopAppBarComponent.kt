package com.pascal.kompasid.ui.component.screenUtils

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.VolumeUp
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.FontDownload
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pascal.kompasid.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarComponent(
    modifier: Modifier = Modifier,
    leftIcon1: ImageVector? = null,
    leftIcon2: ImageVector? = null,
    rightIcon1: ImageVector? = null,
    rightIcon2: ImageVector? = null,
    rightIcon3: ImageVector? = null,
    onLeftIcon1Click: (() -> Unit)? = null,
    onLeftIcon2Click: (() -> Unit)? = null,
    onRightIcon1Click: (() -> Unit)? = null,
    onRightIcon2Click: (() -> Unit)? = null,
    onRightIcon3Click: (() -> Unit)? = null,
    logoRes: Int? = R.drawable.logo_white,
    title: String? = null
) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        title = {
            if (logoRes != null) {
                Image(
                    painter = painterResource(id = logoRes),
                    contentDescription = "App Logo",
                    modifier = Modifier.width(120.dp)
                )
            }
        },
        navigationIcon = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                leftIcon1?.let {
                    IconButton(onClick = { onLeftIcon1Click?.invoke() }) {
                        Icon(
                            imageVector = it,
                            contentDescription = "Left Icon 1",
                            tint = Color.White
                        )
                    }
                }
                leftIcon2?.let {
                    IconButton(onClick = { onLeftIcon2Click?.invoke() }) {
                        Icon(
                            imageVector = it,
                            contentDescription = "Left Icon 2",
                            tint = Color.White
                        )
                    }
                }

                if (!title.isNullOrEmpty()) {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.White
                    )
                }
            }
        },
        actions = {
            Row {
                rightIcon1?.let {
                    IconButton(onClick = { onRightIcon1Click?.invoke() }) {
                        Icon(
                            imageVector = it,
                            contentDescription = "Right Icon 1",
                            tint = Color.White
                        )
                    }
                }
                rightIcon2?.let {
                    IconButton(onClick = { onRightIcon2Click?.invoke() }) {
                        Icon(
                            imageVector = it,
                            contentDescription = "Right Icon 2",
                            tint = Color.White
                        )
                    }
                }
                rightIcon3?.let {
                    IconButton(onClick = { onRightIcon3Click?.invoke() }) {
                        Icon(
                            imageVector = it,
                            contentDescription = "Right Icon 3",
                            tint = Color.White
                        )
                    }
                }
            }
        },
        colors = androidx.compose.material3.TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onBackground,
            navigationIconContentColor = MaterialTheme.colorScheme.onBackground,
            actionIconContentColor = MaterialTheme.colorScheme.onBackground
        )
    )
}

@Preview(showBackground = true)
@Composable
fun TopAppBarComponentPreview() {
    TopAppBarComponent(
        leftIcon1 = Icons.Default.Menu,
        leftIcon2 = Icons.Default.Search,
        rightIcon1 = Icons.Default.Notifications,
        rightIcon2 = Icons.Default.Search,
        logoRes = R.drawable.logo
    )
}

@Preview(showBackground = true)
@Composable
fun TopAppBarComponentTextPreview() {
    TopAppBarComponent(
        leftIcon1 = Icons.Default.Close,
        rightIcon1 = Icons.Default.FontDownload,
        rightIcon2 = Icons.AutoMirrored.Filled.VolumeUp,
        rightIcon3 = Icons.Default.MoreVert,
        logoRes = null,
        title = "Berita Hari Ini"
    )
}

