package com.pascal.kompasid.data.remote.api

import com.pascal.kompasid.data.remote.client
import com.pascal.kompasid.data.remote.dtos.dashboard.DashboardResponse
import io.ktor.client.call.body
import io.ktor.client.request.get
import org.koin.core.annotation.Single

@Single
object KtorClientApi {
    suspend fun dashboard(): DashboardResponse {
        return client.get("http:///dashboard").body()
    }
}