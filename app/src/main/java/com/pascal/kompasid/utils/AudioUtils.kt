package com.pascal.kompasid.utils

private val sampleAudioUrls = listOf(
    "https://github.com/rafaelreis-hotmart/Audio-Sample-files/raw/master/sample.mp3"
)

fun getRandomAudioUrl(): String {
    return sampleAudioUrls.random()
}
