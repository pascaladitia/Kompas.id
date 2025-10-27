package com.pascal.kompasid.data.repository

import com.pascal.kompasid.data.local.repository.LocalRepositoryImpl
import com.pascal.kompasid.data.remote.api.KtorClientApi
import com.pascal.kompasid.data.remote.dtos.dashboard.DashboardResponse
import org.koin.core.annotation.Single

@Single
class MovieRepositoryImpl(
    private val localDataSource: LocalRepositoryImpl,
) : MovieRepository {
    override suspend fun dashboard(): DashboardResponse {
        return KtorClientApi.dashboard()
    }
}