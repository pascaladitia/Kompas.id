package com.pascal.kompasid.data.repository

import com.pascal.kompasid.data.local.repository.LocalRepositoryImpl
import com.pascal.kompasid.data.remote.api.KtorClientApi
import com.pascal.kompasid.data.remote.dtos.dashboard.DashboardResponse
import org.koin.core.annotation.Single

@Single
class NewsRepositoryImpl(
    private val localDataSource: LocalRepositoryImpl,
) : NewsRepository {
    override suspend fun dashboard(): DashboardResponse {
        return KtorClientApi.dashboard()
    }
}