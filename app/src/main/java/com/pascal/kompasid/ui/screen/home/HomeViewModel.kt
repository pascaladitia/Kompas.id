package com.pascal.kompasid.ui.screen.home

import android.content.Context
import android.content.Intent
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import com.pascal.kompasid.domain.model.CommonArticle
import com.pascal.kompasid.domain.usecase.local.LocalUseCase
import com.pascal.kompasid.domain.usecase.news.NewsUseCase
import com.pascal.kompasid.ui.screen.home.state.HomeUIState
import com.pascal.kompasid.utils.showToast
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val newsUseCase: NewsUseCase,
    private val localUseCase: LocalUseCase
) : ViewModel() {

    private var exoPlayer: ExoPlayer? = null

    private val _uiState = MutableStateFlow(HomeUIState())
    val uiState: StateFlow<HomeUIState> = _uiState.asStateFlow()

    fun loadHomePartOne() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }

            combine(
                newsUseCase.getAdsBanner(),
                newsUseCase.getBreakingNews(),
                newsUseCase.getHotTopics()
            ) { ads, breaking, hotTopics ->

                _uiState.value.copy(
                    isLoading = false,
                    adsBanner = ads,
                    breakingNews = breaking,
                    hotTopics = hotTopics
                )
            }.catch { e ->
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        error = true to (e.message ?: "Unknown error")
                    )
                }
            }.collect { newState ->
                _uiState.update { newState }
            }
        }
    }

    fun loadHomePartTwo() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }

            combine(
                newsUseCase.getIframeCampaign(),
                newsUseCase.getLiveReport(),
                newsUseCase.getAllCommonSections()
            ) { iframe, live, commonList ->

                _uiState.value.copy(
                    isLoading = false,
                    iframeCampaign = iframe,
                    liveReport = live,
                    articleList = commonList
                )
            }.catch { e ->
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        error = true to (e.message ?: "Unknown error")
                    )
                }
            }.collect { newState ->
                _uiState.update { newState }
            }
        }
    }

    fun modifyFavorite(context: Context, item: CommonArticle?, isFavorite: Boolean) {
        viewModelScope.launch {
            if (item == null) return@launch

            try {
                if (!isFavorite) {
                    localUseCase.insertFavorite(item)
                } else {
                    localUseCase.deleteFavorite(item)
                }
            } catch (e: Exception) {
                e.printStackTrace()
                showToast(context, "Gagal menambahkan ke favorit")
            }
        }
    }

    fun actionShareUrl(context: Context, url: String?) {
        try {
            val shareIntent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, url)
            }

            val chooser = Intent.createChooser(shareIntent, "Bagikan link ke...")
            chooser.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(chooser)

        } catch (e: Exception) {
            e.printStackTrace()
            showToast(context, "Gagal membagikan: ${e.message}")
        }
    }


    fun playAudioFromUrl(context: Context, url: String?) {
        if (url.isNullOrBlank()) return

        exoPlayer?.release()
        exoPlayer = ExoPlayer.Builder(context).build().apply {
            val mediaItem = MediaItem.fromUri(url)
            setMediaItem(mediaItem)
            prepare()
            play()
        }
    }

    fun stopAudio() {
        exoPlayer?.pause()
    }

    fun releaseAudio() {
        exoPlayer?.release()
        exoPlayer = null
    }

    fun resetError() {
        _uiState.update { it.copy(error = false to "") }
    }

    override fun onCleared() {
        super.onCleared()
        stopAudio()
    }
}

enum class NewsTab(val title: String) {
    FIRST("Berita Utama"),
    NEW("Terbaru"),
    CHOICE("Pilihanku"),
    FREE("Bebas"),
    FAVORITE("Favorit Pembaca"),
}

enum class Category(val title: String) {
    BRIEF("Brief"),
    VISUAL("Visual"),
    VIDEO("Video"),
    ROW("Row"),
    MULTIMEDIA("Multimedia")
}
