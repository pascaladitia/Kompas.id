package com.pascal.kompasid.data.repository

import com.pascal.kompasid.data.remote.dtos.dashboard.DashboardResponse

interface MovieRepository {
    suspend fun dashboard() : DashboardResponse
}