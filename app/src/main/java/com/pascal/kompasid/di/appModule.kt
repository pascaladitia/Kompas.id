package com.pascal.kompasid.di

import androidx.room.Room
import com.pascal.kompasid.data.local.database.AppDatabase
import com.pascal.kompasid.data.local.database.DatabaseConstants
import com.pascal.kompasid.data.local.repository.LocalRepository
import com.pascal.kompasid.data.local.repository.LocalRepositoryImpl
import com.pascal.kompasid.data.repository.NewsRepository
import com.pascal.kompasid.data.repository.NewsRepositoryImpl
import com.pascal.kompasid.domain.usecase.local.LocalUseCase
import com.pascal.kompasid.domain.usecase.local.LocalUseCaseImpl
import com.pascal.kompasid.domain.usecase.movie.NewsUseCase
import com.pascal.kompasid.domain.usecase.movie.NewsUseCaseImpl
import com.pascal.kompasid.ui.screen.detail.DetailViewModel
import com.pascal.kompasid.ui.screen.favorite.FavoriteViewModel
import com.pascal.kompasid.ui.screen.home.HomeViewModel
import com.pascal.kompasid.ui.screen.profile.ProfileViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val appModule = module {
    single {
        Room.databaseBuilder<AppDatabase>(
            androidContext(), androidContext().getDatabasePath(DatabaseConstants.DB_NAME).absolutePath)
            .setQueryCoroutineContext(Dispatchers.IO)
            .build()
    }

    singleOf(::LocalRepositoryImpl) { bind<LocalRepository>() }
    singleOf(::NewsRepositoryImpl) { bind<NewsRepository>() }

    singleOf(::LocalUseCaseImpl) { bind<LocalUseCase>() }
    singleOf(::NewsUseCaseImpl) { bind<NewsUseCase>() }

    singleOf(::HomeViewModel)
    singleOf(::FavoriteViewModel)
    singleOf(::ProfileViewModel)
    singleOf(::DetailViewModel)
}