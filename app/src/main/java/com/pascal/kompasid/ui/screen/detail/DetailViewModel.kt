package com.pascal.kompasid.ui.screen.detail

import androidx.lifecycle.ViewModel
import com.pascal.kompasid.data.local.repository.LocalRepositoryImpl
import com.pascal.kompasid.data.repository.MovieRepositoryImpl

class DetailViewModel(
    private val repositoryImpl: MovieRepositoryImpl,
    private val database: LocalRepositoryImpl
) : ViewModel() {


}