package com.pascal.kompasid.domain.usecase.movie

import com.pascal.kompasid.domain.model.Dashboard
import kotlinx.coroutines.flow.Flow

interface MovieUseCase {
    suspend fun dashboard(): Flow<Dashboard>
}
