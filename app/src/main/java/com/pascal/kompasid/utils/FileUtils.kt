package com.pascal.kompasid.utils

import android.annotation.SuppressLint
import android.content.Context
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@SuppressLint("SimpleDateFormat")
fun createImageFile(context: Context): File {
    val timeStamp = SimpleDateFormat("dd_MM_yyyy_hhmmssSSS", Locale.getDefault()).format(Date())
    val fileName = "Foto_${timeStamp}.jpg"
    val image = File.createTempFile(
        fileName,
        ".jpg",
        context.externalCacheDir
    )
    return image
}

fun addRandomParam(url: String?): String? {
    if (url == null) return null

    return when {
        url.contains("random=") -> "$url${(0..9999).random()}"
        url.contains("?random") -> "$url${(0..9999).random()}"
        else -> url
    }
}