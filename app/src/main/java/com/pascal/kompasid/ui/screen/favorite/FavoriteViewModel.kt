package com.pascal.kompasid.ui.screen.favorite

import androidx.lifecycle.ViewModel
import com.pascal.kompasid.data.local.repository.LocalRepositoryImpl
import com.pascal.kompasid.data.repository.MovieRepositoryImpl

class FavoriteViewModel(
    private val repositoryImpl: MovieRepositoryImpl,
    private val database: LocalRepositoryImpl
) : ViewModel() {


}