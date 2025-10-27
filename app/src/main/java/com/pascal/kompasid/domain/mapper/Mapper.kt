package com.pascal.kompasid.domain.mapper

import com.pascal.kompasid.data.remote.dtos.dashboard.DashboardResponse
import com.pascal.kompasid.domain.model.Dashboard

fun DashboardResponse.toDomain(): Dashboard {
    return Dashboard(
        code = this.code ?: 0,
        success = this.success ?: false,
        message = this.message.orEmpty()
    )
}