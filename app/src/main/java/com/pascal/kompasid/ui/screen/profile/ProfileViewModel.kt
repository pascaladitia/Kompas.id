package com.pascal.kompasid.ui.screen.profile

import androidx.lifecycle.ViewModel
import com.pascal.kompasid.data.local.repository.LocalRepositoryImpl
import com.pascal.kompasid.data.repository.MovieRepositoryImpl

class ProfileViewModel(
    private val repositoryImpl: MovieRepositoryImpl,
    private val database: LocalRepositoryImpl
) : ViewModel() {


}